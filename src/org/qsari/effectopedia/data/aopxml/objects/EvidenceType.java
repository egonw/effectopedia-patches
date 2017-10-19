
package org.qsari.effectopedia.data.aopxml.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evidence-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="evidence-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="evidence" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evidence-type", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "description",
    "evidence",
    "uri"
})
@XmlSeeAlso({
    org.qsari.effectopedia.data.aopxml.objects.Data.KeyEvent.KeyEventStressors.KeyEventStressor.class,
    org.qsari.effectopedia.data.aopxml.objects.Data.Aop.AdverseOutcome.OrgansAffected.class,
    org.qsari.effectopedia.data.aopxml.objects.Data.Aop.AopStressors.AopStressor.class,
    org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType.Sex.class,
    org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType.LifeStage.class,
    org.qsari.effectopedia.data.aopxml.objects.ApplicabilityType.Taxonomy.class
})
public class EvidenceType {

    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected String description;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
    @XmlSchemaType(name = "string")
    protected ConfidenceLevelType evidence;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> uri;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the evidence property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidenceLevelType }
     *     
     */
    public ConfidenceLevelType getEvidence() {
        return evidence;
    }

    /**
     * Sets the value of the evidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidenceLevelType }
     *     
     */
    public void setEvidence(ConfidenceLevelType value) {
        this.evidence = value;
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

}
