package org.qsari.effectopedia.data.aopxml.mapping.aop

import org.qsari.effectopedia.base.ids.ReferenceIDs
import org.qsari.effectopedia.core.objects.*
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.aopxml.mapping.IImportContext
import org.qsari.effectopedia.data.aopxml.mapping.ElementImportHelper
import org.qsari.effectopedia.data.aopxml.mapping.chemical.ChemicalMapper
import org.qsari.effectopedia.data.aopxml.mapping.key_event.XmlToNativeMapper as KeyEventToNativeMapper
import org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships.XmlToNativeMapper as KeyEventRelationshipToNativeMapper
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.data.objects.DataValue_String
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects
import java.util.*

class AopImport(private val _dataSource: DataSource, private val _context: IImportContext) {
    private val _importedChemicalIdsByXmlId = mapOf<String, Long>()
    private val _importedEffectIdsByXmlId = mapOf<String, Long>()

    private var _complete = false

    fun execute() {
        if (this._complete) {
            throw IllegalStateException("Import can only be run once.")
        }

        for (srcAop in this._context.aops) {
            this.importPathway(srcAop)
        }

        this._complete = true
    }

    private fun importPathway(srcAop: Data.Aop) {
        val dstPathway = Pathway(null, this._dataSource)
        this.mapPropertiesAndDescriptionSections(srcAop, dstPathway)
        this.mapPathwayChain(srcAop, dstPathway)
        dstPathway.updateEssentiality()
        this._dataSource.bringToLive(dstPathway.javaClass, dstPathway)
        ElementImportHelper.addTimestamps(
                dstPathway,
                dstPathway.dataSource,
                srcAop.creationTimestamp,
                srcAop.lastModificationTimestamp)
    }

    private fun mapPropertiesAndDescriptionSections(srcAop: Data.Aop, dstPathway: Pathway) {
        dstPathway.title = srcAop.title
        dstPathway.setUids("SHORTNAME:" + srcAop.shortName)

        val srcStatuses = srcAop.status
        if (srcStatuses != null) {
            addStatus(dstPathway, "OECD", srcStatuses.oecdStatus)
            addStatus(dstPathway, "SAAOP", srcStatuses.saaopStatus)
            addStatus(dstPathway, "AOPWIKI", srcStatuses.wikiStatus)
        }

        // Disabled because we have to parse HTML to make reference lines.
        // ElementImportHelper.importReferences(dstPathway, dstPathway.referenceIDs, srcAop.references);
        DescriptionSectionMapper.mapToDescriptions(
                srcAop,
                dstPathway,
                dstPathway.dataSource,
                dstPathway.descriptionIDs,
                this._context)
    }

    private fun addStatus(dstPathway: Pathway, prefix: String, srcStatusValue: String?) {
        if (dstPathway.status?.value == null || srcStatusValue == null) {
            return
        }

        val dstStatuses = dstPathway.status.value
        val dstStatus = DataValue_String()
        dstStatus.value = prefix + ":" + srcStatusValue
        dstStatuses.add(dstStatus)
    }

    private fun mapPathwayChain(srcAop: Data.Aop, dstPathway: Pathway) {
        // Ignoring entire AOP stressors as there is no equivalent in effectopedia.

        val referencedKeyEventIds = HashSet<String>()

        val molecularInitiatingEventsBySrcKeyEventXmlId = this.importMolecularInitiatingEventsAndGetMapBySrcKeyEventXmlIds(
                srcAop,
                dstPathway)

        val adverseOutcomesBySrcKeyEventXmlId = this.importAdverseOutcomesAndGetMapBySrcKeyEventXmlIds(
                srcAop,
                dstPathway)

        val centralEffectsBySrcKeyEventXmlId = this.importCentralEffectChainAndGetMapBySrcXmlId(
                srcAop,
                dstPathway,
                molecularInitiatingEventsBySrcKeyEventXmlId,
                adverseOutcomesBySrcKeyEventXmlId,
                referencedKeyEventIds)

        this.importEffectEssentialities(
                srcAop,
                dstPathway,
                molecularInitiatingEventsBySrcKeyEventXmlId,
                adverseOutcomesBySrcKeyEventXmlId,
                centralEffectsBySrcKeyEventXmlId)
    }

