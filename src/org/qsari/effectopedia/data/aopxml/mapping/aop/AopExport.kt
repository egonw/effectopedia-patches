package org.qsari.effectopedia.data.aopxml.mapping.aop

import org.qsari.effectopedia.base.ids.ReferenceIDW
import org.qsari.effectopedia.core.objects.*
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.aopxml.mapping.ExportContext
import org.qsari.effectopedia.data.aopxml.mapping.ElementExportHelper
import org.qsari.effectopedia.data.aopxml.mapping.chemical.ChemicalMapper
import org.qsari.effectopedia.data.aopxml.objects.ConfidenceLevelType
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.data.aopxml.objects.Status
import org.qsari.effectopedia.data.aopxml.objects.WikiStatus
import org.qsari.effectopedia.data.objects.DataValue_String
import org.qsari.effectopedia.data.aopxml.mapping.key_event.NativeToXmlMapper as EffectToXmlMapper
import org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships.NativeToXmlMapper as LinkToXmlMapper
import java.util.*
import kotlin.collections.HashSet

class AopExport(private val _dataSource: DataSource) {
    private val _exportContext = ExportContext()
    private var _complete: Boolean = false

    val exportedData: Data = Data()

    fun execute() {
        if (this._complete) {
            throw IllegalStateException("Export can only be run once.")
        }

        for (srcPathway in this._dataSource.liveIndices.pathways) {
            if (srcPathway.value == null) continue
            val dstAop = this.exportPathway(srcPathway.value)
            this._exportContext.aops.add(dstAop)
        }

        this._exportContext.populate(this.exportedData)
        this._complete = true
    }

    private fun exportPathway(srcPathway: Pathway): Data.Aop {
        val dstAop = Data.Aop().apply { this.id = UUID.randomUUID()!!.toString() }
        this.mapPropertiesAndDescriptionSections(srcPathway, dstAop)
        this.mapPathwayChain(srcPathway, dstAop)

        val history = ElementExportHelper.getElementChangeHistory(srcPathway)
        if (history != null) {
            dstAop.creationTimestamp = history.creationTimestamp
            dstAop.lastModificationTimestamp = history.lastModificationTimestamp
        }

        return dstAop
    }

    private fun mapPropertiesAndDescriptionSections(srcPathway: Pathway, dstAop: Data.Aop) {
        dstAop.title = srcPathway.title?.trim() ?: ""
        dstAop.authors = ""
        this.mapShortName(srcPathway, dstAop)
        this.mapStatuses(srcPathway, dstAop)
        DescriptionSectionMapper.mapToXmlObject(dstAop, srcPathway.descriptionIDs, this._exportContext)
    }

    private fun mapShortName(srcPathway: Pathway, dstAop: Data.Aop) {
        for (uidContainer in srcPathway.uids?.value ?: listOf<DataValue_String>()) {
            val uidParts = uidContainer.value.split(':', limit = 2)
            if (uidParts.size != 2) continue

            if (uidParts[0] == "SHORTNAME") {
                dstAop.shortName = uidParts[1]
                break
            }

            // Ignore
        }

        if (dstAop.shortName.isNullOrBlank()) {
            dstAop.shortName = srcPathway.title?.trim() ?: ""
        }
    }

    private fun mapStatuses(srcPathway: Pathway, dstAop: Data.Aop) {
        dstAop.status = Status().apply {
            this.wikiStatus = WikiStatus.UnderDevelopmentNotOpenForCommentDoNotCite.value
        }

        for (status in srcPathway.status?.value ?: listOf<DataValue_String>()) {
            val statusParts = status.value.split(':', limit = 2)
            if (statusParts.size != 2) continue
            val (enumType, enumString) = statusParts
            when (enumType) {
                "AOPWIKI" -> dstAop.status.wikiStatus = Mapping.ToNative.wikiStatusMapper.getConstant(enumString).value
                "OECD" -> dstAop.status.oecdStatus = Mapping.ToNative.oecdStatusMapper.getConstant(enumString).value
                "SAAOP" -> dstAop.status.saaopStatus = Mapping.ToNative.saaopStatusMapper.getConstant(enumString).value
            }
        }
    }

