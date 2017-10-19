package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.data.aopxml.objects.Data

interface IImportContext {
    val chemicalsByXmlId: Map<String, Data.Chemical>
    val stressorsByXmlId: Map<String, Data.Stressor>
    val keyEventsByXmlId: Map<String, Data.KeyEvent>
    val keyEventRelationshipsByXmlId: Map<String, Data.KeyEventRelationship>
    val taxonomiesByXmlId: Map<String, Data.Taxonomy>
    val biologicalObjectsByXmlId: Map<String, Data.BiologicalObject>
    val biologicalActionsByXmlId: Map<String, Data.BiologicalAction>
    val biologicalProcessesByXmlId: Map<String, Data.BiologicalProcess>
    val aops: List<Data.Aop>
}

class ImportContext : XmlContextBase(), IImportContext
