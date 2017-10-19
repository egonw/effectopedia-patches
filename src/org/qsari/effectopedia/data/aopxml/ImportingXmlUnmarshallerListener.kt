package org.qsari.effectopedia.data.aopxml

import org.qsari.effectopedia.data.aopxml.mapping.aop.AopImport
import org.qsari.effectopedia.data.aopxml.mapping.ImportContext
import org.qsari.effectopedia.data.aopxml.objects.Data

import javax.xml.bind.Unmarshaller.Listener

class ImportingXmlUnmarshallerListener(private val _dataSource: AopXmlDataSource) : Listener() {
    private val _importContext: ImportContext = ImportContext()

    override fun afterUnmarshal(target: Any, parent: Any) {
        when (target) {
            is Data.Chemical -> {
                this._importContext.chemicalsByXmlId.put(target.id, target)
            }
            is Data.Stressor -> {
                this._importContext.stressorsByXmlId.put(target.id, target)
            }
            is Data.Taxonomy -> {
                this._importContext.taxonomiesByXmlId.put(target.id, target)
            }
            is Data.BiologicalObject -> {
                this._importContext.biologicalObjectsByXmlId.put(target.id, target)
            }
            is Data.BiologicalProcess -> {
                this._importContext.biologicalProcessesByXmlId.put(target.id, target)
            }
            is Data.BiologicalAction -> {
                this._importContext.biologicalActionsByXmlId.put(target.id, target)
            }
            is Data.KeyEvent -> {
                this._importContext.keyEventsByXmlId.put(target.id, target)
            }
            is Data.KeyEventRelationship -> {
                this._importContext.keyEventRelationshipsByXmlId.put(target.id, target)
            }
            is Data.Aop -> this._importContext.aops.add(target)
        }
    }

    fun importAops() {
        AopImport(this._dataSource, this._importContext).execute()
    }
}
