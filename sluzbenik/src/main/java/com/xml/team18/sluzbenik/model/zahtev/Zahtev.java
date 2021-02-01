
package com.xml.team18.sluzbenik.model.zahtev;

import com.xml.team18.sluzbenik.model.docs.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zahtev", propOrder = {
    "organ",
    "zakon",
    "tipZahteva",
    "opisZahteva",
    "mesto",
    "datum",
    "trazilacInformacije"
})
@XmlRootElement(name = "zahtev")
public class Zahtev {

    @XmlElement(required = true)
    protected Organ organ;
    @XmlElement(required = true)
    protected Akt zakon;
    @XmlElement(name = "tip-zahteva", required = true)
    protected Zahtev.TipZahteva tipZahteva;
    @XmlElement(name = "opis-zahteva", required = true)
    protected Zahtev.OpisZahteva opisZahteva;
    @XmlElement(required = true)
    protected Zahtev.Mesto mesto;
    @XmlElement(required = true)
    protected Zahtev.Datum datum;
    @XmlElement(name = "trazilac-informacije", required = true)
    protected Osoba trazilacInformacije;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "rdfa_z", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String z;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;
    @XmlAttribute(name = "prihvatanje")
    @Getter
    @Setter
    protected String prihvatanje;
    @Getter
    @Setter
    @XmlAttribute(name = "property")
    protected String property;
    @Getter
    @Setter
    @XmlAttribute(name = "content")
    protected String content;

