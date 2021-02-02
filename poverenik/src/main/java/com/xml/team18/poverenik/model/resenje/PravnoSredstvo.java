
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.*;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PravnoSredstvo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PravnoSredstvo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sud" type="{}Organ"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rok" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="taksa" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PravnoSredstvo", propOrder = {
    "sud"
})
public class PravnoSredstvo {

    @XmlElement(required = true)
    protected Organ sud;
    @XmlAttribute(name = "rok", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rok;
    @XmlAttribute(name = "taksa", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger taksa;

    /**
     * Gets the value of the sud property.
     * 
     * @return
     *     possible object is
     *     {@link Organ }
     *     
     */
    public Organ getSud() {
        return sud;
    }

    /**
     * Sets the value of the sud property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organ }
     *     
     */
    public void setSud(Organ value) {
        this.sud = value;
    }

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

    /**
     * Gets the value of the taksa property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaksa() {
        return taksa;
    }

    /**
     * Sets the value of the taksa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaksa(BigInteger value) {
        this.taksa = value;
    }

}
