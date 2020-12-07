package com.xml.team18.poverenik.model.zalbanaodluku;

import com.xml.team18.poverenik.model.poverenik.Akt;
import com.xml.team18.poverenik.model.poverenik.Lice;
import com.xml.team18.poverenik.model.poverenik.Organ;
import com.xml.team18.poverenik.model.poverenik.Osoba;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Zalba complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Zalba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="svrha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primalac" type="{}Organ"/>
 *         &lt;element name="zalilac" type="{}Lice"/>
 *         &lt;element name="protiv" type="{}Odluka"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="deo-pobijanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{}Akt"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podnosilac" type="{}Osoba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(
        name = "ZalbaNaOdluku",
        propOrder = {"content"})
public class Zalba {

    @XmlElementRefs({
            @XmlElementRef(name = "datum", type = JAXBElement.class),
            @XmlElementRef(name = "protiv", type = JAXBElement.class),
            @XmlElementRef(name = "zalilac", type = JAXBElement.class),
            @XmlElementRef(name = "zakon", type = JAXBElement.class),
            @XmlElementRef(name = "podnosilac", type = JAXBElement.class),
            @XmlElementRef(name = "svrha", type = JAXBElement.class),
            @XmlElementRef(name = "deo-pobijanja", type = JAXBElement.class),
            @XmlElementRef(name = "mesto", type = JAXBElement.class),
            @XmlElementRef(name = "primalac", type = JAXBElement.class)
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
     * XMLGregorianCalendar }{@code >} {@link JAXBElement }{@code <}{@link Odluka }{@code >} {@link
     * JAXBElement }{@code <}{@link Lice }{@code >} {@link JAXBElement }{@code <}{@link Akt }{@code >}
     * {@link JAXBElement }{@code <}{@link Osoba }{@code >} {@link String } {@link JAXBElement }{@code
     * <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >} {@link
     * JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }{@code <}{@link Organ
     * }{@code >}
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
