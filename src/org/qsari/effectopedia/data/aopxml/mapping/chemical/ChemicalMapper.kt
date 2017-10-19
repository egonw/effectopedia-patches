package org.qsari.effectopedia.data.aopxml.mapping.chemical

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure
import org.qsari.effectopedia.data.aopxml.mapping.ExportContext
import org.qsari.effectopedia.data.aopxml.mapping.IImportContext
import org.qsari.effectopedia.data.aopxml.objects.Data

object ChemicalMapper {
    fun mapToNativeObject(source: Data.Chemical, destination: Initiator_ChemicalStructure, importContext: IImportContext) {
        destination.structureName = source.preferredName
        ObjectPropertyMapper.mapToNativeObjectProperties(source, destination.identification, importContext)
        // Ignoring indigoInchiKey - no target property available

        if (source.synonyms != null) {
            destination.synonymsList = source.synonyms.synonym.toTypedArray()
        }

        if (source.structuralDiagram2D != null) {
            // Ignoring structuralDiagram2D because it is present in binary in the schema whereas Effectopedia wants a URL.
            // AopWiki has none.
        }

        // Ignoring dsstoxId: no target property available
    }

    fun mapToXmlObject(source: Initiator_ChemicalStructure, destination: Data.Chemical, exportContext: ExportContext) {
        destination.preferredName = source.structureName

        if (source.identification != null) {
            ObjectPropertyMapper.mapToXmlObject(source.identification, destination, exportContext)
        }

        if (source.synonymsList != null) {
            val filteredSynonyms = source.synonymsList.filterNot { it.isNullOrBlank() }.map { it.trim() }
            if (filteredSynonyms.count() > 0) {
                destination.synonyms = destination.synonyms ?: Data.Chemical.Synonyms()
                destination.synonyms.synonym.addAll(filteredSynonyms)
            }
        }
    }
}
