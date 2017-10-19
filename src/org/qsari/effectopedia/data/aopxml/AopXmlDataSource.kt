package org.qsari.effectopedia.data.aopxml

import org.qsari.effectopedia.base.EffectopediaObject
import org.qsari.effectopedia.base.io.*
import org.qsari.effectopedia.core.ui.UserInterface
import org.qsari.effectopedia.data.DataSourceItem
import org.qsari.effectopedia.data.RevisionBasedDS
import org.qsari.effectopedia.data.aopxml.mapping.aop.AopExport
import org.qsari.effectopedia.data.aopxml.objects.Data
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.stream.XMLInputFactory
import javax.xml.transform.stream.StreamSource

class AopXmlDataSource : RevisionBasedDS(), BaseIO, DataSourceItem {
    init {
        this.dataFormat = AopXmlFileFormat
        this.dataFormatFlavour = AopXmlFileFormat.DefaultFlavour
    }

    override fun load(path: String): Boolean {
        try {
            val streamSource = StreamSource(File(path))
            val factory = XMLInputFactory.newFactory()
            val reader = factory.createXMLStreamReader(streamSource)

            val context = JAXBContext.newInstance(Data::class.java)
            val unmarshaller = context.createUnmarshaller()
            val listener = ImportingXmlUnmarshallerListener(this)
            unmarshaller.listener = listener
            unmarshaller.unmarshal(reader, Data::class.java).value
            listener.importAops()

            this.setSourcePrefix("aopxml://")
            this.setSourceName(path)
            return true
        } catch (ex: Exception) {
            ex.printStackTrace()

            // WARNING: Singleton access. Proper error conveyance is needed.
            UserInterface.showError("Failed to import the AOP-XML file: " + ex)
            return false
        }
    }

    override fun add(eo: EffectopediaObject) {
        val objects = this.liveIndices.getValue(eo.javaClass)
        objects.put(eo.id, eo)
    }

    override fun add(objectClass: Class<out EffectopediaObject>, eo: EffectopediaObject) {
        val objects = this.liveIndices.getValue(objectClass)
        objects.put(eo.id, eo)
    }

    override fun addToArchive(objectClass: Class<out EffectopediaObject>, eo: EffectopediaObject) {
        val objects = this.archiveIndices.getValue(objectClass)
        objects.put(eo.id, eo)
    }

    override fun remove(objectClass: Class<out EffectopediaObject>, id: Long): EffectopediaObject? {
        return this.liveIndices.getOrDefault(objectClass, null)?.remove(id)
    }

    override fun getLiveEffectopediaObjectByExternalID(externalID: Long): EffectopediaObject? {
        return null
    }

    override fun getArchiveEffectopediaObjectByExternalID(externalID: Long): EffectopediaObject? {
        return null
    }

    override fun save(path: String, saveLocally: Boolean) {
        try {
            val outputFile = File(path)
            val context = JAXBContext.newInstance(Data::class.java)

            val marshaller = context.createMarshaller()
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8")

            val aopExport = AopExport(this)
            aopExport.execute()
            marshaller.marshal(aopExport.exportedData, outputFile)

            this.setSourcePrefix("aopxml://")
            this.setSourceName(path)
        } catch (ex: Exception) {
            ex.printStackTrace()

            // WARNING: Singleton access. Proper error conveyance is needed.
            UserInterface.showError("Failed to save the AOP-XML file: " + ex)
        }
    }

    override fun newAttribute(name: String): BaseIOAttribute {
        throw UnsupportedOperationException()
    }

    override fun newValue(name: String): BaseIOValue {
        throw UnsupportedOperationException()
    }

    override fun newElement(name: String): BaseIOElement {
        throw UnsupportedOperationException()
    }

    override fun newArray(name: String, count: Int): BaseIOArray {
        throw UnsupportedOperationException()
    }

    override fun <E : EffectopediaObject> load(cl: Class<*>, effectopediaObject: E, element: BaseIOElement): E {
        throw UnsupportedOperationException()
    }

    override fun getFormatVersion(): Double {
        throw UnsupportedOperationException()
    }

    override fun getInputVersion(): Double {
        throw UnsupportedOperationException()
    }

    override fun getDataPattern(): BaseIO.DataPattern {
        throw UnsupportedOperationException()
    }
}