    private fun mapPathwayChain(srcPathway: Pathway, dstAop: Data.Aop) {
        if (srcPathway.elements.cachedObjects == null) return

        val processedElements = HashSet<PathwayElement>()
        for (srcElement in srcPathway.elements.cachedObjects.asSequence().filterNotNull()) {
            when (srcElement) {
                is Initiator -> this.exportUniqueInitiator(srcElement, srcPathway, dstAop, processedElements)
                is Effect -> this.exportUniqueEffect(srcElement, srcPathway, dstAop, processedElements)
                is Link -> this.exportUniqueRelationship(srcElement, srcPathway, dstAop, processedElements)
            }
        }
    }

    private fun exportUniqueInitiator(
            srcElement: Initiator,
            srcPathway: Pathway,
            dstAop: Data.Aop,
            processedElements: HashSet<PathwayElement>): Data.Stressor {
        if (!processedElements.add(srcElement)) {
            return this._exportContext.stressorsByNativeInitiator.getValue(srcElement)
        }

        val dstStressor = this._exportContext.stressorsByNativeInitiator.getOrPut(srcElement, {
            Data.Stressor().apply {
                this.id = UUID.randomUUID()!!.toString()
                this.name = srcElement.title!!

                when (srcElement) {
                    is Initiator_BiologcalPerturbation -> this.description = srcElement.descriptionIDs.cachedObjects
                            .mapNotNull { it.content }
                            .firstOrNull() ?: ""

                    is Initiator_ChemicalStructure -> {
                        val chemical = this@AopExport.exportUniqueChemical(srcElement)
                        val chemicalInitiator = Data.Stressor.Chemicals.ChemicalInitiator().apply {
                            this.chemicalId = chemical.id
                            this.userTerm = srcElement.title!!
                        }
                        this.chemicals = this.chemicals ?: Data.Stressor.Chemicals()
                        this.chemicals.chemicalInitiator.add(chemicalInitiator)
                    }
                }

                val history = ElementExportHelper.getElementChangeHistory(srcElement)
                if (history != null) {
                    this.creationTimestamp = history.creationTimestamp
                    this.lastModificationTimestamp = history.lastModificationTimestamp
                }
            }
        })

        srcPathway.updateEssentiality()
        val holder = srcPathway.essentiality.getEssentialityDescription(srcElement) ?: return dstStressor
        val essentiality = holder.structuredContent as? ReferenceIDW<*> ?: return dstStressor

        dstAop.aopStressors.aopStressor.add(Data.Aop.AopStressors.AopStressor().apply {
            this.evidence = ElementExportHelper.numericWeightToConfidenceValue(essentiality.weight)
            this.stressorId = dstStressor.id
        })

        return dstStressor
    }

    private fun exportUniqueChemical(srcElement: Initiator_ChemicalStructure): Data.Chemical {
        return this._exportContext.chemicalsByNativeChemical.getOrPut(srcElement, {
            val dst = Data.Chemical().apply { this.id = UUID.randomUUID()!!.toString() }
            ChemicalMapper.mapToXmlObject(srcElement, dst, this._exportContext)
            this._exportContext.chemicalsByXmlId.putIfAbsent(dst.id, dst)
            dst
        })
    }

