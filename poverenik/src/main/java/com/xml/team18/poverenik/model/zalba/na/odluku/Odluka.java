
package com.xml.team18.poverenik.model.zalba.na.odluku;

import com.xml.team18.poverenik.model.docs.Organ;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Odluka complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Odluka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="donosilac" type="{}Organ"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[\w]{8}(-[\w]{4}){3}-[\w]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Odluka", propOrder = {
        "broj",
        "datum",
        "donosilac"
})
public class Odluka {

    @XmlElement(required = true)
    protected String broj;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected Organ donosilac;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the broj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the donosilac property.
     *
     * @return possible object is
     * {@link Organ }
     */
    public Organ getDonosilac() {
        return donosilac;
    }

    /**
     * Sets the value of the donosilac property.
     *
     * @param value allowed object is
     *              {@link Organ }
     */
    public void setDonosilac(Organ value) {
        this.donosilac = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

}
