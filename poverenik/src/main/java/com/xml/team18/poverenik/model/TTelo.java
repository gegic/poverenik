
package com.xml.team18.poverenik.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTelo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTelo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="nalog" type="{}TNalog"/>
 *         &lt;/sequence>
 *         &lt;element name="odbijanje" type="{}TOdbijanje"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{}vrsta-zalbe use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTelo", propOrder = {
    "content"
})
public class TTelo {

    @XmlElementRefs({
        @XmlElementRef(name = "odbijanje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nalog", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "vrsta-zalbe", required = true)
    protected TVrstaZalbe vrstaZalbe;

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
     * {@link JAXBElement }{@code <}{@link TOdbijanje }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link TNalog }{@code >}
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
     * Gets the value of the vrstaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TVrstaZalbe }
     *     
     */
    public TVrstaZalbe getVrstaZalbe() {
        return vrstaZalbe;
    }

    /**
     * Sets the value of the vrstaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVrstaZalbe }
     *     
     */
    public void setVrstaZalbe(TVrstaZalbe value) {
        this.vrstaZalbe = value;
    }

}
