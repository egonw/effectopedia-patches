
package org.qsari.effectopedia.data.aopxml.objects;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for biological-organization-level-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="biological-organization-level-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Molecular"/>
 *     &lt;enumeration value="Organelle"/>
 *     &lt;enumeration value="Cellular"/>
 *     &lt;enumeration value="Tissue"/>
 *     &lt;enumeration value="Organ"/>
 *     &lt;enumeration value="Organ System"/>
 *     &lt;enumeration value="Individual"/>
 *     &lt;enumeration value="Population"/>
 *     &lt;enumeration value="Species"/>
 *     &lt;enumeration value="Communities"/>
 *     &lt;enumeration value="Ecosystem"/>
 *     &lt;enumeration value="Biosphere"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "biological-organization-level-type", namespace = "http://www.aopkb.org/aop-xml")
@XmlEnum
public enum BiologicalOrganizationLevelType {

    @XmlEnumValue("Molecular")
    MOLECULAR("Molecular"),
    @XmlEnumValue("Organelle")
    ORGANELLE("Organelle"),
    @XmlEnumValue("Cellular")
    CELLULAR("Cellular"),
    @XmlEnumValue("Tissue")
    TISSUE("Tissue"),
    @XmlEnumValue("Organ")
    ORGAN("Organ"),
    @XmlEnumValue("Organ System")
    ORGAN_SYSTEM("Organ System"),
    @XmlEnumValue("Individual")
    INDIVIDUAL("Individual"),
    @XmlEnumValue("Population")
    POPULATION("Population"),
    @XmlEnumValue("Species")
    SPECIES("Species"),
    @XmlEnumValue("Communities")
    COMMUNITIES("Communities"),
    @XmlEnumValue("Ecosystem")
    ECOSYSTEM("Ecosystem"),
    @XmlEnumValue("Biosphere")
    BIOSPHERE("Biosphere");
    private final String value;

    BiologicalOrganizationLevelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BiologicalOrganizationLevelType fromValue(String v) {
        for (BiologicalOrganizationLevelType c: BiologicalOrganizationLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
