package org.qsari.effectopedia.data.aopxml.mapping

object TextSectionHelper {
    fun appendSectionToBufferIfNotNull(buffer: StringBuffer, sectionClass: String, title: String, value: String?) {
        if (value.isNullOrBlank()) return

        buffer.append(String.format(
                "<div class='%s'><h3>%s</h3><p>%s</p></div>",
                sectionClass,
                title,
                value))
    }

    fun appendLabelledListItemValuesIfNotNullOrEmpty(buffer: StringBuffer, label: String, list: List<String?>) {
        appendLabelledListItemValuesIfNotNullOrEmpty(buffer, label, list, { c -> c })
    }

    fun <T> appendLabelledListItemValuesIfNotNullOrEmpty(buffer: StringBuffer,
                                                         label: String,
                                                         list: List<T>?,
                                                         listStringTransformer: (T) -> String?) {
        if (list == null || list.isEmpty()) return

        buffer.append("<li>")

        buffer.append("<strong>")
        buffer.append(label)
        buffer.append("</strong>")

        buffer.append(":")
        for (item in list) {
            buffer.append(listStringTransformer(item))
            buffer.append(", ")
        }
        buffer.setLength(buffer.length - 2)

        buffer.append("</li>")
    }
}
