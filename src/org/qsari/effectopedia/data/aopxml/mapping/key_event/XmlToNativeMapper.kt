package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.base.ids.ReferenceIDW
import org.qsari.effectopedia.core.objects.ContextDimension
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located
import org.qsari.effectopedia.core.objects.Effect
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.aopxml.mapping.IImportContext
import org.qsari.effectopedia.data.aopxml.mapping.ElementImportHelper
import org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object XmlToNativeMapper {
    fun mapToNativeObject(source: Data.KeyEvent,
                          parentAop: Data.Aop,
                          dataSource: DataSource,
                          destination: Effect,
                          importContext: IImportContext) {
        destination.title = source.title
        ObjectPropertyMapper.mapToNativeObjectProperties(source, destination.metadata, importContext)

        destination.coordinates.setValue(
                DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX,
                Mapping.ToNative.biologicalOrganizationLevelTypeMapper.getMappedFixedValue(source.biologicalOrganizationLevel))

        this.mapBiologicalCompartmentFromOrganAndCellTerms(source, destination)

        // Ignoring QA because it is not possible to map AOP-XML users to Effectopedia users.

        this.mapApplicability(source, parentAop, destination, importContext)

        DescriptionSectionMapper.mapToDescriptions(
                source,
                destination,
                dataSource,
                destination.descriptionIDs,
                importContext)

        val biologicalEvents = source.biologicalEvents
        if (biologicalEvents != null) {
            for (event in biologicalEvents.biologicalEvent) {
                this.importEvent(destination, event, importContext)
            }
        }

        // ElementImportHelper.importReferences(destination, destination.referenceIDs, source.references);
    }

    private fun mapBiologicalCompartmentFromOrganAndCellTerms(source: Data.KeyEvent, destination: Effect) {
        var biologicalCompartment = ""
        if (!source.organTerm?.name.isNullOrBlank()) {
            biologicalCompartment = "Organ: " + source.organTerm.name
        }
        if (biologicalCompartment.isNotEmpty()) {
            biologicalCompartment += " | "
        }
        if (!source.cellTerm?.name.isNullOrBlank()) {
            biologicalCompartment += "Cell: " + source.cellTerm.name
        }

        if (biologicalCompartment.isNotBlank()) {
            destination.coordinates.setValue(
                    DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
                    biologicalCompartment)
        }
    }

    private fun mapApplicability(source: Data.KeyEvent,
                                 parentAop: Data.Aop,
                                 destination: Effect,
                                 importContext: IImportContext) {
        val applicabilities = listOf(source.applicability, parentAop.applicability).filterNotNull()

        this.mapApplicableSexes(applicabilities, destination)
        // this.mapApplicableLifeStages(applicabilities, destination)
        this.mapApplicableTaxonomies(applicabilities, destination, importContext)
    }

    private fun mapApplicableSexes(applicabilities: Iterable<ApplicabilityType>, destination: Effect) {
        this.mapDimensionalValue(
                applicabilities,
                { it.sex },
                { it.sex },
                DefaultEffectopediaObjects.DEFAULT_SEX,
                Mapping.ToNative.effectopediaSexesByXmlSex::get,
                destination)
    }

    private fun mapApplicableLifeStages(applicabilities: Iterable<ApplicabilityType>, destination: Effect) {
        this.mapDimensionalValue(
                applicabilities,
                { it.lifeStage },
                { it.lifeStage },
                DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE,
                { it },
                destination)
    }

    private fun mapApplicableTaxonomies(applicabilities: Iterable<ApplicabilityType>,
                                        destination: Effect,
                                        importContext: IImportContext) {
        for (applicability in applicabilities) {
            if (applicability.taxonomy == null) {
                continue
            }

            val applicableTaxonomies = applicability.taxonomy.map {
                importContext.taxonomiesByXmlId.getValue(it.taxonomyId).name
            }

            // TODO: It is not clear how the "hierarchical dimension type" is supposed to go back
            // and forth from string, and it is not clear how to handle multiple values.
            val joined = applicableTaxonomies.joinToString(", ")
            if (joined.isNotEmpty()) {
                destination.coordinates.setValue(
                        DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX,
                        joined)
                return
            }
        }
    }

    private fun <TProperty> mapDimensionalValue(applicabilities: Iterable<ApplicabilityType>,
                                                propertyGetter: (ApplicabilityType) -> Iterable<TProperty?>?,
                                                propertyStringConverter: (TProperty) -> String?,
                                                templateContextDimension: ContextDimension,
                                                getXmlValueFromNativeValue: (String) -> String?,
                                                destination: DocumentedKnowledge_Located) {
        for (applicability in applicabilities) {
            val rawValues = propertyGetter(applicability) ?: continue

            var value: String? = null
            for (rawValue in rawValues) {
                if (rawValue == null) {
                    continue
                }

                value = propertyStringConverter(rawValue)
                if (value != null) {
                    break
                }
            }

            if (value == null) {
                continue
            }

            value = getXmlValueFromNativeValue(value)
                    ?: throw IllegalArgumentException("Cannot map XML fixed value: " + value)

            destination.coordinates.setValue(templateContextDimension.DIMENSION_INDEX, value)
            return
        }
    }

    private fun importEvent(effect: Effect, event: Data.KeyEvent.BiologicalEvents.BiologicalEvent, importContext: IImportContext) {
        val eventComponents = effect.metadata.getProperty("event_components")
        if (eventComponents?.valueAndUnit?.subProperties != null) {
            val subProperties = eventComponents.valueAndUnit.subProperties
            BiologicalEventsPropertyMapper.mapToNativeObjectProperties(event, subProperties, importContext)
        }
    }

    fun importEssentiality(destination: Effect,
                           srcKeyEventEssentiality: Data.Aop.KeyEventEssentialities.Essentiality) {
        val effectEssentiality = destination
                .descriptionIDs
                .getCachedObject(DescriptionSectionMapper.INDEX_OF_ESSENTIALITY) as DescriptionSection_Structured

        val reference = DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_R.clone(
                destination,
                destination.dataSource)

        reference.set(destination)
        reference.weight = ElementImportHelper.confidenceLevelValueToNumericWeight(srcKeyEventEssentiality.essentialityLevel)
        reference.bringToLive()

        effectEssentiality.structuredContent = reference
        effectEssentiality.structuredContentClass = ReferenceIDW::class.java
    }
}
