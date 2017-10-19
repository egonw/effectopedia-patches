package org.qsari.effectopedia.data.aopxml.mapping.aop

import org.qsari.effectopedia.data.aopxml.mapping.StringValueToEnumMapper
import org.qsari.effectopedia.data.aopxml.objects.OecdStatus
import org.qsari.effectopedia.data.aopxml.objects.SaaopStatus
import org.qsari.effectopedia.data.aopxml.objects.WikiStatus

object Mapping {
    object ToNative {
        val wikiStatusMapper = StringValueToEnumMapper(WikiStatus::class.java, { it.value })
        val oecdStatusMapper = StringValueToEnumMapper(OecdStatus::class.java, { it.value })
        val saaopStatusMapper = StringValueToEnumMapper(SaaopStatus::class.java, { it.value })
    }
}
