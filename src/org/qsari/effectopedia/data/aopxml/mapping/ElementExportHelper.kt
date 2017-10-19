package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.base.EffectopediaObject
import org.qsari.effectopedia.base.ids.ReferenceIDs
import org.qsari.effectopedia.core.Effectopedia
import org.qsari.effectopedia.core.objects.Reference
import org.qsari.effectopedia.data.aopxml.objects.ConfidenceLevelType
import org.qsari.effectopedia.data.aopxml.objects.Data
import java.security.MessageDigest
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar
import javax.xml.datatype.DatatypeFactory
import java.util.GregorianCalendar

data class ElementChangeHistory(
        val creationTimestamp: XMLGregorianCalendar,
        val lastModificationTimestamp: XMLGregorianCalendar?)

object ElementExportHelper {
    fun getElementChangeHistory(obj: EffectopediaObject): ElementChangeHistory? {
        val history = obj.dataSource?.editHistory?.getObjectHistory(obj.id) ?: return null
        if (history.isEmpty()) return null

        val creationStampId = history.first().stampId
        val lastModificationStampId = history.last().stampId

        // WARNING: Effectopedia singleton access. Only way to reach stamps.
        val creationStamp = Effectopedia.EFFECTOPEDIA.stamps[creationStampId.toInt()] ?: return null
        val lastModificationStamp = Effectopedia.EFFECTOPEDIA.stamps[lastModificationStampId.toInt()] ?: creationStamp

        val calendar = GregorianCalendar()
        calendar.time = creationStamp.date
        val creationTimestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar)
        calendar.time = lastModificationStamp.date
        val lastModificationTimestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar)

        return ElementChangeHistory(creationTimestamp, lastModificationTimestamp)
    }

    fun getKeyEventRelationshipHash(keyEventRelationship: Data.KeyEventRelationship): String {
        with(keyEventRelationship)
        {
            val digest = MessageDigest.getInstance("SHA-1")

            val identifyingPropertyValues = listOf(
                    title?.detailLevel,
                    title?.upstreamId,
                    title?.downstreamId,
                    description,
                    weightOfEvidence?.value,
                    weightOfEvidence?.biologicalPlausibility,
                    weightOfEvidence?.empericalSupportLinkage,
                    weightOfEvidence?.uncertaintiesOrInconsistencies,
                    quantitativeUnderstanding?.description,
                    quantitativeUnderstanding?.supportEvidence,
                    temporalConcordance)

            for (value in identifyingPropertyValues.asSequence().filterNotNull()) {
                digest.update(value.toByteArray())
            }

            return Base64.getEncoder().encodeToString(digest.digest())
        }
    }

    fun exportReferences(referenceIDs: ReferenceIDs<Reference>): String {
        val buffer = StringBuffer()
        TextSectionHelper.appendLabelledListItemValuesIfNotNullOrEmpty(
                buffer,
                "References",
                referenceIDs
                        .cachedObjects
                        .filter { !it.formatedReference.isNullOrBlank() }
                        .map { it.formatedReference })
        return buffer.toString()
    }

    fun numericWeightToConfidenceValue(weight: Double): ConfidenceLevelType {
        when (weight) {
            3.0 -> return ConfidenceLevelType.STRONG
            2.0 -> return ConfidenceLevelType.MODERATE
            1.0 -> return ConfidenceLevelType.WEAK
            else -> return ConfidenceLevelType.NOT_SPECIFIED
        }
    }
}
