package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for Obrazlozenje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Obrazlozenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tok" type="{}Tok"/>
 *         &lt;element name="opis-zakljucka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sazetak-resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pravno-sredstvo" type="{}PravnoSredstvo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Obrazlozenje",
        propOrder = {"tok", "opisZakljucka", "sazetakResenja", "pravnoSredstvo"})
public class Obrazlozenje {

    @XmlElement(required = true)
    protected Tok tok;

    @XmlElement(name = "opis-zakljucka", required = true)
    protected String opisZakljucka;

    @XmlElement(name = "sazetak-resenja", required = true)
    protected String sazetakResenja;

    @XmlElement(name = "pravno-sredstvo", required = true)
    protected PravnoSredstvo pravnoSredstvo;

    /**
     * Gets the value of the tok property.
     *
     * @return possible object is {@link Tok }
     */
    public Tok getTok() {
        return tok;
    }

    /**
     * Sets the value of the tok property.
     *
     * @param value allowed object is {@link Tok }
     */
    public void setTok(Tok value) {
        this.tok = value;
    }

    /**
     * Gets the value of the opisZakljucka property.
     *
     * @return possible object is {@link String }
     */
    public String getOpisZakljucka() {
        return opisZakljucka;
    }

    /**
     * Sets the value of the opisZakljucka property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOpisZakljucka(String value) {
        this.opisZakljucka = value;
    }

    /**
     * Gets the value of the sazetakResenja property.
     *
     * @return possible object is {@link String }
     */
    public String getSazetakResenja() {
        return sazetakResenja;
    }

    /**
     * Sets the value of the sazetakResenja property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSazetakResenja(String value) {
        this.sazetakResenja = value;
    }

    /**
     * Gets the value of the pravnoSredstvo property.
     *
     * @return possible object is {@link PravnoSredstvo }
     */
    public PravnoSredstvo getPravnoSredstvo() {
        return pravnoSredstvo;
    }

    /**
     * Sets the value of the pravnoSredstvo property.
     *
     * @param value allowed object is {@link PravnoSredstvo }
     */
    public void setPravnoSredstvo(PravnoSredstvo value) {
        this.pravnoSredstvo = value;
    }
}
