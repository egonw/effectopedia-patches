
package org.qsari.effectopedia.data.aopxml.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for biological-term-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="biological-term-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="source-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biological-term-type", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "sourceId",
    "source",
    "name",
    "synonym"
})
@XmlSeeAlso({
    org.qsari.effectopedia.data.aopxml.objects.Data.BiologicalObject.class,
    org.qsari.effectopedia.data.aopxml.objects.Data.BiologicalProcess.class,
    org.qsari.effectopedia.data.aopxml.objects.Data.BiologicalAction.class,
    org.qsari.effectopedia.data.aopxml.objects.Data.Taxonomy.class
})
public class BiologicalTermType {

    @XmlElement(name = "source-id", namespace = "http://www.aopkb.org/aop-xml")
    protected String sourceId;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected String source;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected String synonym;

    /**
     * Gets the value of the sourceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Sets the value of the sourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceId(String value) {
        this.sourceId = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the synonym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSynonym() {
        return synonym;
    }

    /**
     * Sets the value of the synonym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSynonym(String value) {
        this.synonym = value;
    }

}
