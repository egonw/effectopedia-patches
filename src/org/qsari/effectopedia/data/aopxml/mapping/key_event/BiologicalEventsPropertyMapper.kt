package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.data.aopxml.mapping.ObjectPropertyMapperBase
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects
import java.util.*

object BiologicalEventsPropertyMapper : ObjectPropertyMapperBase<Data.KeyEvent.BiologicalEvents.BiologicalEvent>(DefaultEffectopediaObjects.DEFAULT_EVENT_COMPONENTS.subPropertyTypes) {
    init {
        this.addMap("object", {
            if (!it.source.objectId.isNullOrEmpty()) {
                it.context.biologicalObjectsByXmlId.getValue(it.source.objectId).name ?: ""
            } else ""
        }, {
            val name = it.source.value.toString()
            val obj = it.context.biologicalObjectsByName.getOrPut(name) {
                Data.BiologicalObject().apply {
                    this.id = UUID.randomUUID()!!.toString()
                    this.name = name
                }
            }
            it.context.biologicalObjectsByXmlId.putIfAbsent(obj.id, obj)
            it.target.objectId = obj.id
        })

        this.addMap("process", {
            if (!it.source.processId.isNullOrEmpty()) {
                it.context.biologicalProcessesByXmlId.getValue(it.source.processId).name ?: ""
            } else ""
        }, {
            val name = it.source.value.toString()
            val obj = it.context.biologicalProcessesByName.getOrPut(name) {
                Data.BiologicalProcess().apply {
                    this.id = UUID.randomUUID()!!.toString()
                    this.name = name
                }
            }
            it.context.biologicalProcessesByXmlId.putIfAbsent(obj.id, obj)
            it.target.processId = obj.id
        })

        this.addMap("action", {
            if (!it.source.actionId.isNullOrEmpty()) {
                it.context.biologicalActionsByXmlId.getValue(it.source.actionId).name ?: ""
            } else ""
        }, {
            val name = it.source.value.toString()
            val obj = it.context.biologicalActionsByName.getOrPut(name) {
                Data.BiologicalAction().apply {
                    this.id = UUID.randomUUID()!!.toString()
                    this.name = name
                }
            }
            it.context.biologicalActionsByXmlId.putIfAbsent(obj.id, obj)
            it.target.actionId = obj.id
        })
    }
}
