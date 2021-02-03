
package com.xml.team18.sluzbenik.model.resenje;

import com.xml.team18.sluzbenik.model.docs.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zalilac" type="{}Osoba"/>
 *         &lt;element name="protiv" type="{}Organ"/>
 *         &lt;element name="zalba">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="obavestenje">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="nepostupanje" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/choice>
 *                 &lt;attribute name="tip">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="cutanje"/>
 *                       &lt;enumeration value="na-odluku"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zahtev" type="{}PodnetiZahtev"/>
 *         &lt;element name="osnov">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zakon" type="{}Akt" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="telo" type="{}Telo"/>
 *         &lt;element name="obrazlozenje" type="{}Obrazlozenje"/>
 *         &lt;element name="sluzbenik" type="{}Osoba"/>
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
 *       &lt;attribute name="tip">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="prihvatanje"/>
 *             &lt;enumeration value="odbijanje"/>
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
    "broj",
    "datum",
    "zalilac",
    "protiv",
    "zalba",
    "zahtev",
    "osnov",
    "telo",
    "obrazlozenje",
    "sluzbenik"
})
@XmlRootElement(name = "resenje")
public class Resenje {

    @XmlElement(required = true)
    protected String broj;
    @XmlElement(required = true)
    protected Datum datum;
    @XmlElement(required = true)
    protected Osoba zalilac;
    @XmlElement(required = true)
    protected Organ protiv;
    @XmlElement(required = true)
    protected Zalba zalba;
    @XmlElement(required = true)
    protected PodnetiZahtev zahtev;
    @XmlElement(required = true)
    protected Osnov osnov;
    @XmlElement(required = true)
    protected Telo telo;
    @XmlElement(required = true)
    protected Obrazlozenje obrazlozenje;
    @XmlElement(required = true)
    protected Osoba sluzbenik;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "tip")
    protected String tip;
    @XmlAttribute(name = "rdfa_r", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String r;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;

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
     * Gets the value of the zalba property.
     *
     * @return
     *     possible object is
     *     {@link Zalba }
     *
     */
    public Zalba getZalba() {
        return zalba;
    }

    /**
     * Sets the value of the zalba property.
     *
     * @param value
     *     allowed object is
     *     {@link Zalba }
     *
     */
    public void setZalba(Zalba value) {
        this.zalba = value;
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

    /**
     * Gets the value of the telo property.
     *
     * @return
     *     possible object is
     *     {@link Telo }
     *
     */
    public Telo getTelo() {
        return telo;
    }

    /**
     * Sets the value of the telo property.
     *
     * @param value
     *     allowed object is
     *     {@link Telo }
     *
     */
    public void setTelo(Telo value) {
        this.telo = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     *
     * @return
     *     possible object is
     *     {@link Obrazlozenje }
     *
     */
    public Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     *
     * @param value
     *     allowed object is
     *     {@link Obrazlozenje }
     *
     */
    public void setObrazlozenje(Obrazlozenje value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the sluzbenik property.
     *
     * @return
     *     possible object is
     *     {@link Osoba }
     *
     */
    public Osoba getsluzbenik() {
        return sluzbenik;
    }

    /**
     * Sets the value of the sluzbenik property.
     *
     * @param value
     *     allowed object is
     *     {@link Osoba }
     *
     */
    public void setsluzbenik(Osoba value) {
        this.sluzbenik = value;
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
     * Gets the value of the tip property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTip(String value) {
        this.tip = value;
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
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="zakon" type="{}Akt" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zakon"
    })
    public static class Osnov {

        @XmlElement(required = true)
        protected List<Akt> zakon;

        /**
         * Gets the value of the zakon property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zakon property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZakon().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Akt }
         *
         *
         */
        public List<Akt> getZakon() {
            if (zakon == null) {
                zakon = new ArrayList<Akt>();
            }
            return this.zakon;
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
     *         &lt;element name="obavestenje">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="nepostupanje" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/choice>
     *       &lt;attribute name="tip">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="cutanje"/>
     *             &lt;enumeration value="na-odluku"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "obavestenje",
        "nepostupanje",
        "datum"
    })
    public static class Zalba {

        protected Obavestenje obavestenje;
        protected Object nepostupanje;
        @XmlAttribute(name = "tip")
        protected String tip;
        @XmlAttribute(name = "id")
        protected String id;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        @Getter
        @Setter
        protected XMLGregorianCalendar datum;
        @Getter
        @Setter
        @XmlAttribute(name = "property")
        protected String property;
        @Getter
        @Setter
        @XmlAttribute(name = "content")
        protected String content;

        /**
         * Gets the value of the obavestenje property.
         *
         * @return
         *     possible object is
         *     {@link Obavestenje }
         *
         */
        public Obavestenje getObavestenje() {
            return obavestenje;
        }

        /**
         * Sets the value of the obavestenje property.
         *
         * @param value
         *     allowed object is
         *     {@link Obavestenje }
         *
         */
        public void setObavestenje(Obavestenje value) {
            this.obavestenje = value;
        }

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
         * Gets the value of the tip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTip() {
            return tip;
        }

        /**
         * Sets the value of the tip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTip(String value) {
            this.tip = value;
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



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "brojObavestenja",
                "datumObavestenja"
        })
        public static class Obavestenje {
            @Getter
            @Setter
            @XmlElement(name = "broj-obavestenja", required = true)
            protected String brojObavestenja;
            @Getter
            @Setter
            @XmlElement(name = "datum-obavestenja", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumObavestenja;
            @XmlAttribute(name = "id")
            protected String id;
            @Getter
            @Setter
            @XmlAttribute(name = "property")
            protected String property;
            @Getter
            @Setter
            @XmlAttribute(name = "content")
            protected String content;


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

        }

    }

}
