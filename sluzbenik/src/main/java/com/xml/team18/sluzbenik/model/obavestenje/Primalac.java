
package com.xml.team18.sluzbenik.model.obavestenje;

import com.xml.team18.sluzbenik.model.docs.Organ;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Primalac complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Primalac">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="organ" type="{}Organ"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj-racuna" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{3}-\d{6}-\d{3}-\d{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="com.xml.team18.sluzbenik.model" type="{http://www.w3.org/2001/XMLSchema}int" default="97" />
 *       &lt;attribute name="poziv-na-broj" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Primalac", propOrder = {
        "organ"
})
public class Primalac {

    @XmlElement(required = true)
    protected Organ organ;
    @XmlAttribute(name = "broj-racuna", required = true)
    protected String brojRacuna;
    @XmlAttribute(name = "model")
    protected Integer model;
    @XmlAttribute(name = "poziv-na-broj", required = true)
    protected String pozivNaBroj;

    /**
     * Gets the value of the organ property.
     *
     * @return possible object is
     * {@link Organ }
     */
    public Organ getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     *
     * @param value allowed object is
     *              {@link Organ }
     */
    public void setOrgan(Organ value) {
        this.organ = value;
    }

    /**
     * Gets the value of the brojRacuna property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrojRacuna() {
        return brojRacuna;
    }

    /**
     * Sets the value of the brojRacuna property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrojRacuna(String value) {
        this.brojRacuna = value;
    }

    /**
     * Gets the value of the com.xml.team18.sluzbenik.model property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public int getModel() {
        if (model == null) {
            return 97;
        } else {
            return model;
        }
    }

    /**
     * Sets the value of the com.xml.team18.sluzbenik.model property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setModel(Integer value) {
        this.model = value;
    }

    /**
     * Gets the value of the pozivNaBroj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    /**
     * Sets the value of the pozivNaBroj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPozivNaBroj(String value) {
        this.pozivNaBroj = value;
    }

}
