
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TVremePeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVremePeriod">
 *   &lt;complexContent>
 *     &lt;extension base="{}TVreme">
 *       &lt;attribute name="zavrsetak" type="{http://www.w3.org/2001/XMLSchema}time" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVremePeriod")
public class TVremePeriod
    extends TVreme
{

    @XmlAttribute(name = "zavrsetak")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar zavrsetak;

    /**
     * Gets the value of the zavrsetak property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZavrsetak() {
        return zavrsetak;
    }

    /**
     * Sets the value of the zavrsetak property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZavrsetak(XMLGregorianCalendar value) {
        this.zavrsetak = value;
    }

}
