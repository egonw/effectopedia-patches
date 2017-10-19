
package org.qsari.effectopedia.data.aopxml.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applicability-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicability-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sex" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                 &lt;sequence>
 *                   &lt;element name="sex">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Male"/>
 *                         &lt;enumeration value="Female"/>
 *                         &lt;enumeration value="Mixed"/>
 *                         &lt;enumeration value="Asexual"/>
 *                         &lt;enumeration value="Third Gender"/>
 *                         &lt;enumeration value="Hermaphrodite"/>
 *                         &lt;enumeration value="Unspecific"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="life-stage" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                 &lt;sequence>
 *                   &lt;element name="life-stage">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Birth to &lt; 1 month"/>
 *                         &lt;enumeration value="1 to &lt; 3 months"/>
 *                         &lt;enumeration value="3 to &lt; 6 months"/>
 *                         &lt;enumeration value="6 to &lt; 12 months"/>
 *                         &lt;enumeration value="1 to &lt; 2 years"/>
 *                         &lt;enumeration value="2 to &lt; 3 years"/>
 *                         &lt;enumeration value="3 to &lt; 6 years"/>
 *                         &lt;enumeration value="6 to &lt; 11 years"/>
 *                         &lt;enumeration value="11 to &lt; 16 years"/>
 *                         &lt;enumeration value="16 to &lt; 21 years"/>
 *                         &lt;enumeration value="Nursing Child"/>
 *                         &lt;enumeration value="Pregnancy"/>
 *                         &lt;enumeration value="Old Age"/>
 *                         &lt;enumeration value="Not Otherwise Specified"/>
 *                         &lt;enumeration value="Lactating Mother"/>
 *                         &lt;enumeration value="Conception to &lt; Fetal"/>
 *                         &lt;enumeration value="Fetal to Parturition"/>
 *                         &lt;enumeration value="Foetal"/>
 *                         &lt;enumeration value="Embryo"/>
 *                         &lt;enumeration value="Juvenile"/>
 *                         &lt;enumeration value="Adult, reproductively mature"/>
 *                         &lt;enumeration value="Perinatal"/>
 *                         &lt;enumeration value="During development and at adulthood"/>
 *                         &lt;enumeration value="Adults"/>
 *                         &lt;enumeration value="Adult"/>
 *                         &lt;enumeration value="During brain development, adulthood and aging"/>
 *                         &lt;enumeration value="During brain development"/>
 *                         &lt;enumeration value="Human"/>
 *                         &lt;enumeration value="Development"/>
 *                         &lt;enumeration value="All life stages"/>
 *                         &lt;enumeration value="Fetal"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="taxonomy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                 &lt;attribute name="taxonomy-id" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="biological-compartment" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time-to-manifestation" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time-to-manifestation-range" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="generation" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicability-type", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "sex",
    "lifeStage",
    "taxonomy",
    "uri",
    "biologicalCompartment",
    "timeToManifestation",
    "timeToManifestationRange",
    "generation"
})
public class ApplicabilityType {

    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<ApplicabilityType.Sex> sex;
    @XmlElement(name = "life-stage", namespace = "http://www.aopkb.org/aop-xml")
    protected List<ApplicabilityType.LifeStage> lifeStage;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<ApplicabilityType.Taxonomy> taxonomy;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> uri;
    @XmlElement(name = "biological-compartment", namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> biologicalCompartment;
    @XmlElement(name = "time-to-manifestation", namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> timeToManifestation;
    @XmlElement(name = "time-to-manifestation-range", namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> timeToManifestationRange;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> generation;

    /**
     * Gets the value of the sex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicabilityType.Sex }
     * 
     * 
     */
    public List<ApplicabilityType.Sex> getSex() {
        if (sex == null) {
            sex = new ArrayList<ApplicabilityType.Sex>();
        }
        return this.sex;
    }

    /**
     * Gets the value of the lifeStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lifeStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLifeStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicabilityType.LifeStage }
     * 
     * 
     */
    public List<ApplicabilityType.LifeStage> getLifeStage() {
        if (lifeStage == null) {
            lifeStage = new ArrayList<ApplicabilityType.LifeStage>();
        }
        return this.lifeStage;
    }

    /**
     * Gets the value of the taxonomy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxonomy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxonomy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicabilityType.Taxonomy }
     * 
     * 
     */
    public List<ApplicabilityType.Taxonomy> getTaxonomy() {
        if (taxonomy == null) {
            taxonomy = new ArrayList<ApplicabilityType.Taxonomy>();
        }
        return this.taxonomy;
    }

    /**
     * Gets the value of the uri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUri() {
        if (uri == null) {
            uri = new ArrayList<String>();
        }
        return this.uri;
    }

    /**
     * Gets the value of the biologicalCompartment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biologicalCompartment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiologicalCompartment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBiologicalCompartment() {
        if (biologicalCompartment == null) {
            biologicalCompartment = new ArrayList<String>();
        }
        return this.biologicalCompartment;
    }

    /**
     * Gets the value of the timeToManifestation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeToManifestation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeToManifestation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTimeToManifestation() {
        if (timeToManifestation == null) {
            timeToManifestation = new ArrayList<String>();
        }
        return this.timeToManifestation;
    }

    /**
     * Gets the value of the timeToManifestationRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeToManifestationRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeToManifestationRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTimeToManifestationRange() {
        if (timeToManifestationRange == null) {
            timeToManifestationRange = new ArrayList<String>();
        }
        return this.timeToManifestationRange;
    }

    /**
     * Gets the value of the generation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGeneration() {
        if (generation == null) {
            generation = new ArrayList<String>();
        }
        return this.generation;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *       &lt;sequence>
     *         &lt;element name="life-stage">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Birth to &lt; 1 month"/>
     *               &lt;enumeration value="1 to &lt; 3 months"/>
     *               &lt;enumeration value="3 to &lt; 6 months"/>
     *               &lt;enumeration value="6 to &lt; 12 months"/>
     *               &lt;enumeration value="1 to &lt; 2 years"/>
     *               &lt;enumeration value="2 to &lt; 3 years"/>
     *               &lt;enumeration value="3 to &lt; 6 years"/>
     *               &lt;enumeration value="6 to &lt; 11 years"/>
     *               &lt;enumeration value="11 to &lt; 16 years"/>
     *               &lt;enumeration value="16 to &lt; 21 years"/>
     *               &lt;enumeration value="Nursing Child"/>
     *               &lt;enumeration value="Pregnancy"/>
     *               &lt;enumeration value="Old Age"/>
     *               &lt;enumeration value="Not Otherwise Specified"/>
     *               &lt;enumeration value="Lactating Mother"/>
     *               &lt;enumeration value="Conception to &lt; Fetal"/>
     *               &lt;enumeration value="Fetal to Parturition"/>
     *               &lt;enumeration value="Foetal"/>
     *               &lt;enumeration value="Embryo"/>
     *               &lt;enumeration value="Juvenile"/>
     *               &lt;enumeration value="Adult, reproductively mature"/>
     *               &lt;enumeration value="Perinatal"/>
     *               &lt;enumeration value="During development and at adulthood"/>
     *               &lt;enumeration value="Adults"/>
     *               &lt;enumeration value="Adult"/>
     *               &lt;enumeration value="During brain development, adulthood and aging"/>
     *               &lt;enumeration value="During brain development"/>
     *               &lt;enumeration value="Human"/>
     *               &lt;enumeration value="Development"/>
     *               &lt;enumeration value="All life stages"/>
     *               &lt;enumeration value="Fetal"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "lifeStage"
    })
    public static class LifeStage
        extends EvidenceType
    {

        @XmlElement(name = "life-stage", namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String lifeStage;

        /**
         * Gets the value of the lifeStage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLifeStage() {
            return lifeStage;
        }

        /**
         * Sets the value of the lifeStage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLifeStage(String value) {
            this.lifeStage = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *       &lt;sequence>
     *         &lt;element name="sex">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Male"/>
     *               &lt;enumeration value="Female"/>
     *               &lt;enumeration value="Mixed"/>
     *               &lt;enumeration value="Asexual"/>
     *               &lt;enumeration value="Third Gender"/>
     *               &lt;enumeration value="Hermaphrodite"/>
     *               &lt;enumeration value="Unspecific"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sex"
    })
    public static class Sex
        extends EvidenceType
    {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String sex;

        /**
         * Gets the value of the sex property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSex() {
            return sex;
        }

        /**
         * Sets the value of the sex property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSex(String value) {
            this.sex = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *       &lt;attribute name="taxonomy-id" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Taxonomy
        extends EvidenceType
    {

        @XmlAttribute(name = "taxonomy-id")
        protected String taxonomyId;

        /**
         * Gets the value of the taxonomyId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTaxonomyId() {
            return taxonomyId;
        }

        /**
         * Sets the value of the taxonomyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTaxonomyId(String value) {
            this.taxonomyId = value;
        }

    }

}