    private fun importMolecularInitiatingEventsAndGetMapBySrcKeyEventXmlIds(
            srcAop: Data.Aop,
            dstPathway: Pathway): Map<String, Effect> {
        val molecularInitiatingEventsBySrcKeyEventXmlId = HashMap<String, Effect>()
        val srcMolecularInitiatingEvents = srcAop.molecularInitiatingEvent
                ?: return molecularInitiatingEventsBySrcKeyEventXmlId

        for (srcMolecularInitiatingEvent in srcMolecularInitiatingEvents) {
            val srcKeyEventId = srcMolecularInitiatingEvent.keyEventId
            val srcKeyEvent = this._context.keyEventsByXmlId.getValue(srcKeyEventId)

            val dstMolecularInitiatingEvent = this.importOrCloneEffect(
                    srcAop,
                    srcKeyEvent,
                    dstPathway,
                    Effect_MolecularInitiatingEvent::class.java,
                    { Effect_MolecularInitiatingEvent(dstPathway, dstPathway.dataSource) })

            this.importAndLinkChemicalInitiators(srcAop, srcKeyEvent, dstPathway, dstMolecularInitiatingEvent)
            molecularInitiatingEventsBySrcKeyEventXmlId.put(srcKeyEventId, dstMolecularInitiatingEvent)
        }

        return molecularInitiatingEventsBySrcKeyEventXmlId
    }

    private fun importAndLinkChemicalInitiators(srcAop: Data.Aop,
                                                srcKeyEvent: Data.KeyEvent,
                                                dstPathway: Pathway,
                                                dstEffect: Effect_MolecularInitiatingEvent) {
        srcKeyEvent.keyEventStressors
                ?.keyEventStressor
                ?.map { this._context.stressorsByXmlId.getValue(it.stressorId) }
                ?.forEach { this.importAndLinkStressorChemicalInitiator(dstPathway, dstEffect, it) }

        srcAop.aopStressors
                ?.aopStressor
                ?.map { this._context.stressorsByXmlId.getValue(it.stressorId) }
                ?.forEach { this.importAndLinkStressorChemicalInitiator(dstPathway, dstEffect, it) }
    }

    private fun importAndLinkStressorChemicalInitiator(dstPathway: Pathway,
                                                       dstEffect: Effect_MolecularInitiatingEvent,
                                                       srcStressor: Data.Stressor) {
        for (srcChemicalInitiator in srcStressor.chemicals.chemicalInitiator) {
            val srcChemical = this._context.chemicalsByXmlId.getValue(srcChemicalInitiator.chemicalId)
            val dstInitiator = this.importOrCloneChemical(dstPathway, srcChemical)

            val link = Link_ChemStructToMIE(
                    dstPathway,
                    this._dataSource,
                    dstInitiator,
                    dstEffect)
            link.linkType = Link.LinkType.UNKNOWN
            link.linkNature = Link.LinkNature.HYPOTHETICAL
            link.bringToLive()
        }
    }

    private fun importAdverseOutcomesAndGetMapBySrcKeyEventXmlIds(
            srcAop: Data.Aop,
            dstPathway: Pathway): Map<String, Effect> {
        val adverseOutcomesBySrcKeyEventXmlId = HashMap<String, Effect>()
        val srcAdverseOutcomes = srcAop.adverseOutcome ?: return adverseOutcomesBySrcKeyEventXmlId

        for (srcAdverseOutcome in srcAdverseOutcomes) {
            val srcKeyEventId = srcAdverseOutcome.keyEventId
            val srcKeyEvent = this._context.keyEventsByXmlId.getValue(srcKeyEventId)

            val dstAdverseOutcome = this.importOrCloneEffect(
                    srcAop, srcKeyEvent, dstPathway,
                    Effect_AdverseOutcome::class.java,
                    { Effect_AdverseOutcome(dstPathway, dstPathway.dataSource) })

            // Ignoring adverse outcome event stressors: Effectopedia does not support linking chemicals to anything other than MIE.
            adverseOutcomesBySrcKeyEventXmlId.put(srcKeyEventId, dstAdverseOutcome)
        }

        return adverseOutcomesBySrcKeyEventXmlId
    }

