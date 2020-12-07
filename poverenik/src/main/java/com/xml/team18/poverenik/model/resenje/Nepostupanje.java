package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for Nepostupanje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Nepostupanje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}podneti-zahtev"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Nepostupanje",
    propOrder = {"podnetiZahtev"})
public class Nepostupanje {

  @XmlElement(name = "podneti-zahtev", required = true)
  protected PodnetiZahtev podnetiZahtev;

  /**
   * Gets the value of the podnetiZahtev property.
   *
   * @return possible object is {@link PodnetiZahtev }
   */
  public PodnetiZahtev getPodnetiZahtev() {
    return podnetiZahtev;
  }

  /**
   * Sets the value of the podnetiZahtev property.
   *
   * @param value allowed object is {@link PodnetiZahtev }
   */
  public void setPodnetiZahtev(PodnetiZahtev value) {
    this.podnetiZahtev = value;
  }
}
