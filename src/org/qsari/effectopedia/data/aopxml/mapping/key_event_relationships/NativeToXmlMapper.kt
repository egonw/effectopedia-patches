package org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships

import org.qsari.effectopedia.core.objects.Link
import org.qsari.effectopedia.data.aopxml.mapping.ElementExportHelper
import org.qsari.effectopedia.data.aopxml.mapping.ExportContext
import org.qsari.effectopedia.data.aopxml.objects.Data

object NativeToXmlMapper {
    fun mapToKeyEventRelationship(
            srcLink: Link,
            dstKeyEventRelationship: Data.KeyEventRelationship,
            upstreamEventXmlId: String,
            downstreamEventXmlId: String,
            exportContext: ExportContext) {
        dstKeyEventRelationship.title = (dstKeyEventRelationship.title ?: Data.KeyEventRelationship.Title()).apply {
            this.upstreamId = upstreamEventXmlId
            this.downstreamId = downstreamEventXmlId
            this.detailLevel = Mapping.ToXml.detailLevelsByLinkNature[srcLink.linkNature]
                    ?: Mapping.ToXml.detailLevelsByLinkNature[Link.LinkNature.HYPOTHETICAL]
        }

        DescriptionSectionMapper.mapToXmlObject(dstKeyEventRelationship, srcLink.descriptionIDs, exportContext)
        if (dstKeyEventRelationship.description == null) {
            dstKeyEventRelationship.description = ""
        }

        val history = ElementExportHelper.getElementChangeHistory(srcLink)
        if (history != null) {
            dstKeyEventRelationship.creationTimestamp = history.creationTimestamp
            dstKeyEventRelationship.lastModificationTimestamp = history.lastModificationTimestamp
        }
    }

    fun mapToAopKeyEventRelationship(srcLink: Link, dstAopKeyEventRelationship: Data.Aop.KeyEventRelationships.Relationship) {
        dstAopKeyEventRelationship.directness = Mapping.ToXml.directnessValuesByLinkType[srcLink.linkType ?: Link.LinkType.DIRECT]
                ?: Mapping.ToXml.directnessValuesByLinkType[Link.LinkType.DIRECT]
    }
}
