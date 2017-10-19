package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.data.objects.ObjectProperties
import org.qsari.effectopedia.data.objects.ObjectProperty
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer

abstract class ObjectPropertyMapperBase<TXmlObject>(private val _destinationPropertyTypesContainer: ObjectPropertyTypesContainer) {
    private val _effectopediaPropertyIndicesByName = mutableMapOf<String, Int>()
    private val _xmlObjectPropertyGettersByEffectopediaPropertyIndex = mutableMapOf<Int, (NativePropertyToXmlObjectMappingContext) -> String?>()
    private val _xmlObjectPropertySettersByEffectopediaPropertyName = mutableMapOf<String, (XmlObjectToNativePropertyMappingContext) -> Unit>()

    init {
        for (i in this._destinationPropertyTypesContainer.indices) {
            val property = this._destinationPropertyTypesContainer[i]
            this._effectopediaPropertyIndicesByName.put(property.name, i)
        }
    }

    protected fun addMap(
            destinationPropertyName: String,
            xmlObjectPropertyGetter: (NativePropertyToXmlObjectMappingContext) -> String?,
            xmlObjectPropertySetter: (XmlObjectToNativePropertyMappingContext) -> Unit) {
        val destinationPropertyIndex = this._effectopediaPropertyIndicesByName.getValue(destinationPropertyName)
        this._xmlObjectPropertyGettersByEffectopediaPropertyIndex.put(destinationPropertyIndex, xmlObjectPropertyGetter)
        this._xmlObjectPropertySettersByEffectopediaPropertyName.put(destinationPropertyName, xmlObjectPropertySetter)
    }

    fun mapToNativeObjectProperties(source: TXmlObject, destination: ObjectProperties, importContext: IImportContext) {
        if (destination.types !== this._destinationPropertyTypesContainer) {
            throw IllegalArgumentException("Destination has a different property types container than what this mapper has indexed.")
        }

        for ((key, value) in this._xmlObjectPropertyGettersByEffectopediaPropertyIndex) {
            destination.setPropertyValue(key, value(NativePropertyToXmlObjectMappingContext(source, importContext)))
        }
    }

    fun mapToXmlObject(source: ObjectProperties, target: TXmlObject, exportContext: ExportContext) {
        if (source.types !== this._destinationPropertyTypesContainer) {
            throw IllegalArgumentException("Source has a different property types container than what this mapper has indexed.")
        }

        for ((i, property) in source.properties!!.withIndex()) {
            if (property?.value?.toString().isNullOrBlank()) continue

            val propertyName = source.types[i].name
            val xmlObjectPropertySetter = this._xmlObjectPropertySettersByEffectopediaPropertyName[propertyName] ?: continue
            xmlObjectPropertySetter(XmlObjectToNativePropertyMappingContext(property, target, exportContext))
        }
    }

    inner class NativePropertyToXmlObjectMappingContext(val source: TXmlObject, val context: IImportContext)
    inner class XmlObjectToNativePropertyMappingContext(val source: ObjectProperty, val target: TXmlObject, val context: ExportContext)
}
