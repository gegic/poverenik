
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TResenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TResenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="predgovor" type="{}TPredgovor"/>
 *         &lt;element name="telo" type="{}TTelo"/>
 *         &lt;element name="obrazlozenje" type="{}TObrazlozenje"/>
 *         &lt;element name="poverenik" type="{}TOsoba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{3}-\d{2}-\d{4}/\d{4}-\d{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TResenje", propOrder = {
    "predgovor",
    "telo",
    "obrazlozenje",
    "poverenik"
})
public class TResenje {

    @XmlElement(required = true)
    protected TPredgovor predgovor;
    @XmlElement(required = true)
    protected TTelo telo;
    @XmlElement(required = true)
    protected TObrazlozenje obrazlozenje;
    @XmlElement(required = true)
    protected TOsoba poverenik;
    @XmlAttribute(name = "broj", required = true)
    protected String broj;
    @XmlAttribute(name = "datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the predgovor property.
     * 
     * @return
     *     possible object is
     *     {@link TPredgovor }
     *     
     */
    public TPredgovor getPredgovor() {
        return predgovor;
    }

    /**
     * Sets the value of the predgovor property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPredgovor }
     *     
     */
    public void setPredgovor(TPredgovor value) {
        this.predgovor = value;
    }

    /**
     * Gets the value of the telo property.
     * 
     * @return
     *     possible object is
     *     {@link TTelo }
     *     
     */
    public TTelo getTelo() {
        return telo;
    }

    /**
     * Sets the value of the telo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTelo }
     *     
     */
    public void setTelo(TTelo value) {
        this.telo = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link TObrazlozenje }
     *     
     */
    public TObrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObrazlozenje }
     *     
     */
    public void setObrazlozenje(TObrazlozenje value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the poverenik property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setPoverenik(TOsoba value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the broj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

}
