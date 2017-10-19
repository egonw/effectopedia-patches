package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.data.aopxml.mapping.DescriptionSectionMapperBase
import org.qsari.effectopedia.data.aopxml.mapping.TextSectionHelper
import org.qsari.effectopedia.data.aopxml.objects.Data.KeyEvent
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object DescriptionSectionMapper : DescriptionSectionMapperBase<KeyEvent>() {
    val INDEX_OF_ESSENTIALITY = 1
    private val DESCRIPTION_TITLE = "Description"
    private val DESCRIPTION_TITLE_MEASUREMENT_METHODOLOGY = "Measurement Methodology"
    private val DESCRIPTION_TITLE_EVIDENCE_SUPPORTING_TAXONOMIC_APPLICABILITY = "Evidence Supporting Taxonomic Applicability"

    init {
        this.addMap(0, DESCRIPTION_TITLE, {
            val buffer = StringBuffer()
            TextSectionHelper.appendSectionToBufferIfNotNull(buffer, "description", "Description", it.source.description)
            TextSectionHelper.appendSectionToBufferIfNotNull(buffer, "references", "References", it.source.references)
            buffer.toString()
        }, {
            it.target.description = it.section.content
        })

        this.addMap(INDEX_OF_ESSENTIALITY, DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_DS.title, { "" }, { }) {
            parent, dataSource -> DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_R.clone(parent, dataSource)
        }

        this.addMap(2, DESCRIPTION_TITLE_MEASUREMENT_METHODOLOGY, {
            String.format("%s <br /> %s", it.source.measurementMethodology, it.source.associatedTests)
        }, {
            it.target.associatedTests = it.section.content
        })

        this.addMap(3, DESCRIPTION_TITLE_EVIDENCE_SUPPORTING_TAXONOMIC_APPLICABILITY, {
            it.source.evidenceSupportingTaxonomicApplicability
        }, {
            it.target.evidenceSupportingTaxonomicApplicability = it.section.content
        })
    }
}
