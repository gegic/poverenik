
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Osoba;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Resenje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Resenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
 *         &lt;element name="predgovor" type="{}Predgovor"/>
 *         &lt;element name="telo" type="{}Telo"/>
 *         &lt;element name="obrazlozenje" type="{}Obrazlozenje"/>
 *         &lt;element name="poverenik" type="{}Osoba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{3}-\d{2}-\d{4}/\d{4}-\d{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="vocab" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[\w]{8}(-[\w]{4}){3}-[\w]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resenje", propOrder = {
        "datum",
        "predgovor",
        "telo",
        "obrazlozenje",
        "poverenik"
})
public class Resenje {

    @XmlElement(required = true)
    protected Resenje.Datum datum;
    @XmlElement(required = true)
    protected Predgovor predgovor;
    @XmlElement(required = true)
    protected Telo telo;
    @XmlElement(required = true)
    protected Obrazlozenje obrazlozenje;
    @XmlElement(required = true)
    protected Osoba poverenik;
    @XmlAttribute(name = "rdfa_re", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String re;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;
    @XmlAttribute(name = "broj", required = true)
    protected String broj;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link Resenje.Datum }
     */
    public Resenje.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link Resenje.Datum }
     */
    public void setDatum(Resenje.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the predgovor property.
     *
     * @return possible object is
     * {@link Predgovor }
     */
    public Predgovor getPredgovor() {
        return predgovor;
    }

    /**
     * Sets the value of the predgovor property.
     *
     * @param value allowed object is
     *              {@link Predgovor }
     */
    public void setPredgovor(Predgovor value) {
        this.predgovor = value;
    }

    /**
     * Gets the value of the telo property.
     *
     * @return possible object is
     * {@link Telo }
     */
    public Telo getTelo() {
        return telo;
    }

    /**
     * Sets the value of the telo property.
     *
     * @param value allowed object is
     *              {@link Telo }
     */
    public void setTelo(Telo value) {
        this.telo = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     *
     * @return possible object is
     * {@link Obrazlozenje }
     */
    public Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     *
     * @param value allowed object is
     *              {@link Obrazlozenje }
     */
    public void setObrazlozenje(Obrazlozenje value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the poverenik property.
     *
     * @return possible object is
     * {@link Osoba }
     */
    public Osoba getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     *
     * @param value allowed object is
     *              {@link Osoba }
     */
    public void setPoverenik(Osoba value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the broj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the vocab property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVocab() {
        return vocab;
    }

    /**
     * Sets the value of the vocab property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVocab(String value) {
        this.vocab = value;
    }

    /**
     * Gets the value of the about property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAbout(String value) {
        this.about = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
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
         * @return possible object is
         * {@link XMLGregorianCalendar }
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is
         *              {@link XMLGregorianCalendar }
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

        /**
         * Gets the value of the property property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getProperty() {
            return property;
        }

        /**
         * Sets the value of the property property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setProperty(String value) {
            this.property = value;
        }

        /**
         * Gets the value of the datatype property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDatatype() {
            return datatype;
        }

        /**
         * Sets the value of the datatype property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDatatype(String value) {
            this.datatype = value;
        }

    }

}
