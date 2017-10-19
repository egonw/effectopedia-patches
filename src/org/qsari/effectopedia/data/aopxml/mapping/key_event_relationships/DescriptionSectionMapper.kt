package org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships

import org.qsari.effectopedia.data.aopxml.mapping.DescriptionSectionMapperBase
import org.qsari.effectopedia.data.aopxml.mapping.TextSectionHelper
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object DescriptionSectionMapper : DescriptionSectionMapperBase<Data.KeyEventRelationship>() {
    init {
        this.addMap(0, "Description", {
            val buffer = StringBuffer()
            TextSectionHelper.appendSectionToBufferIfNotNull(
                    buffer,
                    "description",
                    "Description",
                    it.source.description)

            // Temporary solution until we can parse references into reference lines.
            TextSectionHelper.appendSectionToBufferIfNotNull(
                    buffer,
                    "references",
                    "References",
                    it.source.references)
            buffer.toString()
        }, {
            it.target.description = it.section.content
        })

        this.addMap(1, DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_DS.title, {
            var result = ""

            val weightOfEvidence = it.source.weightOfEvidence
            if (weightOfEvidence != null) {
                val buffer = StringBuffer()
                TextSectionHelper.appendSectionToBufferIfNotNull(
                        buffer,
                        "description",
                        "Description",
                        weightOfEvidence.value)

                TextSectionHelper.appendSectionToBufferIfNotNull(
                        buffer,
                        "biological-plausibility",
                        "Biological Plausibility",
                        weightOfEvidence.biologicalPlausibility)

                TextSectionHelper.appendSectionToBufferIfNotNull(
                        buffer,
                        "empirical-support-for-linkage",
                        "Empirical Support for Linkage",
                        weightOfEvidence.empericalSupportLinkage)

                TextSectionHelper.appendSectionToBufferIfNotNull(
                        buffer,
                        "uncertainties-or-inconsistencies",
                        "Uncertainties or Inconsistencies",
                        weightOfEvidence.uncertaintiesOrInconsistencies)

                result = buffer.toString()
            }

            result
        }, {
            it.target.weightOfEvidence = it.target.weightOfEvidence ?: Data.KeyEventRelationship.WeightOfEvidence()
            it.target.weightOfEvidence.value = it.section.content
        }, { parent, dataSource -> DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_R.clone(parent, dataSource) })

        this.addMap(2, "Evidence Supporting Taxonomic Applicability", { it.source.evidenceSupportingTaxonomicApplicability }, {
            it.target.evidenceSupportingTaxonomicApplicability = it.section.content
        })

        this.addMap(3, "Quantitative Understanding", {
            var result = ""
            val quantitativeUnderstanding = it.source.quantitativeUnderstanding
            if (quantitativeUnderstanding != null) {
                result = String.format("<p>Evidence support: %s</p><p>%s</p>",
                        if (!quantitativeUnderstanding.supportEvidence.isNullOrEmpty())
                            quantitativeUnderstanding.supportEvidence
                        else "Unspecified",
                        quantitativeUnderstanding.description)
            }
            result
        }, {
            it.target.quantitativeUnderstanding = it.target.quantitativeUnderstanding
                    ?: Data.KeyEventRelationship.QuantitativeUnderstanding()
            it.target.quantitativeUnderstanding.description = it.section.content
        })

        // Custom section
        this.addMap(4, "Temporal Concordance", { it.source.temporalConcordance }, {
            it.target.temporalConcordance = it.section.content
        })
    }
}
