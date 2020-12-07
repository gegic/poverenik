
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.zahtev.*;
import com.xml.team18.poverenik.model.poverenik.*;
import org.springframework.stereotype.Component;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@Component
@XmlRegistry
public class ZahtevFactory extends PoverenikFactory{

    private final static QName _Zahtev_QNAME = new QName("", "zahtev");
    private final static QName _ZahtevOrgan_QNAME = new QName("", "organ");
    private final static QName _ZahtevNaslov_QNAME = new QName("", "naslov");
    private final static QName _ZahtevZakon_QNAME = new QName("", "zakon");
    private final static QName _ZahtevTipZahteva_QNAME = new QName("", "tip-zahteva");
    private final static QName _ZahtevTipInformacije_QNAME = new QName("", "tip-informacije");
    private final static QName _ZahtevMesto_QNAME = new QName("", "mesto");
    private final static QName _ZahtevTrazilacInformacije_QNAME = new QName("", "trazilac-informacije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ZahtevFactory() {
    }

    /**
     * Create an instance of {@link Akt }
     * 
     */
    public Akt createAkt() {
        return new Akt();
    }

    /**
     * Create an instance of {@link Akt.Clan }
     * 
     */
    public Akt.Clan createAktClan() {
        return new Akt.Clan();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav }
     * 
     */
    public Akt.Clan.Stav createAktClanStav() {
        return new Akt.Clan.Stav();
    }

    /**
     * Create an instance of {@link ListObjave }
     * 
     */
    public ListObjave createListObjave() {
        return new ListObjave();
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link IzborZahteva }
     * 
     */
    public IzborZahteva createIzborZahteva() {
        return new IzborZahteva();
    }

    /**
     * Create an instance of {@link Osoba }
     * 
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link BiranjeZahteva }
     * 
     */
    public BiranjeZahteva createBiranjeZahteva() {
        return new BiranjeZahteva();
    }

    /**
     * Create an instance of {@link Organ }
     * 
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav.Tacka }
     * 
     */
    public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
        return new Akt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link ListObjave.Broj }
     * 
     */
    public ListObjave.Broj createListObjaveBroj() {
        return new ListObjave.Broj();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zahtev }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zahtev")
    public JAXBElement<Zahtev> createZahtev(Zahtev value) {
        return new JAXBElement<Zahtev>(_Zahtev_QNAME, Zahtev.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "organ", scope = Zahtev.class)
    public JAXBElement<Organ> createZahtevOrgan(Organ value) {
        return new JAXBElement<Organ>(_ZahtevOrgan_QNAME, Organ.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "naslov", scope = Zahtev.class)
    public JAXBElement<String> createZahtevNaslov(String value) {
        return new JAXBElement<String>(_ZahtevNaslov_QNAME, String.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Akt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = Zahtev.class)
    public JAXBElement<Akt> createZahtevZakon(Akt value) {
        return new JAXBElement<Akt>(_ZahtevZakon_QNAME, Akt.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiranjeZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tip-zahteva", scope = Zahtev.class)
    public JAXBElement<BiranjeZahteva> createZahtevTipZahteva(BiranjeZahteva value) {
        return new JAXBElement<BiranjeZahteva>(_ZahtevTipZahteva_QNAME, BiranjeZahteva.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tip-informacije", scope = Zahtev.class)
    public JAXBElement<String> createZahtevTipInformacije(String value) {
        return new JAXBElement<String>(_ZahtevTipInformacije_QNAME, String.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mesto", scope = Zahtev.class)
    public JAXBElement<String> createZahtevMesto(String value) {
        return new JAXBElement<String>(_ZahtevMesto_QNAME, String.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Osoba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "trazilac-informacije", scope = Zahtev.class)
    public JAXBElement<Osoba> createZahtevTrazilacInformacije(Osoba value) {
        return new JAXBElement<Osoba>(_ZahtevTrazilacInformacije_QNAME, Osoba.class, Zahtev.class, value);
    }

}
