
package com.xml.team18.poverenik.model.docs;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Organ complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Organ">
 *   &lt;complexContent>
 *     &lt;extension base="{}Lice">
 *       &lt;sequence>
 *         &lt;element name="naziv">
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
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organ", propOrder = {
        "naziv"
})
public class Organ
        extends Lice {

    @XmlElement(required = true)
    protected Organ.Naziv naziv;

    /**
     * Gets the value of the naziv property.
     *
     * @return possible object is
     * {@link Organ.Naziv }
     */
    public Organ.Naziv getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value allowed object is
     *              {@link Organ.Naziv }
     */
    public void setNaziv(Organ.Naziv value) {
        this.naziv = value;
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
    public static class Naziv {

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
