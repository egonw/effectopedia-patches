package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.base.EffectopediaObject
import org.qsari.effectopedia.base.ids.ReferenceID
import org.qsari.effectopedia.base.ids.ReferenceIDW
import org.qsari.effectopedia.base.ids.ReferenceIDs
import org.qsari.effectopedia.core.Effectopedia
import org.qsari.effectopedia.core.objects.*
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.aopxml.objects.ConfidenceLevelType
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects
import org.qsari.effectopedia.history.EditHistoryItem_Object
import org.qsari.effectopedia.system.ActionTypes
import org.qsari.effectopedia.system.TraceableClasses
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar

object ElementImportHelper {
    fun <TXmlObject, TElement : PathwayElement> importNewOrCloneExistingPathwayElement(
            dstPathway: Pathway,
            dstElementClass: Class<TElement>,
            dstElementFactory: () -> TElement,
            dstElementIdsByXmlId: Map<String, Long>,
            srcXmlObject: TXmlObject,
            srcXmlId: String,
            propertyMapper: ((TXmlObject, TElement) -> Unit)?,
            creationTimestamp: XMLGregorianCalendar?,
            lastModificationTimestamp: XMLGregorianCalendar?): TElement {
        if (srcXmlObject == null) throw IllegalArgumentException("srcXmlObject cannot be null")

        val srcChemicalId = dstElementIdsByXmlId.getOrDefault(srcXmlId, 0L)
        val dstElement = dstElementFactory()

        if (srcChemicalId == 0L) {
            propertyMapper?.invoke(srcXmlObject, dstElement)
            addTimestamps(
                    dstElement,
                    dstPathway.dataSource,
                    creationTimestamp,
                    lastModificationTimestamp)
        } else {
            val existingElement = dstPathway.dataSource.get(dstElementClass, srcChemicalId)
            existingElement.cloneFieldsTo(dstElement)
        }

        dstPathway.dataSource.bringToLive(dstElement.javaClass, dstElement)
        dstPathway.dataSource.updateExternalIDs()
        return dstElement
    }

    fun addTimestamps(
            dst: EffectopediaObject,
            dataSource: DataSource,
            creationTimestamp: XMLGregorianCalendar?,
            lastModificationTimestamp: XMLGregorianCalendar?) {
        val stampDate = lastModificationTimestamp ?: creationTimestamp ?: return

        val editHistory = dataSource.editHistory
        val classID = TraceableClasses.REGISTERED.getClassID(dst.javaClass)

        // WARNING: Effectopedia singleton access. Forced to use it because adding a history item modifies its editLog member.
        val stampId = Effectopedia.EFFECTOPEDIA.newStamp(ActionTypes.CREATE_OBJECT.toLong())
        val stamp = Effectopedia.EFFECTOPEDIA.stamps[stampId.toInt()]

        stamp.date = stampDate.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).time
        editHistory.add(EditHistoryItem_Object(dst.id, dst.id, classID), stamp.id)
        editHistory.modified.add(dst)
    }

    fun importEffectEssentialityToPathway(target: Effect,
                                                   confidenceLevel: ConfidenceLevelType,
                                                   pathway: Pathway,
                                                   referenceHolderDescriptionSectionList: ReferenceIDs<DescriptionSection_Structured>) {
        this.importEssentialityToPathway(
                target,
                confidenceLevel,
                Effect::class.java,
                pathway,
                referenceHolderDescriptionSectionList,
                DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_DS)
    }

    fun importLinkEssentialityToPathway(target: Link_EffectToEffect,
                                                 confidenceLevel: ConfidenceLevelType,
                                                 pathway: Pathway,
                                                 referenceHolderDescriptionSectionList: ReferenceIDs<DescriptionSection_Structured>) {
        importEssentialityToPathway(
                target,
                confidenceLevel,
                Link_EffectToEffect::class.java,
                pathway,
                referenceHolderDescriptionSectionList,
                DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_DS)
    }

    private fun <TElement : EffectopediaObject> importEssentialityToPathway(
            target: TElement,
            confidenceLevel: ConfidenceLevelType,
            elementClass: Class<TElement>,
            pathway: Pathway,
            referenceHolderDescriptionSectionList: ReferenceIDs<DescriptionSection_Structured>,
            templateDescriptionStructured: DescriptionSection_Structured) {
        val weight = confidenceLevelValueToNumericWeight(confidenceLevel)
        val referenceWithConfidenceLevel = ReferenceIDW(pathway, pathway.dataSource, elementClass, weight)
        referenceWithConfidenceLevel.set(target)
        referenceWithConfidenceLevel.bringToLive()
        val referenceWithConfidenceLevelHolder = templateDescriptionStructured.clone(
                pathway,
                pathway.dataSource)
        referenceWithConfidenceLevelHolder.structuredContent = referenceWithConfidenceLevel
        referenceWithConfidenceLevelHolder.structuredContentClass = ReferenceIDW::class.java
        referenceWithConfidenceLevelHolder.bringToLive()
        referenceHolderDescriptionSectionList.add(referenceWithConfidenceLevelHolder)
    }

    fun confidenceLevelValueToNumericWeight(confidenceLevel: ConfidenceLevelType): Double {
        // These are indices into the DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS array.
        when (confidenceLevel) {
            ConfidenceLevelType.STRONG -> return 3.0
            ConfidenceLevelType.MODERATE -> return 2.0
            ConfidenceLevelType.WEAK -> return 1.0
            else -> return 0.0
        }
    }

    fun importReferences(owner: EffectopediaObject, referenceIDs: ReferenceIDs<Reference>, references: String) {
        val reference = DefaultEffectopediaObjects.DEFAULT_REFERENCE.clone(owner, owner.dataSource)
        reference.formatedReference = references
        reference.bringToLive()
        referenceIDs.add(reference)
    }
}