    private fun exportUniqueEffect(
            srcEffect: Effect,
            srcPathway: Pathway,
            dstAop: Data.Aop,
            processedElements: HashSet<PathwayElement>): Data.KeyEvent {
        if (!processedElements.add(srcEffect)) {
            return this._exportContext.keyEventsByNativeEffect.getValue(srcEffect)
        }

        val dstKeyEvent = this._exportContext.keyEventsByNativeEffect.getOrPut(srcEffect, {
            val dst = Data.KeyEvent().apply { this.id = UUID.randomUUID()!!.toString() }
            EffectToXmlMapper.mapToXmlObject(srcEffect, dst, this._exportContext)
            this._exportContext.keyEventsByXmlId.putIfAbsent(dst.id, dst)
            dst
        })

        when (srcEffect) {
            is Effect_MolecularInitiatingEvent -> {
                val mieReference = Data.Aop.MolecularInitiatingEvent().apply { this.keyEventId = dstKeyEvent.id }
                dstAop.molecularInitiatingEvent.add(mieReference)
            }
            is Effect_AdverseOutcome -> {
                val aoReference = Data.Aop.AdverseOutcome().apply { this.keyEventId = dstKeyEvent.id }
                dstAop.adverseOutcome.add(aoReference)
            }
        }

        val holder = srcPathway.essentiality.getEssentialityDescription(srcEffect) ?: return dstKeyEvent
        val essentiality = holder.structuredContent as? ReferenceIDW<*> ?: return dstKeyEvent

        dstAop.keyEventEssentialities = dstAop.keyEventEssentialities ?: Data.Aop.KeyEventEssentialities()
        dstAop.keyEventEssentialities.essentiality.add(Data.Aop.KeyEventEssentialities.Essentiality().apply {
            this.essentialityLevel = ElementExportHelper.numericWeightToConfidenceValue(essentiality.weight)
            this.keyEventId = dstKeyEvent.id
        })

        return dstKeyEvent
    }

    private fun exportUniqueRelationship(srcLink: Link, srcPathway: Pathway, dstAop: Data.Aop, processedElements: HashSet<PathwayElement>) {
        when (srcLink) {
            is Link_ChemStructToMIE -> {
                this.exportUniqueEffect(srcLink.effect.cachedObject!!, srcPathway, dstAop, processedElements)
                this.exportUniqueInitiator(srcLink.structure.cachedObject!!, srcPathway, dstAop, processedElements)
            }

            is Link_EffectToEffect -> {
                val upstreamKeyEvent = this.exportUniqueEffect(
                        srcLink.fromEffect.cachedObject!!,
                        srcPathway,
                        dstAop,
                        processedElements)

                val downstreamKeyEvent = this.exportUniqueEffect(
                        srcLink.toEffect.cachedObject!!,
                        srcPathway,
                        dstAop,
                        processedElements)

                val candidateKeyEventRelationship = Data.KeyEventRelationship().apply { this.id = UUID.randomUUID()!!.toString() }
                LinkToXmlMapper.mapToKeyEventRelationship(
                        srcLink,
                        candidateKeyEventRelationship,
                        upstreamKeyEvent.id,
                        downstreamKeyEvent.id,
                        this._exportContext)
                val hash = ElementExportHelper.getKeyEventRelationshipHash(candidateKeyEventRelationship)

                val dstKeyEventRelationship = this._exportContext.keyEventRelationshipsByNativeLinkHash.getOrPut(hash, {
                    candidateKeyEventRelationship
                })
                this._exportContext.keyEventRelationshipsByXmlId.putIfAbsent(dstKeyEventRelationship.id, dstKeyEventRelationship)

                val dstAopKeyEventRelationship = Data.Aop.KeyEventRelationships.Relationship().apply {
                    this.id = dstKeyEventRelationship.id
                    this.quantitativeUnderstandingValue = ConfidenceLevelType.NOT_SPECIFIED
                    LinkToXmlMapper.mapToAopKeyEventRelationship(srcLink, this)
                }
                dstAop.keyEventRelationships = dstAop.keyEventRelationships ?: Data.Aop.KeyEventRelationships()
                dstAop.keyEventRelationships.relationship.add(dstAopKeyEventRelationship)

                val holder = srcPathway.essentiality.getEssentialityDescription(srcLink) ?: return
                val essentiality = holder.structuredContent as? ReferenceIDW<*> ?: return
                dstAopKeyEventRelationship.evidence = ElementExportHelper.numericWeightToConfidenceValue(essentiality.weight)
            }
        }
    }
}
