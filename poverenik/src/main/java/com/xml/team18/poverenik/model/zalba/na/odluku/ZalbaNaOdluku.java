
package com.xml.team18.poverenik.model.zalba.na.odluku;

import com.xml.team18.poverenik.model.docs.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="primalac" type="{}Organ"/>
 *         &lt;element name="podnosilac" type="{}Osoba"/>
 *         &lt;element name="protiv" type="{}ProtivObavestenja"/>
 *         &lt;element name="zahtev" type="{}PodnetiZahtev"/>
 *         &lt;element name="deo-pobijanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{}Akt"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vocab" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[\w]{8}(-[\w]{4}){3}-[\w]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tip-resenja">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="neresena"/>
 *             &lt;enumeration value="osnovana"/>
 *             &lt;enumeration value="neosnovana"/>
 *             &lt;enumeration value="odbijen-zahtev"/>
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
@XmlType(name = "", propOrder = {
    "datum",
    "primalac",
    "podnosilac",
    "protiv",
    "zahtev",
    "deoPobijanja",
    "zakon",
    "mesto"
})
@XmlRootElement(name = "zalba-na-odluku")
public class ZalbaNaOdluku {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected Organ primalac;
    @XmlElement(required = true)
    protected Osoba podnosilac;
    @XmlElement(required = true)
    protected ProtivObavestenja protiv;
    @XmlElement(required = true)
    protected PodnetiZahtev zahtev;
    @XmlElement(name = "deo-pobijanja", required = true, defaultValue = "\u0443 \u0446\u0435\u043b\u043e\u0441\u0442\u0438")
    protected String deoPobijanja;
    @XmlElement(required = true)
    protected Akt zakon;
    @XmlElement(required = true)
    protected String mesto;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "tip-resenja")
    protected String tipResenja;
    @XmlAttribute(name = "rdfa_zno", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String zno;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the primalac property.
     * 
     * @return
     *     possible object is
     *     {@link Organ }
     *     
     */
    public Organ getPrimalac() {
        return primalac;
    }

    /**
     * Sets the value of the primalac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organ }
     *     
     */
    public void setPrimalac(Organ value) {
        this.primalac = value;
    }

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link Osoba }
     *     
     */
    public Osoba getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Osoba }
     *     
     */
    public void setPodnosilac(Osoba value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the protiv property.
     * 
     * @return
     *     possible object is
     *     {@link ProtivObavestenja }
     *     
     */
    public ProtivObavestenja getProtiv() {
        return protiv;
    }

    /**
     * Sets the value of the protiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtivObavestenja }
     *     
     */
    public void setProtiv(ProtivObavestenja value) {
        this.protiv = value;
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
     * Gets the value of the deoPobijanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeoPobijanja() {
        return deoPobijanja;
    }

    /**
     * Sets the value of the deoPobijanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeoPobijanja(String value) {
        this.deoPobijanja = value;
    }

    /**
     * Gets the value of the zakon property.
     * 
     * @return
     *     possible object is
     *     {@link Akt }
     *     
     */
    public Akt getZakon() {
        return zakon;
    }

    /**
     * Sets the value of the zakon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt }
     *     
     */
    public void setZakon(Akt value) {
        this.zakon = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the vocab property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVocab() {
        return vocab;
    }

    /**
     * Sets the value of the vocab property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVocab(String value) {
        this.vocab = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbout(String value) {
        this.about = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the tipResenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipResenja() {
        return tipResenja;
    }

    /**
     * Sets the value of the tipResenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipResenja(String value) {
        this.tipResenja = value;
    }

}
