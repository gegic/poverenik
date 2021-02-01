
package com.xml.team18.poverenik.model.zalba.cutanje;

import com.xml.team18.poverenik.model.docs.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "primalac",
    "zakon",
    "protiv",
    "razlog",
    "zahtev",
    "mesto",
    "datum",
    "podnosilac"
})
@XmlRootElement(name = "zalba-cutanje")
public class ZalbaCutanje {

    @XmlElement(required = true)
    protected Organ primalac;
    @XmlElement(required = true)
    protected Akt zakon;
    @XmlElement(required = true)
    protected Organ protiv;
    @XmlElement(required = true)
    protected Razlog razlog;
    @XmlElement(required = true)
    protected PodnetiZahtev zahtev;
    @XmlElement(required = true)
    protected Mesto mesto;
    @XmlElement(required = true)
    protected Datum datum;
    @XmlElement(required = true)
    protected Osoba podnosilac;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "property")
    protected String property;
    @XmlAttribute(name = "content")
    protected String content;
    @XmlAttribute(name = "rdfa_zc", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String zc;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;
    @Getter
    @Setter
    @XmlAttribute(name = "tip-resenja", required = true)
    protected String tipResenja;

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
     * Gets the value of the protiv property.
     * 
     * @return
     *     possible object is
     *     {@link Organ }
     *     
     */
    public Organ getProtiv() {
        return protiv;
    }

    /**
     * Sets the value of the protiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organ }
     *     
     */
    public void setProtiv(Organ value) {
        this.protiv = value;
    }

    /**
     * Gets the value of the razlog property.
     * 
     * @return
     *     possible object is
     *     {@link Razlog }
     *     
     */
    public Razlog getRazlog() {
        return razlog;
    }

    /**
     * Sets the value of the razlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link Razlog }
     *     
     */
    public void setRazlog(Razlog value) {
        this.razlog = value;
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
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link Mesto }
     *     
     */
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mesto }
     *     
     */
    public void setMesto(Mesto value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link Datum }
     *     
     */
    public Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datum }
     *     
     */
    public void setDatum(Datum value) {
        this.datum = value;
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
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperty(String value) {
        this.property = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
     *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Datum {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String property;
        @XmlAttribute(name = "datatype", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String datatype;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

        /**
         * Gets the value of the property property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProperty() {
            return property;
        }

        /**
         * Sets the value of the property property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProperty(String value) {
            this.property = value;
        }

        /**
         * Gets the value of the datatype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatatype() {
            return datatype;
        }

        /**
         * Sets the value of the datatype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatatype(String value) {
            this.datatype = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Mesto {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String property;
        @XmlAttribute(name = "datatype", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String datatype;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the property property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProperty() {
            return property;
        }

        /**
         * Sets the value of the property property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProperty(String value) {
            this.property = value;
        }

        /**
         * Gets the value of the datatype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatatype() {
            return datatype;
        }

        /**
         * Sets the value of the datatype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatatype(String value) {
            this.datatype = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="nepostupanje" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="nepostupanje-u-celosti" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="nepostupanje-u-roku" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nepostupanje",
        "nepostupanjeUCelosti",
        "nepostupanjeURoku"
    })
    public static class Razlog {

        protected Object nepostupanje;
        @XmlElement(name = "nepostupanje-u-celosti")
        protected Object nepostupanjeUCelosti;
        @XmlElement(name = "nepostupanje-u-roku")
        protected Object nepostupanjeURoku;

        /**
         * Gets the value of the nepostupanje property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getNepostupanje() {
            return nepostupanje;
        }

        /**
         * Sets the value of the nepostupanje property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setNepostupanje(Object value) {
            this.nepostupanje = value;
        }

        /**
         * Gets the value of the nepostupanjeUCelosti property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getNepostupanjeUCelosti() {
            return nepostupanjeUCelosti;
        }

        /**
         * Sets the value of the nepostupanjeUCelosti property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setNepostupanjeUCelosti(Object value) {
            this.nepostupanjeUCelosti = value;
        }

        /**
         * Gets the value of the nepostupanjeURoku property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getNepostupanjeURoku() {
            return nepostupanjeURoku;
        }

        /**
         * Sets the value of the nepostupanjeURoku property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setNepostupanjeURoku(Object value) {
            this.nepostupanjeURoku = value;
        }

    }

}
