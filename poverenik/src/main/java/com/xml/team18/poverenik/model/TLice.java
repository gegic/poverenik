
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TLice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TLice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresa" type="{}TAdresa" minOccurs="0"/>
 *         &lt;element name="ostali-podaci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLice", propOrder = {
    "adresa",
    "ostaliPodaci"
})
@XmlSeeAlso({
    TOsoba.class,
    TOrgan.class
})
public abstract class TLice {

    protected TAdresa adresa;
    @XmlElement(name = "ostali-podaci")
    protected String ostaliPodaci;

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the ostaliPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOstaliPodaci() {
        return ostaliPodaci;
    }

    /**
     * Sets the value of the ostaliPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOstaliPodaci(String value) {
        this.ostaliPodaci = value;
    }

}
