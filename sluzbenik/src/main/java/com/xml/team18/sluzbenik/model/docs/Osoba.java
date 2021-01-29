
package com.xml.team18.sluzbenik.model.docs;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Osoba complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Osoba">
 *   &lt;complexContent>
 *     &lt;extension base="{}Lice">
 *       &lt;sequence>
 *         &lt;element name="ime-prezime">
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
 *       &lt;attribute name="id">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[\w]{8}(-[\w]{4}){3}-[\w]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Osoba", propOrder = {
        "imePrezime"
})
public class Osoba
        extends Lice {

    @XmlElement(name = "ime-prezime", required = true)
    protected ImePrezime imePrezime;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the imePrezime property.
     *
     * @return possible object is
     * {@link ImePrezime }
     */
    public ImePrezime getImePrezime() {
        return imePrezime;
    }

    /**
     * Sets the value of the imePrezime property.
     *
     * @param value allowed object is
     *              {@link ImePrezime }
     */
    public void setImePrezime(ImePrezime value) {
        this.imePrezime = value;
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
    public static class ImePrezime {

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
