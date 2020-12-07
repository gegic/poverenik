package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.poverenik.Organ;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for Uzrok complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Uzrok">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="obavestenje" type="{}NegativnoObavestenje"/>
 *           &lt;element name="nepostupanje" type="{}Nepostupanje"/>
 *         &lt;/choice>
 *         &lt;element name="protiv" type="{}Organ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Uzrok",
    propOrder = {"obavestenje", "nepostupanje", "protiv"})
public class Uzrok {

  protected NegativnoObavestenje obavestenje;
  protected Nepostupanje nepostupanje;

  @XmlElement(required = true)
  protected Organ protiv;

  /**
   * Gets the value of the obavestenje property.
   *
   * @return possible object is {@link NegativnoObavestenje }
   */
  public NegativnoObavestenje getObavestenje() {
    return obavestenje;
  }

  /**
   * Sets the value of the obavestenje property.
   *
   * @param value allowed object is {@link NegativnoObavestenje }
   */
  public void setObavestenje(NegativnoObavestenje value) {
    this.obavestenje = value;
  }

  /**
   * Gets the value of the nepostupanje property.
   *
   * @return possible object is {@link Nepostupanje }
   */
  public Nepostupanje getNepostupanje() {
    return nepostupanje;
  }

  /**
   * Sets the value of the nepostupanje property.
   *
   * @param value allowed object is {@link Nepostupanje }
   */
  public void setNepostupanje(Nepostupanje value) {
    this.nepostupanje = value;
  }

  /**
   * Gets the value of the protiv property.
   *
   * @return possible object is {@link Organ }
   */
  public Organ getProtiv() {
    return protiv;
  }

  /**
   * Sets the value of the protiv property.
   *
   * @param value allowed object is {@link Organ }
   */
  public void setProtiv(Organ value) {
    this.protiv = value;
  }
}
