
package mypackage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="trazilac-informacije" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="zahtevi">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="odbijeni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                           &lt;attribute name="prihvaceni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="zalbe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="cutanje" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                           &lt;attribute name="na-odluku" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
 *       &lt;attribute name="odbijeni-zahtevi" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="prihvaceni-zahtevi" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="zalbe-cutanje" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="zalbe-na-odluku" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="godina" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    "trazilacInformacije"
})
@XmlRootElement(name = "izvestaj")
public class Izvestaj {

    @XmlElement(name = "trazilac-informacije", required = true)
    protected List<Izvestaj.TrazilacInformacije> trazilacInformacije;
    @XmlAttribute(name = "odbijeni-zahtevi")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger odbijeniZahtevi;
    @XmlAttribute(name = "prihvaceni-zahtevi")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger prihvaceniZahtevi;
    @XmlAttribute(name = "zalbe-cutanje")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger zalbeCutanje;
    @XmlAttribute(name = "zalbe-na-odluku")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger zalbeNaOdluku;
    @XmlAttribute(name = "godina")
    protected Integer godina;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the trazilacInformacije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trazilacInformacije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrazilacInformacije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Izvestaj.TrazilacInformacije }
     * 
     * 
     */
    public List<Izvestaj.TrazilacInformacije> getTrazilacInformacije() {
        if (trazilacInformacije == null) {
            trazilacInformacije = new ArrayList<Izvestaj.TrazilacInformacije>();
        }
        return this.trazilacInformacije;
    }

    /**
     * Gets the value of the odbijeniZahtevi property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOdbijeniZahtevi() {
        return odbijeniZahtevi;
    }

    /**
     * Sets the value of the odbijeniZahtevi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOdbijeniZahtevi(BigInteger value) {
        this.odbijeniZahtevi = value;
    }

    /**
     * Gets the value of the prihvaceniZahtevi property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrihvaceniZahtevi() {
        return prihvaceniZahtevi;
    }

    /**
     * Sets the value of the prihvaceniZahtevi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrihvaceniZahtevi(BigInteger value) {
        this.prihvaceniZahtevi = value;
    }

    /**
     * Gets the value of the zalbeCutanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getZalbeCutanje() {
        return zalbeCutanje;
    }

    /**
     * Sets the value of the zalbeCutanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setZalbeCutanje(BigInteger value) {
        this.zalbeCutanje = value;
    }

    /**
     * Gets the value of the zalbeNaOdluku property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getZalbeNaOdluku() {
        return zalbeNaOdluku;
    }

    /**
     * Sets the value of the zalbeNaOdluku property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setZalbeNaOdluku(BigInteger value) {
        this.zalbeNaOdluku = value;
    }

    /**
     * Gets the value of the godina property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGodina() {
        return godina;
    }

    /**
     * Sets the value of the godina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGodina(Integer value) {
        this.godina = value;
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
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="zahtevi">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="odbijeni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                 &lt;attribute name="prihvaceni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="zalbe">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="cutanje" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                 &lt;attribute name="na-odluku" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
        "naziv",
        "zahtevi",
        "zalbe"
    })
    public static class TrazilacInformacije {

        @XmlElement(required = true)
        protected String naziv;
        @XmlElement(required = true)
        protected Izvestaj.TrazilacInformacije.Zahtevi zahtevi;
        @XmlElement(required = true)
        protected Izvestaj.TrazilacInformacije.Zalbe zalbe;

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
         * Gets the value of the zahtevi property.
         * 
         * @return
         *     possible object is
         *     {@link Izvestaj.TrazilacInformacije.Zahtevi }
         *     
         */
        public Izvestaj.TrazilacInformacije.Zahtevi getZahtevi() {
            return zahtevi;
        }

        /**
         * Sets the value of the zahtevi property.
         * 
         * @param value
         *     allowed object is
         *     {@link Izvestaj.TrazilacInformacije.Zahtevi }
         *     
         */
        public void setZahtevi(Izvestaj.TrazilacInformacije.Zahtevi value) {
            this.zahtevi = value;
        }

        /**
         * Gets the value of the zalbe property.
         * 
         * @return
         *     possible object is
         *     {@link Izvestaj.TrazilacInformacije.Zalbe }
         *     
         */
        public Izvestaj.TrazilacInformacije.Zalbe getZalbe() {
            return zalbe;
        }

        /**
         * Sets the value of the zalbe property.
         * 
         * @param value
         *     allowed object is
         *     {@link Izvestaj.TrazilacInformacije.Zalbe }
         *     
         */
        public void setZalbe(Izvestaj.TrazilacInformacije.Zalbe value) {
            this.zalbe = value;
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
         *       &lt;attribute name="odbijeni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *       &lt;attribute name="prihvaceni" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Zahtevi {

            @XmlAttribute(name = "odbijeni")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger odbijeni;
            @XmlAttribute(name = "prihvaceni")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger prihvaceni;

            /**
             * Gets the value of the odbijeni property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getOdbijeni() {
                return odbijeni;
            }

            /**
             * Sets the value of the odbijeni property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setOdbijeni(BigInteger value) {
                this.odbijeni = value;
            }

            /**
             * Gets the value of the prihvaceni property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPrihvaceni() {
                return prihvaceni;
            }

            /**
             * Sets the value of the prihvaceni property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPrihvaceni(BigInteger value) {
                this.prihvaceni = value;
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
         *       &lt;attribute name="cutanje" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *       &lt;attribute name="na-odluku" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Zalbe {

            @XmlAttribute(name = "cutanje")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger cutanje;
            @XmlAttribute(name = "na-odluku")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger naOdluku;

            /**
             * Gets the value of the cutanje property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getCutanje() {
                return cutanje;
            }

            /**
             * Sets the value of the cutanje property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setCutanje(BigInteger value) {
                this.cutanje = value;
            }

            /**
             * Gets the value of the naOdluku property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNaOdluku() {
                return naOdluku;
            }

            /**
             * Sets the value of the naOdluku property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNaOdluku(BigInteger value) {
                this.naOdluku = value;
            }

        }

    }

}
