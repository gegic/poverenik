
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TObrazlozenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TObrazlozenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tok" type="{}TTok"/>
 *         &lt;element name="opis-zakljucka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sazetak-resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pravno-sredstvo" type="{}TPravnoSredstvo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TObrazlozenje", propOrder = {
    "tok",
    "opisZakljucka",
    "sazetakResenja",
    "pravnoSredstvo"
})
public class TObrazlozenje {

    @XmlElement(required = true)
    protected TTok tok;
    @XmlElement(name = "opis-zakljucka", required = true)
    protected String opisZakljucka;
    @XmlElement(name = "sazetak-resenja", required = true)
    protected String sazetakResenja;
    @XmlElement(name = "pravno-sredstvo", required = true)
    protected TPravnoSredstvo pravnoSredstvo;

    /**
     * Gets the value of the tok property.
     * 
     * @return
     *     possible object is
     *     {@link TTok }
     *     
     */
    public TTok getTok() {
        return tok;
    }

    /**
     * Sets the value of the tok property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTok }
     *     
     */
    public void setTok(TTok value) {
        this.tok = value;
    }

    /**
     * Gets the value of the opisZakljucka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisZakljucka() {
        return opisZakljucka;
    }

    /**
     * Sets the value of the opisZakljucka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisZakljucka(String value) {
        this.opisZakljucka = value;
    }

    /**
     * Gets the value of the sazetakResenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSazetakResenja() {
        return sazetakResenja;
    }

    /**
     * Sets the value of the sazetakResenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSazetakResenja(String value) {
        this.sazetakResenja = value;
    }

    /**
     * Gets the value of the pravnoSredstvo property.
     * 
     * @return
     *     possible object is
     *     {@link TPravnoSredstvo }
     *     
     */
    public TPravnoSredstvo getPravnoSredstvo() {
        return pravnoSredstvo;
    }

    /**
     * Sets the value of the pravnoSredstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPravnoSredstvo }
     *     
     */
    public void setPravnoSredstvo(TPravnoSredstvo value) {
        this.pravnoSredstvo = value;
    }

}
