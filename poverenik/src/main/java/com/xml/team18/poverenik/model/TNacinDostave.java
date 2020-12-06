
package com.xml.team18.poverenik.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TNacinDostave complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TNacinDostave">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="elektronska-posta" type="{}TEmailDostava"/>
 *           &lt;element name="posta">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="adresa" type="{}TAdresa"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;element name="drugo" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNacinDostave", propOrder = {
    "elektronskaPostaOrPostaOrFaks",
    "drugo"
})
public class TNacinDostave {

    @XmlElementRefs({
        @XmlElementRef(name = "elektronska-posta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "faks", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "posta", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> elektronskaPostaOrPostaOrFaks;
    protected List<Object> drugo;

    /**
     * Gets the value of the elektronskaPostaOrPostaOrFaks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elektronskaPostaOrPostaOrFaks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElektronskaPostaOrPostaOrFaks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TNacinDostave.Posta }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getElektronskaPostaOrPostaOrFaks() {
        if (elektronskaPostaOrPostaOrFaks == null) {
            elektronskaPostaOrPostaOrFaks = new ArrayList<JAXBElement<?>>();
        }
        return this.elektronskaPostaOrPostaOrFaks;
    }

    /**
     * Gets the value of the drugo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drugo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrugo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getDrugo() {
        if (drugo == null) {
            drugo = new ArrayList<Object>();
        }
        return this.drugo;
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
     *         &lt;element name="adresa" type="{}TAdresa"/>
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
        "adresa"
    })
    public static class Posta {

        @XmlElement(required = true)
        protected TAdresa adresa;

        /**
         * Gets the value of the adresa property.
         * 
         * @return
         *     possible object is
         *     {@link TAdresa }
         *     
         */
        public TAdresa getAdresa() {
            return adresa;
        }

        /**
         * Sets the value of the adresa property.
         * 
         * @param value
         *     allowed object is
         *     {@link TAdresa }
         *     
         */
        public void setAdresa(TAdresa value) {
            this.adresa = value;
        }

    }

}