    private fun importCentralEffectChainAndGetMapBySrcXmlId(
            srcAop: Data.Aop,
            dstPathway: Pathway,
            molecularInitiatingEventsBySrcKeyEventXmlId: Map<String, Effect>,
            adverseOutcomesBySrcKeyEventXmlId: Map<String, Effect>,
            referencedKeyEventIds: MutableSet<String>): Map<String, Effect> {
        val linkEssentialityReferenceHolderList = this.createPathwayEssentialityDescriptionSectionAndReturnReferenceHolderList(
                dstPathway,
                DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_DSS)

        val centralEffectsBySrcKeyEventXmlId = HashMap<String, Effect>()
        if (srcAop.keyEventRelationships == null) {
            return centralEffectsBySrcKeyEventXmlId
        }

        for (srcAopKeyEventRelationship in srcAop.keyEventRelationships.relationship) {
            val srcKeyEventRelationship = this._context.keyEventRelationshipsByXmlId.getValue(srcAopKeyEventRelationship.id)

            if (srcKeyEventRelationship.title == null) {
                continue
            }

            val srcUpstreamKeyEventId = srcKeyEventRelationship.title.upstreamId
            val srcUpstreamKeyEvent = this._context.keyEventsByXmlId.getValue(srcUpstreamKeyEventId)

            val srcDownstreamKeyEventId = srcKeyEventRelationship.title.downstreamId
            val srcDownstreamKeyEvent = this._context.keyEventsByXmlId.getValue(srcDownstreamKeyEventId)

            val dstUpstreamEffect = this.getExistingPathwayEffectOrImportOrClone(
                    srcAop,
                    srcUpstreamKeyEvent,
                    dstPathway,
                    molecularInitiatingEventsBySrcKeyEventXmlId,
                    centralEffectsBySrcKeyEventXmlId
            )

            val linkWillCauseCircularReference = !referencedKeyEventIds.add(srcDownstreamKeyEventId)
            if (linkWillCauseCircularReference) {
                continue
            }

            val dstDownstreamEffect = this.getExistingPathwayEffectOrImportOrClone(
                    srcAop, srcDownstreamKeyEvent, dstPathway,
                    adverseOutcomesBySrcKeyEventXmlId,
                    centralEffectsBySrcKeyEventXmlId
            )

            // Ignoring individual event stressors: Effectopedia does not support linking chemicals to anything other than MIE.

            val dstLink = Link_EffectToEffect(
                    dstPathway,
                    this._dataSource,
                    dstUpstreamEffect,
                    dstDownstreamEffect)

            KeyEventRelationshipToNativeMapper.mapToNativeObject(
                    srcKeyEventRelationship,
                    srcAopKeyEventRelationship,
                    dstPathway.dataSource,
                    dstLink,
                    this._context)

            dstLink.bringToLive()

            ElementImportHelper.importLinkEssentialityToPathway(
                    dstLink,
                    srcAopKeyEventRelationship.evidence,
                    dstPathway,
                    linkEssentialityReferenceHolderList)

            ElementImportHelper.addTimestamps(
                    dstLink,
                    dstPathway.dataSource,
                    srcKeyEventRelationship.creationTimestamp,
                    srcKeyEventRelationship.lastModificationTimestamp)
        }

        return centralEffectsBySrcKeyEventXmlId
    }

