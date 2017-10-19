package org.qsari.effectopedia.data.aopxml.mapping.key_event

import org.qsari.effectopedia.data.aopxml.mapping.ObjectPropertyMapperBase
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object ObjectPropertyMapper : ObjectPropertyMapperBase<Data.KeyEvent>(DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA) {
    init {
        this.addMap("short_name", { it.source.shortName }, { it.target.shortName = it.source.value.toString() })
    }
}
