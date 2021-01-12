
package com.xml.team18.poverenik.model.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IzborZahteva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IzborZahteva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="tip-dostave" type="{}BiranjeZahteva"/>
 *         &lt;element name="drugi-nacin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *       &lt;attribute name="naziv-izbora" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="izabran" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzborZahteva", propOrder = {
    "tipDostave",
    "drugiNacin"
})
public class IzborZahteva {

    @XmlElement(name = "tip-dostave")
    protected BiranjeZahteva tipDostave;
    @XmlElement(name = "drugi-nacin")
    protected String drugiNacin;
    @XmlAttribute(name = "naziv-izbora", required = true)
    protected String nazivIzbora;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "izabran")
    protected Boolean izabran;

    /**
     * Gets the value of the tipDostave property.
     * 
     * @return
     *     possible object is
     *     {@link BiranjeZahteva }
     *     
     */
    public BiranjeZahteva getTipDostave() {
        return tipDostave;
    }

    /**
     * Sets the value of the tipDostave property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiranjeZahteva }
     *     
     */
    public void setTipDostave(BiranjeZahteva value) {
        this.tipDostave = value;
    }

    /**
     * Gets the value of the drugiNacin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugiNacin() {
        return drugiNacin;
    }

    /**
     * Sets the value of the drugiNacin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugiNacin(String value) {
        this.drugiNacin = value;
    }

    /**
     * Gets the value of the nazivIzbora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivIzbora() {
        return nazivIzbora;
    }

    /**
     * Sets the value of the nazivIzbora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivIzbora(String value) {
        this.nazivIzbora = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the izabran property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIzabran() {
        return izabran;
    }

    /**
     * Sets the value of the izabran property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIzabran(Boolean value) {
        this.izabran = value;
    }

}
