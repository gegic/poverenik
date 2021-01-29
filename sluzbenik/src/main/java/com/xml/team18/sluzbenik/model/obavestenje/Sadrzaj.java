
package com.xml.team18.sluzbenik.model.obavestenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sadrzaj complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Sadrzaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="prihvacen-zahtev" type="{}PrihvacenZahtev"/>
 *         &lt;element name="razlog-odbijanja" type="{}RazlogOdbijanja"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sadrzaj", propOrder = {
        "prihvacenZahtev",
        "razlogOdbijanja"
})
public class Sadrzaj {

    @XmlElement(name = "prihvacen-zahtev")
    protected PrihvacenZahtev prihvacenZahtev;
    @XmlElement(name = "razlog-odbijanja")
    protected String razlogOdbijanja;

    /**
     * Gets the value of the prihvacenZahtev property.
     *
     * @return possible object is
     * {@link PrihvacenZahtev }
     */
    public PrihvacenZahtev getPrihvacenZahtev() {
        return prihvacenZahtev;
    }

    /**
     * Sets the value of the prihvacenZahtev property.
     *
     * @param value allowed object is
     *              {@link PrihvacenZahtev }
     */
    public void setPrihvacenZahtev(PrihvacenZahtev value) {
        this.prihvacenZahtev = value;
    }

    /**
     * Gets the value of the razlogOdbijanja property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRazlogOdbijanja() {
        return razlogOdbijanja;
    }

    /**
     * Sets the value of the razlogOdbijanja property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRazlogOdbijanja(String value) {
        this.razlogOdbijanja = value;
    }

}
