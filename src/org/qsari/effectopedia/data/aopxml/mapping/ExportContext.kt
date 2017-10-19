package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.core.objects.Effect
import org.qsari.effectopedia.core.objects.Initiator
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure
import org.qsari.effectopedia.data.aopxml.objects.Data

class ExportContext : XmlContextBase() {
    val biologicalObjectsByName = mutableMapOf<String, Data.BiologicalObject>()
    val biologicalActionsByName = mutableMapOf<String, Data.BiologicalAction>()
    val biologicalProcessesByName = mutableMapOf<String, Data.BiologicalProcess>()
    val taxonomiesByName = mutableMapOf<String, Data.Taxonomy>()
    val chemicalsByNativeChemical = mutableMapOf<Initiator_ChemicalStructure, Data.Chemical>()
    val keyEventsByNativeEffect = mutableMapOf<Effect, Data.KeyEvent>()
    val stressorsByNativeInitiator = mutableMapOf<Initiator, Data.Stressor>()
    val keyEventRelationshipsByNativeLinkHash = mutableMapOf<String, Data.KeyEventRelationship>()

    fun populate(exportedData: Data) {
        exportedData.chemical.addAll(this.chemicalsByXmlId.values)
        exportedData.stressor.addAll(this.stressorsByXmlId.values)
        exportedData.keyEvent.addAll(this.keyEventsByXmlId.values)
        exportedData.keyEventRelationship.addAll(this.keyEventRelationshipsByXmlId.values)
        exportedData.taxonomy.addAll(this.taxonomiesByXmlId.values)
        exportedData.biologicalObject.addAll(this.biologicalObjectsByXmlId.values)
        exportedData.biologicalAction.addAll(this.biologicalActionsByXmlId.values)
        exportedData.biologicalProcess.addAll(this.biologicalProcessesByXmlId.values)
        exportedData.aop.addAll(this.aops)
    }
}
