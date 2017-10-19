package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located
import org.qsari.effectopedia.core.objects.Effect
import org.qsari.effectopedia.data.aopxml.mapping.ExportContext
import org.qsari.effectopedia.data.aopxml.mapping.ElementExportHelper
import org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType
import org.qsari.effectopedia.data.aopxml.objects.BiologicalTermType
import org.qsari.effectopedia.data.aopxml.objects.ConfidenceLevelType
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.data.objects.ObjectProperty
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects
import java.util.*

object NativeToXmlMapper {
    private val _biologicalCompartmentFormat = Regex(
            "^(Organ:\\s*(?<Organ>[^|]+))?(\\s*\\|\\s*)?(Cell:\\s*(?<Cell>[^|]+))?$",
            RegexOption.IGNORE_CASE)

    fun mapToXmlObject(srcEffect: Effect, dstKeyEvent: Data.KeyEvent, exportContext: ExportContext) {
        dstKeyEvent.title = srcEffect.title
        ObjectPropertyMapper.mapToXmlObject(srcEffect.metadata, dstKeyEvent, exportContext)
        if (dstKeyEvent.shortName.isNullOrBlank()) {
            dstKeyEvent.shortName = dstKeyEvent.title
        }

        this.mapDimensionalValue(
                srcEffect,
                dstKeyEvent,
                DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX,
                { Mapping.ToXml.biologicalOrganizationLevelTypeMapper.getConstantOrNull(it) },
                { d, v -> d.biologicalOrganizationLevel = v })

        data class BiologicalCompartmentComponents(val compartment: String, val organ: String?, val cell: String?)
        this.mapDimensionalValue(
                srcEffect,
                dstKeyEvent,
                DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
                {
                    val groups = this._biologicalCompartmentFormat.find(it)?.groups
                    BiologicalCompartmentComponents(it, groups?.get("Organ")?.value, groups?.get("Cell")?.value)
                },
                fun(d, v) {
                    if (v.organ != null) {
                        d.organTerm = BiologicalTermType()
                        d.organTerm.name = v.organ
                    }
                    if (v.cell != null) {
                        d.cellTerm = BiologicalTermType()
                        d.cellTerm.name = v.cell
                    }

                    d.applicability = d.applicability ?: ApplicabilityType()
                    d.applicability.biologicalCompartment.add(v.compartment)
                })

        this.mapApplicability(srcEffect, dstKeyEvent, exportContext)
        DescriptionSectionMapper.mapToXmlObject(dstKeyEvent, srcEffect.descriptionIDs, exportContext)
        if (dstKeyEvent.description == null) {
            dstKeyEvent.description = ""
        }

        val eventComponentsIndex = srcEffect.metadata.types.IndexOf("event_components")
        val eventComponents = srcEffect.metadata.getOrCreateProperty(eventComponentsIndex)

        this.exportEvents(eventComponents, exportContext, dstKeyEvent)
        dstKeyEvent.references = ElementExportHelper.exportReferences(srcEffect.referenceIDs)

        val history = ElementExportHelper.getElementChangeHistory(srcEffect)
        if (history != null) {
            dstKeyEvent.creationTimestamp = history.creationTimestamp
            dstKeyEvent.lastModificationTimestamp = history.lastModificationTimestamp
        }
    }

    private fun mapApplicability(source: Effect, destination: Data.KeyEvent, exportContext: ExportContext) {
        this.mapDimensionalValue(
                source,
                destination,
                DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX,
                { Mapping.ToXml.xmlSexByEffectopediaSexes.getValue(it) },
                fun(d, v) {
                    d.applicability = d.applicability ?: ApplicabilityType()
                    val sex = ApplicabilityType.Sex().apply {
                        this.sex = v
                        this.evidence = ConfidenceLevelType.NOT_SPECIFIED
                    }
                    d.applicability.sex.add(sex)
                })

        /*
        this.mapDimensionalValue(
                source,
                destination,
                DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX,
                { Mapping.ToXml.lifeStageMapper.getConstantOrNull(it) },
                fun(d, v) {
                    d.applicability = d.applicability ?: ApplicabilityType()
                    val lifeStage = ApplicabilityType.LifeStage().apply {
                        this.lifeStage = v.value
                        this.evidence = ConfidenceLevelType.NOT_SPECIFIED
                    }
                    d.applicability.lifeStage.add(lifeStage)
                })
        */

        this.mapDimensionalValue(
                source,
                destination,
                DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX,
                { it },
                fun(d, v) {
                    val taxonomy = exportContext.taxonomiesByName.getOrPut(v) {
                        Data.Taxonomy().apply {
                            this.id = UUID.randomUUID()!!.toString()
                            this.name = v
                            exportContext.taxonomiesByXmlId.putIfAbsent(this.id, this)
                        }
                    }

                    d.applicability = d.applicability ?: ApplicabilityType()
                    val taxonomyReference = ApplicabilityType.Taxonomy().apply {
                        this.taxonomyId = taxonomy.id
                        this.evidence = ConfidenceLevelType.NOT_SPECIFIED
                    }
                    d.applicability.taxonomy.add(taxonomyReference)
                })
    }

    private fun <TDestination, TXmlValue> mapDimensionalValue(
            source: DocumentedKnowledge_Located,
            destination: TDestination,
            dimensionIndex: Int,
            dimensionValueToXmlValueConverter: (String) -> TXmlValue?,
            destinationValueSetter: (TDestination, TXmlValue) -> Unit) {
        if (source.coordinates == null || source.coordinates.count() < dimensionIndex) {
            return
        }

        val rawNativeValue = source.coordinates.getDisplayValue(dimensionIndex)?.toString()?.trim() ?: return
        if (rawNativeValue.isBlank()) return
        val xmlValue = dimensionValueToXmlValueConverter(rawNativeValue) ?: return
        destinationValueSetter(destination, xmlValue)
    }

    private fun exportEvents(eventComponents: ObjectProperty, exportContext: ExportContext, destination: Data.KeyEvent) {
        val biologicalEvent = Data.KeyEvent.BiologicalEvents.BiologicalEvent()
        BiologicalEventsPropertyMapper.mapToXmlObject(eventComponents.valueAndUnit.subProperties, biologicalEvent, exportContext)

        if (biologicalEvent.actionId.isNullOrBlank()) {
            return
        }

        destination.biologicalEvents = destination.biologicalEvents ?: Data.KeyEvent.BiologicalEvents()
        destination.biologicalEvents.biologicalEvent.add(biologicalEvent)
    }
}
