package org.qsari.effectopedia.data.aopxml.mapping.aop

import org.qsari.effectopedia.data.aopxml.mapping.DescriptionSectionMapperBase
import org.qsari.effectopedia.data.aopxml.mapping.TextSectionHelper
import org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType
import org.qsari.effectopedia.data.aopxml.objects.Data

object DescriptionSectionMapper : DescriptionSectionMapperBase<Data.Aop>() {
    init {
        this.addMap(0, "Abstract", {
            val buffer = StringBuffer()
            TextSectionHelper.appendSectionToBufferIfNotNull(buffer, "abstract", "Abstract", it.source.abstract)
            TextSectionHelper.appendSectionToBufferIfNotNull(buffer, "references", "References", it.source.references)
            buffer.toString()
        }, {
            it.target.abstract = it.section.content
        })

        this.addMap(1, "Background", { it.source.background }, { it.target.background = it.section.content })

        this.addMap(2, "Essentiality Support", {
            var body = ""
            if (it.source.essentialitySupport != null) {
                val buffer = StringBuffer()
                it.source.essentialitySupport.filterNotNull().forEach {
                    buffer.append(String.format("<p>%s</p>", it.toString()))
                }
                body = buffer.toString()
            }
            body
        }, { it.target.essentialitySupport.add(it.section.content) })

        this.addMap(3, "Quantitative Considerations", {
            it.source.overallAssessment?.quantitativeConsiderations ?: ""
        }, {
            it.target.overallAssessment = it.target.overallAssessment ?: Data.Aop.OverallAssessment()
            it.target.overallAssessment.quantitativeConsiderations = it.section.content
        })

        this.addMap(4, "Applicability of the AOP", {
            var body = ""
            if (it.source.overallAssessment != null) {
                val buffer = StringBuffer()
                TextSectionHelper.appendSectionToBufferIfNotNull(
                        buffer,
                        "summary",
                        "Summary",
                        it.source.overallAssessment.applicability)

                val importContext = it.context
                val applicability = it.source.applicability
                if (applicability != null) {
                    buffer.append("<ul>")

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Sexes",
                            applicability.sex) { it.sex }

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Life Stages",
                            applicability.lifeStage) { it.lifeStage }

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty<ApplicabilityType.Taxonomy>(
                            buffer,
                            "Taxonomies",
                            applicability.taxonomy) { importContext.taxonomiesByXmlId.getValue(it.taxonomyId).name }

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Biological Compartments",
                            applicability.biologicalCompartment)

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Generations",
                            applicability.generation)

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Time to manifestation",
                            applicability.timeToManifestation)

                    TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                            buffer,
                            "Time to manifestation ranges",
                            applicability.timeToManifestationRange)

                    buffer.append("</ul>")
                }

                body = buffer.toString()
            }
            body
        }, {
            it.target.overallAssessment = it.target.overallAssessment ?: Data.Aop.OverallAssessment()
            it.target.overallAssessment.applicability = it.section.content
        })

        this.addMap(5, "Potential Applications of the AOP", { it.source.potentialApplications }, {
            it.target.potentialApplications = it.section.content
        })

        this.addMap(6, "Key Event Essentiality - Overall Assessment", {
            it.source.overallAssessment?.keyEventEssentialitySummary ?: ""
        }, {
            it.target.overallAssessment = it.target.overallAssessment ?: Data.Aop.OverallAssessment()
            it.target.overallAssessment.keyEventEssentialitySummary = it.section.content
        })

        this.addMap(7, "Overall Assessment of the AOP", { it.source.overallAssessment?.description ?: "" }, {
            it.target.overallAssessment = it.target.overallAssessment ?: Data.Aop.OverallAssessment()
            it.target.overallAssessment.description = it.section.content
        })
    }
}
