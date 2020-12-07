package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.poverenik.Organ;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Nalog complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Nalog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primalac" type="{}Organ"/>
 *         &lt;element name="akcija" type="{}Akcija"/>
 *         &lt;element name="obavestiti" type="{}Obavestiti"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Nalog",
        propOrder = {"content"})
public class Nalog {

    @XmlElementRefs({
            @XmlElementRef(name = "obavestiti", type = JAXBElement.class),
            @XmlElementRef(name = "akcija", type = JAXBElement.class),
            @XmlElementRef(name = "primalac", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;

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
     * <p>Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link
     * Obavestiti }{@code >} {@link String } {@link JAXBElement }{@code <}{@link Akcija }{@code >}
     * {@link JAXBElement }{@code <}{@link Organ }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }
}
