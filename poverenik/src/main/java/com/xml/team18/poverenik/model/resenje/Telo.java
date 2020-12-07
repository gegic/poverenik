package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Telo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Telo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="nalog" type="{}Nalog"/>
 *         &lt;/sequence>
 *         &lt;element name="odbijanje" type="{}Odbijanje"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{}vrsta-zalbe use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Telo",
        propOrder = {"content"})
public class Telo {

    @XmlElementRefs({
            @XmlElementRef(name = "nalog", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "odbijanje", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;

    @XmlAttribute(name = "vrsta-zalbe", required = true)
    protected VrstaZalbe vrstaZalbe;

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
     * }{@code <}{@link Nalog }{@code >} {@link JAXBElement }{@code <}{@link Odbijanje }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the vrstaZalbe property.
     *
     * @return possible object is {@link VrstaZalbe }
     */
    public VrstaZalbe getVrstaZalbe() {
        return vrstaZalbe;
    }

    /**
     * Sets the value of the vrstaZalbe property.
     *
     * @param value allowed object is {@link VrstaZalbe }
     */
    public void setVrstaZalbe(VrstaZalbe value) {
        this.vrstaZalbe = value;
    }
}
