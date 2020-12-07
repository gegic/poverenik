package com.xml.team18.poverenik.model.obavestenje;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Cenovnik complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Cenovnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stavka" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="artikl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="cena" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *                 &lt;attribute name="valuta" type="{http://www.w3.org/2001/XMLSchema}string" default="dinar" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Cenovnik",
    propOrder = {"stavka"})
public class Cenovnik {

  @XmlElement(required = true)
  protected List<Cenovnik.Stavka> stavka;

  /**
   * Gets the value of the stavka property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the stavka property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getStavka().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Cenovnik.Stavka }
   */
  public List<Cenovnik.Stavka> getStavka() {
    if (stavka == null) {
      stavka = new ArrayList<Cenovnik.Stavka>();
    }
    return this.stavka;
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType>
   *   &lt;complexContent>
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
   *       &lt;attribute name="artikl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
   *       &lt;attribute name="cena" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
   *       &lt;attribute name="valuta" type="{http://www.w3.org/2001/XMLSchema}string" default="dinar" />
   *     &lt;/restriction>
   *   &lt;/complexContent>
   * &lt;/complexType>
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "")
  public static class Stavka {

    @XmlAttribute(name = "artikl", required = true)
    protected String artikl;

    @XmlAttribute(name = "cena", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cena;

    @XmlAttribute(name = "valuta")
    protected String valuta;

    /**
     * Gets the value of the artikl property.
     *
     * @return possible object is {@link String }
     */
    public String getArtikl() {
      return artikl;
    }

    /**
     * Sets the value of the artikl property.
     *
     * @param value allowed object is {@link String }
     */
    public void setArtikl(String value) {
      this.artikl = value;
    }

    /**
     * Gets the value of the cena property.
     *
     * @return possible object is {@link BigInteger }
     */
    public BigInteger getCena() {
      return cena;
    }

    /**
     * Sets the value of the cena property.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setCena(BigInteger value) {
      this.cena = value;
    }

    /**
     * Gets the value of the valuta property.
     *
     * @return possible object is {@link String }
     */
    public String getValuta() {
      if (valuta == null) {
        return "dinar";
      } else {
        return valuta;
      }
    }

    /**
     * Sets the value of the valuta property.
     *
     * @param value allowed object is {@link String }
     */
    public void setValuta(String value) {
      this.valuta = value;
    }
  }
}
