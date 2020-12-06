
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TUzrok complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TUzrok">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="obavestenje" type="{}TObavestenje"/>
 *           &lt;element name="nepostupanje" type="{}TNepostupanje"/>
 *         &lt;/choice>
 *         &lt;element name="protiv" type="{}TOrgan"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TUzrok", propOrder = {
    "obavestenje",
    "nepostupanje",
    "protiv"
})
public class TUzrok {

    protected TObavestenje obavestenje;
    protected TNepostupanje nepostupanje;
    @XmlElement(required = true)
    protected TOrgan protiv;

    /**
     * Gets the value of the obavestenje property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje }
     *     
     */
    public TObavestenje getObavestenje() {
        return obavestenje;
    }

    /**
     * Sets the value of the obavestenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje }
     *     
     */
    public void setObavestenje(TObavestenje value) {
        this.obavestenje = value;
    }

    /**
     * Gets the value of the nepostupanje property.
     * 
     * @return
     *     possible object is
     *     {@link TNepostupanje }
     *     
     */
    public TNepostupanje getNepostupanje() {
        return nepostupanje;
    }

    /**
     * Sets the value of the nepostupanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNepostupanje }
     *     
     */
    public void setNepostupanje(TNepostupanje value) {
        this.nepostupanje = value;
    }

    /**
     * Gets the value of the protiv property.
     * 
     * @return
     *     possible object is
     *     {@link TOrgan }
     *     
     */
    public TOrgan getProtiv() {
        return protiv;
    }

    /**
     * Sets the value of the protiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOrgan }
     *     
     */
    public void setProtiv(TOrgan value) {
        this.protiv = value;
    }

}
