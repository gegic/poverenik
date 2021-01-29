
package com.xml.team18.poverenik.model.docs;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PodnetiZahtev complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PodnetiZahtev">
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
 *         &lt;element name="opis-zahteva" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
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
@XmlType(name = "PodnetiZahtev", propOrder = {
        "datum",
        "opisZahteva"
})
public class PodnetiZahtev {

    @XmlElement(required = true)
    protected PodnetiZahtev.Datum datum;
    @XmlElement(name = "opis-zahteva")
    protected PodnetiZahtev.OpisZahteva opisZahteva;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link PodnetiZahtev.Datum }
     */
    public PodnetiZahtev.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link PodnetiZahtev.Datum }
     */
    public void setDatum(PodnetiZahtev.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the opisZahteva property.
     *
     * @return possible object is
     * {@link PodnetiZahtev.OpisZahteva }
     */
    public PodnetiZahtev.OpisZahteva getOpisZahteva() {
        return opisZahteva;
    }

    /**
     * Sets the value of the opisZahteva property.
     *
     * @param value allowed object is
     *              {@link PodnetiZahtev.OpisZahteva }
     */
    public void setOpisZahteva(PodnetiZahtev.OpisZahteva value) {
        this.opisZahteva = value;
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class OpisZahteva {

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
         * @return possible object is
         * {@link String }
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setValue(String value) {
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
