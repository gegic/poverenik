package com.xml.team18.sluzbenik.model.izjasnjenje;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="tip-zalbe"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="cutanje"/&gt;
 *             &lt;enumeration value="na-odluku"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="id-zalbe" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "izjasnjenje")
public class Izjasnjenje {

    @XmlAttribute(name = "tip-zalbe")
    protected String tipZalbe;
    @XmlAttribute(name = "id-zalbe")
    protected String idZalbe;
    @Getter
    @Setter
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @Getter
    @Setter
    @XmlAttribute(name = "id-zahteva")
    protected String idZahteva;
    @Getter
    @Setter
    @XmlAttribute(name = "id-obavestenja")
    protected String idObavestenja;
    /**
     * Gets the value of the tipZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipZalbe() {
        return tipZalbe;
    }

    /**
     * Sets the value of the tipZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipZalbe(String value) {
        this.tipZalbe = value;
    }

    /**
     * Gets the value of the idZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdZalbe() {
        return idZalbe;
    }

    /**
     * Sets the value of the idZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdZalbe(String value) {
        this.idZalbe = value;
    }

}
