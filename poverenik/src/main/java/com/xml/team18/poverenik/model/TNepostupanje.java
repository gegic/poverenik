
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TNepostupanje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TNepostupanje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}zahtev"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNepostupanje", propOrder = {
    "zahtev"
})
public class TNepostupanje {

    @XmlElement(required = true)
    protected Zahtev zahtev;

    /**
     * Gets the value of the zahtev property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev }
     *     
     */
    public Zahtev getZahtev() {
        return zahtev;
    }

    /**
     * Sets the value of the zahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev }
     *     
     */
    public void setZahtev(Zahtev value) {
        this.zahtev = value;
    }

}
