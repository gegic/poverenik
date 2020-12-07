package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for DonosenjeOdluke complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DonosenjeOdluke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "DonosenjeOdluke",
    propOrder = {"content"})
public class DonosenjeOdluke {

  @XmlValue protected String content;

  @XmlAttribute(name = "datum")
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar datum;

  /**
   * Gets the value of the content property.
   *
   * @return possible object is {@link String }
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the value of the content property.
   *
   * @param value allowed object is {@link String }
   */
  public void setContent(String value) {
    this.content = value;
  }

  /**
   * Gets the value of the datum property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getDatum() {
    return datum;
  }

  /**
   * Sets the value of the datum property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   */
  public void setDatum(XMLGregorianCalendar value) {
    this.datum = value;
  }
}