    private fun importEffectEssentialities(aop: Data.Aop,
                                           pathway: Pathway,
                                           molecularInitiatingEventsBySrcKeyEventXmlId: Map<String, Effect>,
                                           adverseOutcomesBySrcKeyEventXmlId: Map<String, Effect>,
                                           centralEffectsBySrcKeyEventXmlId: Map<String, Effect>) {
        val effectEssentialityReferenceHolderList = this.createPathwayEssentialityDescriptionSectionAndReturnReferenceHolderList(
                pathway,
                DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_DSS)

        val srcKeyEventEssentialities = aop.keyEventEssentialities?.essentiality ?: return

        for (srcKeyEventEssentiality in srcKeyEventEssentialities) {
            val srcKeyEventXmlId = srcKeyEventEssentiality.keyEventId

            val destination = molecularInitiatingEventsBySrcKeyEventXmlId[srcKeyEventXmlId]
                    ?: adverseOutcomesBySrcKeyEventXmlId[srcKeyEventXmlId]
                    ?: centralEffectsBySrcKeyEventXmlId[srcKeyEventXmlId]
                    ?: continue

            ElementImportHelper.importEffectEssentialityToPathway(
                    destination,
                    srcKeyEventEssentiality.essentialityLevel,
                    pathway,
                    effectEssentialityReferenceHolderList)

            KeyEventToNativeMapper.importEssentiality(destination, srcKeyEventEssentiality)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun createPathwayEssentialityDescriptionSectionAndReturnReferenceHolderList(
            dst: Pathway,
            template: DescriptionSection_Structured): ReferenceIDs<DescriptionSection_Structured> {
        val essentiality = template.clone(dst, dst.dataSource)

        val referenceHolderDescriptionSectionList = essentiality.structuredContent as? ReferenceIDs<DescriptionSection_Structured>
                ?: throw IllegalStateException("Unexpected essentiality.structuredContent type: ${essentiality.structuredContent::class.java.name}")

        referenceHolderDescriptionSectionList.bringToLive()
        essentiality.bringToLive()
        dst.descriptionIDs.add(essentiality)
        return referenceHolderDescriptionSectionList
    }

    private fun getExistingPathwayEffectOrImportOrClone(srcAop: Data.Aop,
                                                        srcKeyEvent: Data.KeyEvent,
                                                        dstPathway: Pathway,
                                                        dstPeripheralEffectsBySrcKeyEventXmlId: Map<String, Effect>,
                                                        dstCentralEffectsBySrcKeyEventXmlId: MutableMap<String, Effect>): Effect {
        var dstEffect: Effect? = dstPeripheralEffectsBySrcKeyEventXmlId[srcKeyEvent.id]
        if (dstEffect == null) {
            dstEffect = dstCentralEffectsBySrcKeyEventXmlId[srcKeyEvent.id]
            if (dstEffect == null) {
                dstEffect = this.importOrCloneEffect(
                        srcAop, srcKeyEvent, dstPathway,
                        Effect_DownstreamEffect::class.java,
                        { Effect_DownstreamEffect(dstPathway, dstPathway.dataSource) })

                dstCentralEffectsBySrcKeyEventXmlId.put(srcKeyEvent.id, dstEffect)
            }
        }

        return dstEffect
    }

    private fun <TEffect : Effect> importOrCloneEffect(srcAop: Data.Aop?,
                                                       srcKeyEvent: Data.KeyEvent,
                                                       dstPathway: Pathway,
                                                       dstEffectClass: Class<TEffect>,
                                                       dstEffectFactory: () -> TEffect): TEffect {
        if (srcAop == null) {
            throw IllegalArgumentException("srcAop cannot be null")
        }

        return ElementImportHelper.importNewOrCloneExistingPathwayElement(
                dstPathway,
                dstEffectClass,
                dstEffectFactory,
                this._importedEffectIdsByXmlId,
                srcKeyEvent,
                srcKeyEvent.id,
                { src, dst -> KeyEventToNativeMapper.mapToNativeObject(src, srcAop, this._dataSource, dst, this._context) },
                srcKeyEvent.creationTimestamp,
                srcKeyEvent.lastModificationTimestamp)
    }

    private fun importOrCloneChemical(
            dstPathway: Pathway,
            srcChemical: Data.Chemical): Initiator_ChemicalStructure {
        return ElementImportHelper.importNewOrCloneExistingPathwayElement(
                dstPathway,
                Initiator_ChemicalStructure::class.java,
                { Initiator_ChemicalStructure(dstPathway, dstPathway.dataSource) },
                this._importedChemicalIdsByXmlId,
                srcChemical,
                srcChemical.id,
                { src, dst -> ChemicalMapper.mapToNativeObject(src, dst, this._context) },
                null,
                null)
    }
}
