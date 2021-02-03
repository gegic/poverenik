
package com.xml.team18.sluzbenik.model.resenje;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Obrazlozenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Obrazlozenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izjasnjenje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="odgovor" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pravno-sredstvo" type="{}PravnoSredstvo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Obrazlozenje", propOrder = {
    "izjasnjenje",
    "pravnoSredstvo"
})
public class Obrazlozenje {

    @XmlElement(required = true)
    protected Izjasnjenje izjasnjenje;
    @XmlElement(name = "pravno-sredstvo", required = true)
    protected PravnoSredstvo pravnoSredstvo;

    /**
     * Gets the value of the izjasnjenje property.
     *
     * @return
     *     possible object is
     *     {@link Izjasnjenje }
     *
     */
    public Izjasnjenje getIzjasnjenje() {
        return izjasnjenje;
    }

    /**
     * Sets the value of the izjasnjenje property.
     *
     * @param value
     *     allowed object is
     *     {@link Izjasnjenje }
     *
     */
    public void setIzjasnjenje(Izjasnjenje value) {
        this.izjasnjenje = value;
    }

    /**
     * Gets the value of the pravnoSredstvo property.
     * 
     * @return
     *     possible object is
     *     {@link PravnoSredstvo }
     *     
     */
    public PravnoSredstvo getPravnoSredstvo() {
        return pravnoSredstvo;
    }

    /**
     * Sets the value of the pravnoSredstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PravnoSredstvo }
     *     
     */
    public void setPravnoSredstvo(PravnoSredstvo value) {
        this.pravnoSredstvo = value;
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
     *       &lt;attribute name="odgovor" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Izjasnjenje {

        @XmlAttribute(name = "odgovor")
        protected Boolean odgovor;

        /**
         * Gets the value of the odgovor property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isOdgovor() {
            return odgovor;
        }

        /**
         * Sets the value of the odgovor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setOdgovor(Boolean value) {
            this.odgovor = value;
        }

    }

}
