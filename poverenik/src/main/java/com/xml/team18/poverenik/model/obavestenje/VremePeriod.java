package com.xml.team18.poverenik.model.obavestenje;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for VremePeriod complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VremePeriod">
 *   &lt;complexContent>
 *     &lt;extension base="{}Vreme">
 *       &lt;attribute name="zavrsetak" type="{http://www.w3.org/2001/XMLSchema}time" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VremePeriod")
public class VremePeriod extends Vreme {

  @XmlAttribute(name = "zavrsetak")
  @XmlSchemaType(name = "time")
  protected XMLGregorianCalendar zavrsetak;

  /**
   * Gets the value of the zavrsetak property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getZavrsetak() {
    return zavrsetak;
  }

  /**
   * Sets the value of the zavrsetak property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   */
  public void setZavrsetak(XMLGregorianCalendar value) {
    this.zavrsetak = value;
  }
}
