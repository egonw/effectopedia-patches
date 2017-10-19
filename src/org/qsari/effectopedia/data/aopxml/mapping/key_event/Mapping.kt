package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.data.aopxml.mapping.EnumToFixedValueListMapper
import org.qsari.effectopedia.data.aopxml.mapping.StringValueToEnumMapper
import org.qsari.effectopedia.data.aopxml.objects.BiologicalOrganizationLevelType
import org.qsari.effectopedia.data.aopxml.objects.LifeStage
import org.qsari.effectopedia.data.objects.FixedValuesList
import org.qsari.effectopedia.defaults.DefaultFixedListValues

object Mapping {
    object ToNative {
        val biologicalOrganizationLevelTypeMapper = EnumToFixedValueListMapper(
                BiologicalOrganizationLevelType::class.java,
                { obj: BiologicalOrganizationLevelType -> obj.value() },
                DefaultFixedListValues.INSTANCE.getList("DEFAULT_LBO_LIST") as FixedValuesList,
                null)

        val effectopediaSexesByXmlSex = mapOf(
                "Male" to "male",
                "Female" to "female",
                "Mixed" to "mixed",
                "Asexual" to "asexual",
                "Third Gender" to "third gender",
                "Hermaphrodite" to "hermaphrodite",
                "Unspecific" to "unspecified"

        )
    }

    object ToXml {
        var biologicalOrganizationLevelTypeMapper = StringValueToEnumMapper(
                BiologicalOrganizationLevelType::class.java,
                { it.value()!! })

        var lifeStageMapper = StringValueToEnumMapper(
                LifeStage::class.java,
                { it.value })

        val xmlSexByEffectopediaSexes = ToNative.effectopediaSexesByXmlSex.map { it.value to it.key }.toMap()
    }
}
