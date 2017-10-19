package org.qsari.effectopedia.data.aopxml.mapping.key_event_relationships

import org.qsari.effectopedia.core.objects.Link

object Mapping {
    object ToNative {
        val linkNaturesByDetailLevel = mapOf(
                "Hypothetical" to Link.LinkNature.HYPOTHETICAL,
                "One To One" to Link.LinkNature.HARDWIRE,
                "Proportional" to Link.LinkNature.LINEAR,
                "Threshold" to Link.LinkNature.THRESHOLD,
                "Response-Response" to Link.LinkNature.RESPONSE_RESPONSE)

        val linkTypesByDirectness = mapOf(
                "direct" to Link.LinkType.DIRECT,
                "indirect" to Link.LinkType.INDIRECT)
    }

    object ToXml {
        val detailLevelsByLinkNature = ToNative.linkNaturesByDetailLevel.map { it.value to it.key }.toMap()
        val directnessValuesByLinkType = ToNative.linkTypesByDirectness.map { it.value to it.key }.toMap()
    }
}
