
package org.qsari.effectopedia.data.aopxml.objects;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confidence-level-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="confidence-level-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Strong"/>
 *     &lt;enumeration value="Moderate"/>
 *     &lt;enumeration value="Weak"/>
 *     &lt;enumeration value="Not Specified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "confidence-level-type", namespace = "http://www.aopkb.org/aop-xml")
@XmlEnum
public enum ConfidenceLevelType {

    @XmlEnumValue("Strong")
    STRONG("Strong"),
    @XmlEnumValue("Moderate")
    MODERATE("Moderate"),
    @XmlEnumValue("Weak")
    WEAK("Weak"),
    @XmlEnumValue("Not Specified")
    NOT_SPECIFIED("Not Specified");
    private final String value;

    ConfidenceLevelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConfidenceLevelType fromValue(String v) {
        for (ConfidenceLevelType c: ConfidenceLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
