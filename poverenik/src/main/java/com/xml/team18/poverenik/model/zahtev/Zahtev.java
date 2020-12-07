package com.xml.team18.poverenik.model.zahtev;

import com.xml.team18.poverenik.model.poverenik.Akt;
import com.xml.team18.poverenik.model.poverenik.Organ;
import com.xml.team18.poverenik.model.poverenik.Osoba;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Zahtev complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Zahtev">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="organ" type="{}Organ"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{}Akt"/>
 *         &lt;element name="tip-zahteva" type="{}BiranjeZahteva"/>
 *         &lt;element name="tip-informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trazilac-informacije" type="{}Osoba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Zahtev",
        propOrder = {"content"})
public class Zahtev {

    @XmlElementRefs({
            @XmlElementRef(name = "tip-informacije", type = JAXBElement.class),
            @XmlElementRef(name = "organ", type = JAXBElement.class),
            @XmlElementRef(name = "zakon", type = JAXBElement.class),
            @XmlElementRef(name = "trazilac-informacije", type = JAXBElement.class),
            @XmlElementRef(name = "naslov", type = JAXBElement.class),
            @XmlElementRef(name = "tip-zahteva", type = JAXBElement.class),
            @XmlElementRef(name = "mesto", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;

    @XmlAttribute(name = "datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the content property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is why
     * there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link
     * String }{@code >} {@link JAXBElement }{@code <}{@link Organ }{@code >} {@link JAXBElement
     * }{@code <}{@link Akt }{@code >} {@link String } {@link JAXBElement }{@code <}{@link Osoba
     * }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code
     * <}{@link BiranjeZahteva }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }
}
