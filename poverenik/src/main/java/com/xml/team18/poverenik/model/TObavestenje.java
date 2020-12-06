
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TObavestenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TObavestenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}zahtev"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{2}-\d{2}-\d{5}/\d{4}-\d{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TObavestenje", propOrder = {
    "zahtev"
})
public class TObavestenje {

    @XmlElement(required = true)
    protected Zahtev zahtev;
    @XmlAttribute(name = "broj", required = true)
    protected String broj;

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

    /**
     * Gets the value of the broj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroj(String value) {
        this.broj = value;
    }

}
