package com.xml.team18.poverenik.model.obavestenje;

import com.xml.team18.poverenik.model.poverenik.Adresa;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

/**
 * Java class for Kancelarija complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Kancelarija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresa" type="{}Adresa"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Kancelarija",
    propOrder = {"adresa"})
public class Kancelarija {

  @XmlElement(required = true)
  protected Adresa adresa;

  @XmlAttribute(name = "broj", required = true)
  @XmlSchemaType(name = "positiveInteger")
  protected BigInteger broj;

  /**
   * Gets the value of the adresa property.
   *
   * @return possible object is {@link Adresa }
   */
  public Adresa getAdresa() {
    return adresa;
  }

  /**
   * Sets the value of the adresa property.
   *
   * @param value allowed object is {@link Adresa }
   */
  public void setAdresa(Adresa value) {
    this.adresa = value;
  }

  /**
   * Gets the value of the broj property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getBroj() {
    return broj;
  }

  /**
   * Sets the value of the broj property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setBroj(BigInteger value) {
    this.broj = value;
  }
}
