package org.qsari.effectopedia.data.aopxml.mapping

class StringValueToEnumMapper<out TEnum : Enum<*>>(
        type: Class<TEnum>,
        stringValueGetter: (TEnum) -> String,
        constantsBySynonym: Map<String, TEnum> = mapOf()) {
    private val _constantsByNormalizedSynonym = type.enumConstants
            .asSequence()
            .map { normalizeSynonym(stringValueGetter(it)) to it }
            .plus(constantsBySynonym.map { normalizeSynonym(it.key) to it.value })
            .distinctBy { it.first }
            .toMap()

    fun getConstantOrNull(stringValue: String) : TEnum? {
        return this._constantsByNormalizedSynonym[normalizeSynonym(stringValue)]
    }

    fun getConstant(stringValue: String): TEnum {
        return this._constantsByNormalizedSynonym.getValue(normalizeSynonym(stringValue))
    }

    companion object {
        private val nonAlphaCharacters = Regex("[^A-Za-z0-9]")

        private fun normalizeSynonym(synonym: String): String {
            return nonAlphaCharacters.replace(synonym, "").toUpperCase()
        }
    }
}
