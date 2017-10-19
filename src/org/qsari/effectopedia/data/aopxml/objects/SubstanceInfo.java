
package org.qsari.effectopedia.data.aopxml.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for substance-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="substance-info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iuc-name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="substance-properties" type="{http://www.aopkb.org/aop-xml}property-values" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "substance-info", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "title",
    "id",
    "type",
    "iucName",
    "substanceProperties"
})
public class SubstanceInfo {

    @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
    protected String title;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
    protected String id;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> type;
    @XmlElement(name = "iuc-name", namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> iucName;
    @XmlElement(name = "substance-properties", namespace = "http://www.aopkb.org/aop-xml")
    protected List<PropertyValues> substanceProperties;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the type property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getType() {
        if (type == null) {
            type = new ArrayList<String>();
        }
        return this.type;
    }

    /**
     * Gets the value of the iucName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iucName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIucName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIucName() {
        if (iucName == null) {
            iucName = new ArrayList<String>();
        }
        return this.iucName;
    }

    /**
     * Gets the value of the substanceProperties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substanceProperties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstanceProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyValues }
     * 
     * 
     */
    public List<PropertyValues> getSubstanceProperties() {
        if (substanceProperties == null) {
            substanceProperties = new ArrayList<PropertyValues>();
        }
        return this.substanceProperties;
    }

}
