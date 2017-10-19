
package org.qsari.effectopedia.data.aopxml.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wiki-status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Open for citation &amp; comment"/>
 *               &lt;enumeration value="Open for comment. Do not cite"/>
 *               &lt;enumeration value="Open for adoption"/>
 *               &lt;enumeration value="Not under active development"/>
 *               &lt;enumeration value="Under development: Not open for comment. Do not cite"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="oecd-status" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="TFHA/WNT Endorsed"/>
 *               &lt;enumeration value="EAGMST Approved"/>
 *               &lt;enumeration value="EAGMST Under Review"/>
 *               &lt;enumeration value="Under Development"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="saaop-status" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Included in OECD Work Plan"/>
 *               &lt;enumeration value="Proposed for OECD Work Plan"/>
 *               &lt;enumeration value="Under Development"/>
 *               &lt;enumeration value="Archived"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status", namespace = "http://www.aopkb.org/aop-xml", propOrder = {
    "wikiStatus",
    "oecdStatus",
    "saaopStatus"
})
public class Status {

    @XmlElement(name = "wiki-status", namespace = "http://www.aopkb.org/aop-xml", required = true)
    protected String wikiStatus;
    @XmlElement(name = "oecd-status", namespace = "http://www.aopkb.org/aop-xml")
    protected String oecdStatus;
    @XmlElement(name = "saaop-status", namespace = "http://www.aopkb.org/aop-xml")
    protected String saaopStatus;

    /**
     * Gets the value of the wikiStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWikiStatus() {
        return wikiStatus;
    }

    /**
     * Sets the value of the wikiStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWikiStatus(String value) {
        this.wikiStatus = value;
    }

    /**
     * Gets the value of the oecdStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOecdStatus() {
        return oecdStatus;
    }

    /**
     * Sets the value of the oecdStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOecdStatus(String value) {
        this.oecdStatus = value;
    }

    /**
     * Gets the value of the saaopStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaaopStatus() {
        return saaopStatus;
    }

    /**
     * Sets the value of the saaopStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaaopStatus(String value) {
        this.saaopStatus = value;
    }

}
