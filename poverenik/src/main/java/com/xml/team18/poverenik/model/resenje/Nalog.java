
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Organ;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Nalog complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Nalog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primalac" type="{}Organ"/>
 *         &lt;element name="akcija" type="{}Akcija"/>
 *         &lt;element name="obavestiti" type="{}Obavestiti" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Nalog", propOrder = {
        "primalac",
        "akcija",
        "obavestiti"
})
public class Nalog {

    @XmlElement(required = true)
    protected Organ primalac;
    @XmlElement(required = true)
    protected Akcija akcija;
    protected Obavestiti obavestiti;

    /**
     * Gets the value of the primalac property.
     *
     * @return possible object is
     * {@link Organ }
     */
    public Organ getPrimalac() {
        return primalac;
    }

    /**
     * Sets the value of the primalac property.
     *
     * @param value allowed object is
     *              {@link Organ }
     */
    public void setPrimalac(Organ value) {
        this.primalac = value;
    }

    /**
     * Gets the value of the akcija property.
     *
     * @return possible object is
     * {@link Akcija }
     */
    public Akcija getAkcija() {
        return akcija;
    }

    /**
     * Sets the value of the akcija property.
     *
     * @param value allowed object is
     *              {@link Akcija }
     */
    public void setAkcija(Akcija value) {
        this.akcija = value;
    }

    /**
     * Gets the value of the obavestiti property.
     *
     * @return possible object is
     * {@link Obavestiti }
     */
    public Obavestiti getObavestiti() {
        return obavestiti;
    }

    /**
     * Sets the value of the obavestiti property.
     *
     * @param value allowed object is
     *              {@link Obavestiti }
     */
    public void setObavestiti(Obavestiti value) {
        this.obavestiti = value;
    }

}
