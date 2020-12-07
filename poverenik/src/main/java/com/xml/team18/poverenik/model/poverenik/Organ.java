package com.xml.team18.poverenik.model.poverenik;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for Organ complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Organ">
 *   &lt;complexContent>
 *     &lt;extension base="{}Lice">
 *       &lt;attribute name="naziv" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organ")
public class Organ extends Lice {

    @XmlAttribute(name = "naziv", required = true)
    protected String naziv;

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
}
