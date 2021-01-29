
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Osoba;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for IzjavaZalbe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IzjavaZalbe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zalilac" type="{}Osoba"/>
 *         &lt;element name="uzrok" type="{}Uzrok"/>
 *       &lt;/sequence>
 *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzjavaZalbe", propOrder = {
        "zalilac",
        "uzrok"
})
public class IzjavaZalbe {

    @XmlElement(required = true)
    protected Osoba zalilac;
    @XmlElement(required = true)
    protected Uzrok uzrok;
    @XmlAttribute(name = "datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the zalilac property.
     *
     * @return possible object is
     * {@link Osoba }
     */
    public Osoba getZalilac() {
        return zalilac;
    }

    /**
     * Sets the value of the zalilac property.
     *
     * @param value allowed object is
     *              {@link Osoba }
     */
    public void setZalilac(Osoba value) {
        this.zalilac = value;
    }

    /**
     * Gets the value of the uzrok property.
     *
     * @return possible object is
     * {@link Uzrok }
     */
    public Uzrok getUzrok() {
        return uzrok;
    }

    /**
     * Sets the value of the uzrok property.
     *
     * @param value allowed object is
     *              {@link Uzrok }
     */
    public void setUzrok(Uzrok value) {
        this.uzrok = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

}
