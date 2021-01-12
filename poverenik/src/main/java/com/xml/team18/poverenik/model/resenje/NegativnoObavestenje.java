
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.PodnetiZahtev;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for NegativnoObavestenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NegativnoObavestenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="podneti-zahtev" type="{}PodnetiZahtev"/>
 *       &lt;/sequence>
 *       &lt;attribute name="broj" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{2}-\d{2}-\d{5}/\d{4}-\d{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativnoObavestenje", propOrder = {
    "podnetiZahtev"
})
public class NegativnoObavestenje {

    @XmlElement(name = "podneti-zahtev", required = true)
    protected PodnetiZahtev podnetiZahtev;
    @XmlAttribute(name = "broj", required = true)
    protected String broj;

    /**
     * Gets the value of the podnetiZahtev property.
     * 
     * @return
     *     possible object is
     *     {@link PodnetiZahtev }
     *     
     */
    public PodnetiZahtev getPodnetiZahtev() {
        return podnetiZahtev;
    }

    /**
     * Sets the value of the podnetiZahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodnetiZahtev }
     *     
     */
    public void setPodnetiZahtev(PodnetiZahtev value) {
        this.podnetiZahtev = value;
    }

    /**
     * Gets the value of the broj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroj(String value) {
        this.broj = value;
    }

}
