package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.poverenik.Organ;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Obavestiti complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Obavestiti">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primalac" type="{}Organ"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rok" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Obavestiti",
        propOrder = {"content"})
public class Obavestiti {

    @XmlElementRef(name = "primalac", type = JAXBElement.class)
    @XmlMixed
    protected List<Serializable> content;

    @XmlAttribute(name = "rok", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rok;

    /**
     * Gets the value of the content property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is why
     * there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link String } {@link JAXBElement
     * }{@code <}{@link Organ }{@code >}
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
     * @return possible object is {@link BigInteger }
     */
    public BigInteger getRok() {
        return rok;
    }

    /**
     * Sets the value of the rok property.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setRok(BigInteger value) {
        this.rok = value;
    }
}
