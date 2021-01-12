
package com.xml.team18.poverenik.model.docs;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for Akt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Akt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clan" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="stav" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tacka" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sluzbeni-glasnik" type="{}ListObjave" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Akt", propOrder = {
    "naziv",
    "clan",
    "sluzbeniGlasnik"
})
public class Akt {

    @XmlElement(required = true)
    protected String naziv;
    protected Akt.Clan clan;
    @XmlElement(name = "sluzbeni-glasnik")
    protected ListObjave sluzbeniGlasnik;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the clan property.
     * 
     * @return
     *     possible object is
     *     {@link Akt.Clan }
     *     
     */
    public Akt.Clan getClan() {
        return clan;
    }

    /**
     * Sets the value of the clan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt.Clan }
     *     
     */
    public void setClan(Akt.Clan value) {
        this.clan = value;
    }

    /**
     * Gets the value of the sluzbeniGlasnik property.
     * 
     * @return
     *     possible object is
     *     {@link ListObjave }
     *     
     */
    public ListObjave getSluzbeniGlasnik() {
        return sluzbeniGlasnik;
    }

    /**
     * Sets the value of the sluzbeniGlasnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListObjave }
     *     
     */
    public void setSluzbeniGlasnik(ListObjave value) {
        this.sluzbeniGlasnik = value;
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
     *         &lt;element name="stav" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tacka" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "stav"
    })
    public static class Clan {

        protected Akt.Clan.Stav stav;
        @XmlAttribute(name = "broj", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger broj;

        /**
         * Gets the value of the stav property.
         * 
         * @return
         *     possible object is
         *     {@link Akt.Clan.Stav }
         *     
         */
        public Akt.Clan.Stav getStav() {
            return stav;
        }

        /**
         * Sets the value of the stav property.
         * 
         * @param value
         *     allowed object is
         *     {@link Akt.Clan.Stav }
         *     
         */
        public void setStav(Akt.Clan.Stav value) {
            this.stav = value;
        }

        /**
         * Gets the value of the broj property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBroj() {
            return broj;
        }

        /**
         * Sets the value of the broj property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBroj(BigInteger value) {
            this.broj = value;
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
         *         &lt;element name="tacka" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tacka"
        })
        public static class Stav {

            protected Akt.Clan.Stav.Tacka tacka;
            @XmlAttribute(name = "broj", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger broj;

            /**
             * Gets the value of the tacka property.
             * 
             * @return
             *     possible object is
             *     {@link Akt.Clan.Stav.Tacka }
             *     
             */
            public Akt.Clan.Stav.Tacka getTacka() {
                return tacka;
            }

            /**
             * Sets the value of the tacka property.
             * 
             * @param value
             *     allowed object is
             *     {@link Akt.Clan.Stav.Tacka }
             *     
             */
            public void setTacka(Akt.Clan.Stav.Tacka value) {
                this.tacka = value;
            }

            /**
             * Gets the value of the broj property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBroj() {
                return broj;
            }

            /**
             * Sets the value of the broj property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBroj(BigInteger value) {
                this.broj = value;
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
             *       &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Tacka {

                @XmlAttribute(name = "broj", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger broj;

                /**
                 * Gets the value of the broj property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getBroj() {
                    return broj;
                }

                /**
                 * Sets the value of the broj property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setBroj(BigInteger value) {
                    this.broj = value;
                }

            }

        }

    }

}
