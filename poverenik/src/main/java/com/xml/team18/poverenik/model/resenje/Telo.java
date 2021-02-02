
package com.xml.team18.poverenik.model.resenje;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Telo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Telo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="nalog">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="akcija" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                     &lt;element name="obavestiti" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;attribute name="rok" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *         &lt;element name="odbijanje" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Telo", propOrder = {
    "nalog",
    "odbijanje"
})
public class Telo {

    protected Telo.Nalog nalog;
    protected Object odbijanje;

    /**
     * Gets the value of the nalog property.
     * 
     * @return
     *     possible object is
     *     {@link Telo.Nalog }
     *     
     */
    public Telo.Nalog getNalog() {
        return nalog;
    }

    /**
     * Sets the value of the nalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link Telo.Nalog }
     *     
     */
    public void setNalog(Telo.Nalog value) {
        this.nalog = value;
    }

    /**
     * Gets the value of the odbijanje property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOdbijanje() {
        return odbijanje;
    }

    /**
     * Sets the value of the odbijanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOdbijanje(Object value) {
        this.odbijanje = value;
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
     *         &lt;element name="akcija" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="obavestiti" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="rok" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
        "akcija",
        "obavestiti"
    })
    public static class Nalog {

        protected String akcija;
        protected Telo.Nalog.Obavestiti obavestiti;

        /**
         * Gets the value of the akcija property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAkcija() {
            return akcija;
        }

        /**
         * Sets the value of the akcija property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAkcija(String value) {
            this.akcija = value;
        }

        /**
         * Gets the value of the obavestiti property.
         * 
         * @return
         *     possible object is
         *     {@link Telo.Nalog.Obavestiti }
         *     
         */
        public Telo.Nalog.Obavestiti getObavestiti() {
            return obavestiti;
        }

        /**
         * Sets the value of the obavestiti property.
         * 
         * @param value
         *     allowed object is
         *     {@link Telo.Nalog.Obavestiti }
         *     
         */
        public void setObavestiti(Telo.Nalog.Obavestiti value) {
            this.obavestiti = value;
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
         *       &lt;attribute name="rok" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Obavestiti {

            @XmlAttribute(name = "rok")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger rok;

            /**
             * Gets the value of the rok property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRok() {
                return rok;
            }

            /**
             * Sets the value of the rok property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRok(BigInteger value) {
                this.rok = value;
            }

        }

    }

}
