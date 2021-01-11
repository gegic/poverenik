
package com.xml.team18.poverenik.model.obavestenje;

import com.xml.team18.poverenik.model.docs.*;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IzdanaDokumenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IzdanaDokumenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uredba" type="{}Akt"/>
 *         &lt;element name="cenovnik" type="{}Cenovnik"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="primalac" type="{}Primalac"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzdanaDokumenta", propOrder = {
    "uredba",
    "cenovnik",
    "cena",
    "primalac"
})
public class IzdanaDokumenta {

    @XmlElement(required = true)
    protected Akt uredba;
    @XmlElement(required = true)
    protected Cenovnik cenovnik;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cena;
    @XmlElement(required = true)
    protected Primalac primalac;

    /**
     * Gets the value of the uredba property.
     * 
     * @return
     *     possible object is
     *     {@link Akt }
     *     
     */
    public Akt getUredba() {
        return uredba;
    }

    /**
     * Sets the value of the uredba property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt }
     *     
     */
    public void setUredba(Akt value) {
        this.uredba = value;
    }

    /**
     * Gets the value of the cenovnik property.
     * 
     * @return
     *     possible object is
     *     {@link Cenovnik }
     *     
     */
    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    /**
     * Sets the value of the cenovnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cenovnik }
     *     
     */
    public void setCenovnik(Cenovnik value) {
        this.cenovnik = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCena(BigInteger value) {
        this.cena = value;
    }

    /**
     * Gets the value of the primalac property.
     * 
     * @return
     *     possible object is
     *     {@link Primalac }
     *     
     */
    public Primalac getPrimalac() {
        return primalac;
    }

    /**
     * Sets the value of the primalac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Primalac }
     *     
     */
    public void setPrimalac(Primalac value) {
        this.primalac = value;
    }

}
