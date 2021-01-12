
package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


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
    "content"
})
public class PravnoSredstvo {

    @XmlElementRef(name = "sud", type = JAXBElement.class)
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "rok", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rok;
    @XmlAttribute(name = "taksa", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger taksa;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link JAXBElement }{@code <}{@link Organ }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
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
