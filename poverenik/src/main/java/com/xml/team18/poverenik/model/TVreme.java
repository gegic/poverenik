
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TVreme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVreme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="pocetak" type="{http://www.w3.org/2001/XMLSchema}time" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVreme")
@XmlSeeAlso({
    TVremePeriod.class
})
public class TVreme {

    @XmlAttribute(name = "pocetak")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar pocetak;

    /**
     * Gets the value of the pocetak property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPocetak() {
        return pocetak;
    }

    /**
     * Sets the value of the pocetak property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPocetak(XMLGregorianCalendar value) {
        this.pocetak = value;
    }

}
