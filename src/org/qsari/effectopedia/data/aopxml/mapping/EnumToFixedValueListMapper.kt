package org.qsari.effectopedia.data.aopxml.mapping

import org.qsari.effectopedia.data.objects.FixedValuesList
import java.util.*

class EnumToFixedValueListMapper<in TEnum : Enum<*>>(
        enumClass: Class<TEnum>,
        enumStringValueConverter: (TEnum) -> String,
        valueList: FixedValuesList,
        overrides: Map<TEnum, String>?) {
    private val _mappedFixedValuesByEnumConstant: HashMap<TEnum, String> = HashMap()

    init {
        val lookup = HashSet(valueList.list)

        for (enumConstant in enumClass.enumConstants) {
            var enumConstantString = enumStringValueConverter(enumConstant)
            if (!lookup.contains(enumConstantString)) {
                enumConstantString = enumConstantString.toLowerCase()

                if (overrides != null && !lookup.contains(enumConstantString)) {
                    enumConstantString = overrides.getOrDefault(enumConstant, enumConstantString)

                    if (!lookup.contains(enumConstantString)) {
                        throw IllegalArgumentException("No mapping for enum constant: " + enumConstant)
                    }
                }
            }

            this._mappedFixedValuesByEnumConstant.put(enumConstant, enumConstantString)
        }
    }

    fun getMappedFixedValue(enumConstant: TEnum?): String? {
        if (enumConstant == null) return null
        return this._mappedFixedValuesByEnumConstant[enumConstant]
                ?: throw IllegalArgumentException("Unidentified enum value: $enumConstant")
    }
}
