package org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships

import org.qsari.effectopedia.base.ids.ReferenceIDW
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured
import org.qsari.effectopedia.core.objects.Link
import org.qsari.effectopedia.core.objects.Link_EffectToEffect
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.aopxml.mapping.IImportContext
import org.qsari.effectopedia.data.aopxml.mapping.ElementImportHelper
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object XmlToNativeMapper {
    fun mapToNativeObject(
            srcKeyEventRelationship: Data.KeyEventRelationship,
            srcAopKeyEventRelationship: Data.Aop.KeyEventRelationships.Relationship,
            dataSource: DataSource,
            dstLink: Link_EffectToEffect,
            importContext: IImportContext) {
        dstLink.linkNature = Mapping.ToNative.linkNaturesByDetailLevel.getOrDefault(
                srcKeyEventRelationship.title?.detailLevel ?: "",
                Link.LinkNature.HYPOTHETICAL)

        // Ignoring QA because it is not possible to map AOP-XML users to Effectopedia users.
        dstLink.linkType = Mapping.ToNative.linkTypesByDirectness[srcAopKeyEventRelationship.directness ?: ""] ?: Link.LinkType.UNKNOWN

        DescriptionSectionMapper.mapToDescriptions(
                srcKeyEventRelationship,
                dstLink,
                dataSource,
                dstLink.descriptionIDs,
                importContext)

        this.populateWeightOfEvidenceDescriptionSection(srcAopKeyEventRelationship, dataSource, dstLink)

        // ElementImportHelper.importReferences(destination, destination.referenceIDs, keyEventRelationship.references)
    }

    private fun populateWeightOfEvidenceDescriptionSection(
            aopKeyEventRelationship: Data.Aop.KeyEventRelationships.Relationship,
            dataSource: DataSource,
            destination: Link_EffectToEffect) {
        val weightOfEvidence = destination.descriptionIDs.getCachedObject(DefaultEffectopediaObjects.LINK_WOE_INDEX) as DescriptionSection_Structured
        val reference = DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_R.clone(destination, dataSource)
        reference.set(destination)
        reference.weight = ElementImportHelper.confidenceLevelValueToNumericWeight(aopKeyEventRelationship.evidence)
        reference.bringToLive()
        weightOfEvidence.structuredContent = reference
        weightOfEvidence.structuredContentClass = ReferenceIDW::class.java
    }
}
