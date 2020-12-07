package com.xml.team18.poverenik.model.obavestenje;

import com.xml.team18.poverenik.model.poverenik.Akt;
import com.xml.team18.poverenik.model.poverenik.Lice;
import com.xml.team18.poverenik.model.poverenik.Organ;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Obavestenje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Obavestenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="organ" type="{}Organ"/>
 *         &lt;element name="podnosilac" type="{}Lice"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{}Akt"/>
 *         &lt;element ref="{}datum"/>
 *         &lt;element name="opis-zahteva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sadrzaj-obavestenja" type="{}Sadrzaj"/>
 *         &lt;element name="odluka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uredba" type="{}Akt"/>
 *         &lt;element name="cenovnik" type="{}Cenovnik"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="primalac" type="{}Primalac"/>
 *         &lt;element name="dostavljeno" type="{}Dostavljeno"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj-predmeta" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d+/\d\d(\d\d)?"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Obavestenje",
        propOrder = {"content"})
public class Obavestenje {

    @XmlElementRefs({
            @XmlElementRef(name = "datum", type = JAXBElement.class),
            @XmlElementRef(name = "opis", type = JAXBElement.class),
            @XmlElementRef(name = "organ", type = JAXBElement.class),
            @XmlElementRef(name = "cenovnik", type = JAXBElement.class),
            @XmlElementRef(name = "dostavljeno", type = JAXBElement.class),
            @XmlElementRef(name = "primalac", type = JAXBElement.class),
            @XmlElementRef(name = "podnosilac", type = JAXBElement.class),
            @XmlElementRef(name = "opis-zahteva", type = JAXBElement.class),
            @XmlElementRef(name = "sadrzaj-obavestenja", type = JAXBElement.class),
            @XmlElementRef(name = "uredba", type = JAXBElement.class),
            @XmlElementRef(name = "zakon", type = JAXBElement.class),
            @XmlElementRef(name = "odluka", type = JAXBElement.class),
            @XmlElementRef(name = "cena", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;

    @XmlAttribute(name = "broj-predmeta", required = true)
    protected String brojPredmeta;

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
     * XMLGregorianCalendar }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link
     * JAXBElement }{@code <}{@link Organ }{@code >} {@link JAXBElement }{@code <}{@link Cenovnik
     * }{@code >} {@link JAXBElement }{@code <}{@link Dostavljeno }{@code >} {@link JAXBElement
     * }{@code <}{@link Primalac }{@code >} {@link JAXBElement }{@code <}{@link Lice }{@code >} {@link
     * JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link Sadrzaj
     * }{@code >} {@link JAXBElement }{@code <}{@link Akt }{@code >} {@link JAXBElement }{@code
     * <}{@link Akt }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link String }
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the brojPredmeta property.
     *
     * @return possible object is {@link String }
     */
    public String getBrojPredmeta() {
        return brojPredmeta;
    }

    /**
     * Sets the value of the brojPredmeta property.
     *
     * @param value allowed object is {@link String }
     */
    public void setBrojPredmeta(String value) {
        this.brojPredmeta = value;
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
