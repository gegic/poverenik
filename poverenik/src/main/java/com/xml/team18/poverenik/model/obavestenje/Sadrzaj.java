package com.xml.team18.poverenik.model.obavestenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Sadrzaj complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Sadrzaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}datum"/>
 *         &lt;element name="vreme" type="{}Vreme"/>
 *         &lt;element name="kancelarija" type="{}Kancelarija"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Sadrzaj",
    propOrder = {"content"})
public class Sadrzaj {

  @XmlElementRefs({
    @XmlElementRef(name = "datum", type = JAXBElement.class),
    @XmlElementRef(name = "vreme", type = JAXBElement.class),
    @XmlElementRef(name = "kancelarija", type = JAXBElement.class)
  })
  @XmlMixed
  protected List<Serializable> content;

  /**
   * Gets the value of the content property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the content property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getContent().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link
   * XMLGregorianCalendar }{@code >} {@link JAXBElement }{@code <}{@link Vreme }{@code >} {@link
   * String } {@link JAXBElement }{@code <}{@link Kancelarija }{@code >}
   */
  public List<Serializable> getContent() {
    if (content == null) {
      content = new ArrayList<Serializable>();
    }
    return this.content;
  }
}
