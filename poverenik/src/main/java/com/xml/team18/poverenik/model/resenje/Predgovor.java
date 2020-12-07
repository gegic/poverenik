package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Predgovor complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Predgovor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zalilac" type="{}Lice"/>
 *         &lt;element name="uzrok" type="{}Uzrok"/>
 *         &lt;element name="osnov" type="{}Osnov"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Predgovor",
    propOrder = {"content"})
public class Predgovor {

  @XmlElementRefs({
    @XmlElementRef(name = "uzrok", type = JAXBElement.class),
    @XmlElementRef(name = "zalilac", type = JAXBElement.class),
    @XmlElementRef(name = "osnov", type = JAXBElement.class)
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
   * <p>Objects of the following type(s) are allowed in the list {@link String } {@link JAXBElement
   * }{@code <}{@link Uzrok }{@code >} {@link JAXBElement }{@code <}{@link Lice }{@code >} {@link
   * JAXBElement }{@code <}{@link Osnov }{@code >}
   */
  public List<Serializable> getContent() {
    if (content == null) {
      content = new ArrayList<Serializable>();
    }
    return this.content;
  }
}
