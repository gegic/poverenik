package com.xml.team18.poverenik.model.zalbacutanje;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Java class for IzborRazloga complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IzborRazloga">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="naziv" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="izabran" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "IzborRazloga",
    propOrder = {"value"})
public class IzborRazloga {

  @XmlValue protected String value;

  @XmlAttribute(name = "naziv", required = true)
  protected String naziv;

  @XmlAttribute(name = "id", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlID
  @XmlSchemaType(name = "ID")
  protected String id;

  @XmlAttribute(name = "izabran")
  protected Boolean izabran;

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the naziv property.
   *
   * @return possible object is {@link String }
   */
  public String getNaziv() {
    return naziv;
  }

  /**
   * Sets the value of the naziv property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNaziv(String value) {
    this.naziv = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is {@link String }
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is {@link String }
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the izabran property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isIzabran() {
    return izabran;
  }

  /**
   * Sets the value of the izabran property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIzabran(Boolean value) {
    this.izabran = value;
  }
}
