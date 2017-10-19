package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.data.aopxml.objects.Data

abstract class XmlContextBase {
    val chemicalsByXmlId = mutableMapOf<String, Data.Chemical>()
    val stressorsByXmlId = mutableMapOf<String, Data.Stressor>()
    val keyEventsByXmlId = mutableMapOf<String, Data.KeyEvent>()
    val keyEventRelationshipsByXmlId = mutableMapOf<String, Data.KeyEventRelationship>()
    val taxonomiesByXmlId = mutableMapOf<String, Data.Taxonomy>()
    val biologicalObjectsByXmlId = mutableMapOf<String, Data.BiologicalObject>()
    val biologicalActionsByXmlId = mutableMapOf<String, Data.BiologicalAction>()
    val biologicalProcessesByXmlId = mutableMapOf<String, Data.BiologicalProcess>()
    val aops = mutableListOf<Data.Aop>()
}