    /**
     * Gets the value of the organ property.
     * 
     * @return
     *     possible object is
     *     {@link Organ }
     *     
     */
    public Organ getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organ }
     *     
     */
    public void setOrgan(Organ value) {
        this.organ = value;
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
     * Gets the value of the tipZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.TipZahteva }
     *     
     */
    public Zahtev.TipZahteva getTipZahteva() {
        return tipZahteva;
    }

    /**
     * Sets the value of the tipZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.TipZahteva }
     *     
     */
    public void setTipZahteva(Zahtev.TipZahteva value) {
        this.tipZahteva = value;
    }

    /**
     * Gets the value of the opisZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.OpisZahteva }
     *     
     */
    public Zahtev.OpisZahteva getOpisZahteva() {
        return opisZahteva;
    }

    /**
     * Sets the value of the opisZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.OpisZahteva }
     *     
     */
    public void setOpisZahteva(Zahtev.OpisZahteva value) {
        this.opisZahteva = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.Mesto }
     *     
     */
    public Zahtev.Mesto getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.Mesto }
     *     
     */
    public void setMesto(Zahtev.Mesto value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.Datum }
     *     
     */
    public Zahtev.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.Datum }
     *     
     */
    public void setDatum(Zahtev.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the trazilacInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link Osoba }
     *     
     */
    public Osoba getTrazilacInformacije() {
        return trazilacInformacije;
    }

    /**
     * Sets the value of the trazilacInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link Osoba }
     *     
     */
    public void setTrazilacInformacije(Osoba value) {
        this.trazilacInformacije = value;
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
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
    public static class OpisZahteva {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String property;
        @XmlAttribute(name = "datatype")
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
     *       &lt;sequence>
     *         &lt;element name="obavestenje-posedovanja-informacije" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="uvid-u-dokument" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="kopiju-dokumenta" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="dostavljanje-kopije" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="eposta" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="drugi-nacin" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="opis-dostave">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;minLength value="1"/>
     *                                   &lt;maxLength value="50"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "obavestenjePosedovanjaInformacije",
        "uvidUDokument",
        "kopijuDokumenta",
        "dostavljanjeKopije"
    })
    public static class TipZahteva {

        @XmlElement(name = "obavestenje-posedovanja-informacije")
        protected Object obavestenjePosedovanjaInformacije;
        @XmlElement(name = "uvid-u-dokument")
        protected Object uvidUDokument;
        @XmlElement(name = "kopiju-dokumenta")
        protected Object kopijuDokumenta;
        @XmlElement(name = "dostavljanje-kopije")
        protected Zahtev.TipZahteva.DostavljanjeKopije dostavljanjeKopije;

        /**
         * Gets the value of the obavestenjePosedovanjaInformacije property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getObavestenjePosedovanjaInformacije() {
            return obavestenjePosedovanjaInformacije;
        }

        /**
         * Sets the value of the obavestenjePosedovanjaInformacije property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setObavestenjePosedovanjaInformacije(Object value) {
            this.obavestenjePosedovanjaInformacije = value;
        }

        /**
         * Gets the value of the uvidUDokument property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getUvidUDokument() {
            return uvidUDokument;
        }

        /**
         * Sets the value of the uvidUDokument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setUvidUDokument(Object value) {
            this.uvidUDokument = value;
        }

        /**
         * Gets the value of the kopijuDokumenta property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getKopijuDokumenta() {
            return kopijuDokumenta;
        }

        /**
         * Sets the value of the kopijuDokumenta property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setKopijuDokumenta(Object value) {
            this.kopijuDokumenta = value;
        }

        /**
         * Gets the value of the dostavljanjeKopije property.
         * 
         * @return
         *     possible object is
         *     {@link Zahtev.TipZahteva.DostavljanjeKopije }
         *     
         */
        public Zahtev.TipZahteva.DostavljanjeKopije getDostavljanjeKopije() {
            return dostavljanjeKopije;
        }

        /**
         * Sets the value of the dostavljanjeKopije property.
         * 
         * @param value
         *     allowed object is
         *     {@link Zahtev.TipZahteva.DostavljanjeKopije }
         *     
         */
        public void setDostavljanjeKopije(Zahtev.TipZahteva.DostavljanjeKopije value) {
            this.dostavljanjeKopije = value;
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
         *         &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="eposta" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="drugi-nacin" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="opis-dostave">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="50"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "posta",
            "faks",
            "eposta",
            "drugiNacin"
        })
        public static class DostavljanjeKopije {

            protected Object posta;
            protected Object faks;
            protected Object eposta;
            @XmlElement(name = "drugi-nacin")
            protected Zahtev.TipZahteva.DostavljanjeKopije.DrugiNacin drugiNacin;

            /**
             * Gets the value of the posta property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getPosta() {
                return posta;
            }

            /**
             * Sets the value of the posta property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setPosta(Object value) {
                this.posta = value;
            }

            /**
             * Gets the value of the faks property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getFaks() {
                return faks;
            }

            /**
             * Sets the value of the faks property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setFaks(Object value) {
                this.faks = value;
            }

            /**
             * Gets the value of the eposta property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getEposta() {
                return eposta;
            }

            /**
             * Sets the value of the eposta property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setEposta(Object value) {
                this.eposta = value;
            }

            /**
             * Gets the value of the drugiNacin property.
             * 
             * @return
             *     possible object is
             *     {@link Zahtev.TipZahteva.DostavljanjeKopije.DrugiNacin }
             *     
             */
            public Zahtev.TipZahteva.DostavljanjeKopije.DrugiNacin getDrugiNacin() {
                return drugiNacin;
            }

            /**
             * Sets the value of the drugiNacin property.
             * 
             * @param value
             *     allowed object is
             *     {@link Zahtev.TipZahteva.DostavljanjeKopije.DrugiNacin }
             *     
             */
            public void setDrugiNacin(Zahtev.TipZahteva.DostavljanjeKopije.DrugiNacin value) {
                this.drugiNacin = value;
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
             *         &lt;element name="opis-dostave">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="50"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
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
                "opisDostave"
            })
            public static class DrugiNacin {

                @XmlElement(name = "opis-dostave", required = true)
                protected String opisDostave;

                /**
                 * Gets the value of the opisDostave property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOpisDostave() {
                    return opisDostave;
                }

                /**
                 * Sets the value of the opisDostave property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOpisDostave(String value) {
                    this.opisDostave = value;
                }

            }

        }

    }

}
