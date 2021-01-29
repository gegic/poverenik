
package com.xml.team18.poverenik.model.obavestenje;

import com.xml.team18.poverenik.model.docs.Akt;
import com.xml.team18.poverenik.model.docs.Organ;
import com.xml.team18.poverenik.model.docs.Osoba;
import com.xml.team18.poverenik.model.docs.PodnetiZahtev;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Obavestenje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Obavestenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="organ" type="{}Organ"/>
 *         &lt;element name="podnosilac" type="{}Osoba"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{}Akt"/>
 *         &lt;element name="zahtev" type="{}PodnetiZahtev"/>
 *         &lt;element name="sadrzaj-obavestenja" type="{}Sadrzaj"/>
 *         &lt;element name="dodatna-odluka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="izdana-dokumenta" type="{}IzdanaDokumenta" minOccurs="0"/>
 *         &lt;element name="dostavljeno" type="{}Dostavljeno"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vocab" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[\w]{8}(-[\w]{4}){3}-[\w]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="zahtev-prihvacen" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Obavestenje", propOrder = {
        "broj",
        "datum",
        "organ",
        "podnosilac",
        "opis",
        "zakon",
        "zahtev",
        "sadrzajObavestenja",
        "dodatnaOdluka",
        "izdanaDokumenta",
        "dostavljeno"
})
public class Obavestenje {

    @XmlElement(required = true)
    protected String broj;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected Organ organ;
    @XmlElement(required = true)
    protected Osoba podnosilac;
    @XmlElement(required = true)
    protected String opis;
    @XmlElement(required = true)
    protected Akt zakon;
    @XmlElement(required = true)
    protected PodnetiZahtev zahtev;
    @XmlElement(name = "sadrzaj-obavestenja", required = true)
    protected Sadrzaj sadrzajObavestenja;
    @XmlElement(name = "dodatna-odluka")
    protected String dodatnaOdluka;
    @XmlElement(name = "izdana-dokumenta")
    protected IzdanaDokumenta izdanaDokumenta;
    @XmlElement(required = true)
    protected Dostavljeno dostavljeno;
    @XmlAttribute(name = "rdfa_ob", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String ob;
    @XmlAttribute(name = "rdfa_pred", required = true)
    @XmlSchemaType(name = "anyURI")
    @Getter
    @Setter
    protected String pred;
    @XmlAttribute(name = "vocab", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String vocab;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "zahtev-prihvacen", required = true)
    protected boolean zahtevPrihvacen;

    /**
     * Gets the value of the broj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

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
     * Gets the value of the podnosilac property.
     *
     * @return possible object is
     * {@link Osoba }
     */
    public Osoba getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     *
     * @param value allowed object is
     *              {@link Osoba }
     */
    public void setPodnosilac(Osoba value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the opis property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the zakon property.
     *
     * @return possible object is
     * {@link Akt }
     */
    public Akt getZakon() {
        return zakon;
    }

    /**
     * Sets the value of the zakon property.
     *
     * @param value allowed object is
     *              {@link Akt }
     */
    public void setZakon(Akt value) {
        this.zakon = value;
    }

    /**
     * Gets the value of the zahtev property.
     *
     * @return possible object is
     * {@link PodnetiZahtev }
     */
    public PodnetiZahtev getZahtev() {
        return zahtev;
    }

    /**
     * Sets the value of the zahtev property.
     *
     * @param value allowed object is
     *              {@link PodnetiZahtev }
     */
    public void setZahtev(PodnetiZahtev value) {
        this.zahtev = value;
    }

    /**
     * Gets the value of the sadrzajObavestenja property.
     *
     * @return possible object is
     * {@link Sadrzaj }
     */
    public Sadrzaj getSadrzajObavestenja() {
        return sadrzajObavestenja;
    }

    /**
     * Sets the value of the sadrzajObavestenja property.
     *
     * @param value allowed object is
     *              {@link Sadrzaj }
     */
    public void setSadrzajObavestenja(Sadrzaj value) {
        this.sadrzajObavestenja = value;
    }

    /**
     * Gets the value of the dodatnaOdluka property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDodatnaOdluka() {
        return dodatnaOdluka;
    }

    /**
     * Sets the value of the dodatnaOdluka property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDodatnaOdluka(String value) {
        this.dodatnaOdluka = value;
    }

    /**
     * Gets the value of the izdanaDokumenta property.
     *
     * @return possible object is
     * {@link IzdanaDokumenta }
     */
    public IzdanaDokumenta getIzdanaDokumenta() {
        return izdanaDokumenta;
    }

    /**
     * Sets the value of the izdanaDokumenta property.
     *
     * @param value allowed object is
     *              {@link IzdanaDokumenta }
     */
    public void setIzdanaDokumenta(IzdanaDokumenta value) {
        this.izdanaDokumenta = value;
    }

    /**
     * Gets the value of the dostavljeno property.
     *
     * @return possible object is
     * {@link Dostavljeno }
     */
    public Dostavljeno getDostavljeno() {
        return dostavljeno;
    }

    /**
     * Sets the value of the dostavljeno property.
     *
     * @param value allowed object is
     *              {@link Dostavljeno }
     */
    public void setDostavljeno(Dostavljeno value) {
        this.dostavljeno = value;
    }

    /**
     * Gets the value of the vocab property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVocab() {
        return vocab;
    }

    /**
     * Sets the value of the vocab property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVocab(String value) {
        this.vocab = value;
    }

    /**
     * Gets the value of the about property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAbout(String value) {
        this.about = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the zahtevPrihvacen property.
     */
    public boolean isZahtevPrihvacen() {
        return zahtevPrihvacen;
    }

    /**
     * Sets the value of the zahtevPrihvacen property.
     */
    public void setZahtevPrihvacen(boolean value) {
        this.zahtevPrihvacen = value;
    }

}
