package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.base.EffectopediaObject
import org.qsari.effectopedia.base.ids.DescriptionIDs
import org.qsari.effectopedia.core.objects.DescriptionSection
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured
import org.qsari.effectopedia.data.DataSource

abstract class DescriptionSectionMapperBase<TXmlObject> {
    private val _mappingsByTitle = mutableMapOf<String, DescriptionSectionMapping>()

    protected fun addMap(
            targetIndex: Int,
            targetTitle: String,
            descriptionContentGetter: (XmlObjectToDescriptionMappingContext) -> String?,
            xmlObjectValueSetter: (DescriptionToXmlObjectMappingContext) -> Unit,
            defaultStructuredFactory: ((EffectopediaObject, DataSource) -> Any)? = null) {
        this._mappingsByTitle[targetTitle] = DescriptionSectionMapping(
                targetIndex,
                targetTitle,
                descriptionContentGetter,
                xmlObjectValueSetter,
                defaultStructuredFactory)
    }

    fun mapToDescriptions(
            source: TXmlObject,
            destination: EffectopediaObject,
            dataSource: DataSource,
            descriptionIds: DescriptionIDs,
            importContext: IImportContext) {
        if (source == null) throw IllegalArgumentException("source cannot be null.")

        val mappingContext = XmlObjectToDescriptionMappingContext(source, importContext)
        for (titleToMapping in this._mappingsByTitle) {
            val mapping = titleToMapping.value

            val descriptionSection: DescriptionSection
            if (mapping.defaultStructuredContentFactory == null) {
                descriptionSection = DescriptionSection(
                        destination,
                        dataSource,
                        mapping.targetSectionTitle,
                        mapping.descriptionContentGetter(mappingContext))
            } else {
                descriptionSection = DescriptionSection_Structured(
                        descriptionIds,
                        dataSource,
                        mapping.targetSectionTitle,
                        mapping.descriptionContentGetter(mappingContext),
                        mapping.defaultStructuredContentFactory.invoke(destination, dataSource))
            }

            descriptionSection.format = DescriptionSection.ContentFormat.HTML
            descriptionSection.bringToLive()

            descriptionIds.set(
                    descriptionSection,
                    mapping.targetSectionIndex)
        }
    }

    fun mapToXmlObject(destination: TXmlObject, descriptionIds: DescriptionIDs, exportContext: ExportContext) {
        if (destination == null) throw IllegalArgumentException("destination cannot be null.")

        for (section in descriptionIds.cachedObjects ?: arrayOf()) {
            if (section == null) continue
            val applicableMapping = this._mappingsByTitle[section.title?.trim() ?: ""] ?: continue
            applicableMapping.xmlObjectValueSetter(DescriptionToXmlObjectMappingContext(section, destination, exportContext))
        }
    }

    private inner class DescriptionSectionMapping(
            val targetSectionIndex: Int,
            val targetSectionTitle: String,
            val descriptionContentGetter: (XmlObjectToDescriptionMappingContext) -> String?,
            val xmlObjectValueSetter: (DescriptionToXmlObjectMappingContext) -> Unit,
            val defaultStructuredContentFactory: ((EffectopediaObject, DataSource) -> Any)?)

    inner class XmlObjectToDescriptionMappingContext(val source: TXmlObject, val context: IImportContext)
    inner class DescriptionToXmlObjectMappingContext(val section: DescriptionSection, val target: TXmlObject, val context: ExportContext)
}
