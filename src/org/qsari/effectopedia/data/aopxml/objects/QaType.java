
package org.qsari.effectopedia.data.aopxml.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for qa-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="qa-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contributor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reviewer" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="seal-of-approval" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="last-modified" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "qa-type", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "contributor",
    "reviewer",
    "sealOfApproval",
    "lastModified"
})
public class QaType {

    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> contributor;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> reviewer;
    @XmlElement(name = "seal-of-approval", namespace = "http://www.aopkb.org/aop-xml")
    protected List<String> sealOfApproval;
    @XmlElement(name = "last-modified", namespace = "http://www.aopkb.org/aop-xml", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModified;

    /**
     * Gets the value of the contributor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contributor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContributor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContributor() {
        if (contributor == null) {
            contributor = new ArrayList<String>();
        }
        return this.contributor;
    }

    /**
     * Gets the value of the reviewer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviewer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReviewer() {
        if (reviewer == null) {
            reviewer = new ArrayList<String>();
        }
        return this.reviewer;
    }

    /**
     * Gets the value of the sealOfApproval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sealOfApproval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSealOfApproval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSealOfApproval() {
        if (sealOfApproval == null) {
            sealOfApproval = new ArrayList<String>();
        }
        return this.sealOfApproval;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModified(XMLGregorianCalendar value) {
        this.lastModified = value;
    }

}
