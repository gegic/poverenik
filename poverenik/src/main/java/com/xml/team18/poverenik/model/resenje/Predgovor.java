
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Osoba;
import com.xml.team18.poverenik.model.docs.PodnetiZahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Predgovor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Predgovor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zalilac" type="{}Osoba"/>
 *         &lt;element name="uzrok" type="{}Uzrok"/>
 *         &lt;element name="zahtev" type="{}PodnetiZahtev"/>
 *         &lt;element name="osnov" type="{}Osnov"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Predgovor", propOrder = {
    "zalilac",
    "uzrok",
    "zahtev",
    "osnov"
})
public class Predgovor {

    @XmlElement(required = true)
    protected Osoba zalilac;
    @XmlElement(required = true)
    protected Uzrok uzrok;
    @XmlElement(required = true)
    protected PodnetiZahtev zahtev;
    @XmlElement(required = true)
    protected Osnov osnov;

    /**
     * Gets the value of the zalilac property.
     * 
     * @return
     *     possible object is
     *     {@link Osoba }
     *     
     */
    public Osoba getZalilac() {
        return zalilac;
    }

    /**
     * Sets the value of the zalilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Osoba }
     *     
     */
    public void setZalilac(Osoba value) {
        this.zalilac = value;
    }

    /**
     * Gets the value of the uzrok property.
     * 
     * @return
     *     possible object is
     *     {@link Uzrok }
     *     
     */
    public Uzrok getUzrok() {
        return uzrok;
    }

    /**
     * Sets the value of the uzrok property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uzrok }
     *     
     */
    public void setUzrok(Uzrok value) {
        this.uzrok = value;
    }

    /**
     * Gets the value of the zahtev property.
     * 
     * @return
     *     possible object is
     *     {@link PodnetiZahtev }
     *     
     */
    public PodnetiZahtev getZahtev() {
        return zahtev;
    }

    /**
     * Sets the value of the zahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodnetiZahtev }
     *     
     */
    public void setZahtev(PodnetiZahtev value) {
        this.zahtev = value;
    }

    /**
     * Gets the value of the osnov property.
     * 
     * @return
     *     possible object is
     *     {@link Osnov }
     *     
     */
    public Osnov getOsnov() {
        return osnov;
    }

    /**
     * Sets the value of the osnov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Osnov }
     *     
     */
    public void setOsnov(Osnov value) {
        this.osnov = value;
    }

}
