
package com.xml.team18.sluzbenik.factory;

import com.xml.team18.sluzbenik.model.docs.*;
import com.xml.team18.sluzbenik.model.zahtev.BiranjeZahteva;
import com.xml.team18.sluzbenik.model.zahtev.IzborZahteva;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
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
 */
@XmlRegistry
@Component
public class ZahtevFactory {

    private final static QName _Zahtev_QNAME = new QName("", "zahtev");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     */
    public ZahtevFactory() {
    }

    /**
     * Create an instance of {@link Organ }
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link Akt }
     */
    public Akt createAkt() {
        return new Akt();
    }

    /**
     * Create an instance of {@link Akt.Clan }
     */
    public Akt.Clan createAktClan() {
        return new Akt.Clan();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav }
     */
    public Akt.Clan.Stav createAktClanStav() {
        return new Akt.Clan.Stav();
    }

    /**
     * Create an instance of {@link PodnetiZahtev }
     */
    public PodnetiZahtev createPodnetiZahtev() {
        return new PodnetiZahtev();
    }

    /**
     * Create an instance of {@link ListObjave }
     */
    public ListObjave createListObjave() {
        return new ListObjave();
    }

    /**
     * Create an instance of {@link Adresa }
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Osoba }
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Zahtev }
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link IzborZahteva }
     */
    public IzborZahteva createIzborZahteva() {
        return new IzborZahteva();
    }

    /**
     * Create an instance of {@link BiranjeZahteva }
     */
    public BiranjeZahteva createBiranjeZahteva() {
        return new BiranjeZahteva();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav.Tacka }
     */
    public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
        return new Akt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link PodnetiZahtev.Datum }
     */
    public PodnetiZahtev.Datum createPodnetiZahtevDatum() {
        return new PodnetiZahtev.Datum();
    }

    /**
     * Create an instance of {@link PodnetiZahtev.OpisZahteva }
     */
    public PodnetiZahtev.OpisZahteva createPodnetiZahtevOpisZahteva() {
        return new PodnetiZahtev.OpisZahteva();
    }

    /**
     * Create an instance of {@link ListObjave.Broj }
     */
    public ListObjave.Broj createListObjaveBroj() {
        return new ListObjave.Broj();
    }

    /**
     * Create an instance of {@link Adresa.Mesto }
     */
    public Adresa.Mesto createAdresaMesto() {
        return new Adresa.Mesto();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Osoba.ImePrezime }
     */
    public Osoba.ImePrezime createOsobaImePrezime() {
        return new Osoba.ImePrezime();
    }

    /**
     * Create an instance of {@link Zahtev.OpisZahteva }
     */
    public Zahtev.OpisZahteva createZahtevOpisZahteva() {
        return new Zahtev.OpisZahteva();
    }

    /**
     * Create an instance of {@link Zahtev.Mesto }
     */
    public Zahtev.Mesto createZahtevMesto() {
        return new Zahtev.Mesto();
    }

    /**
     * Create an instance of {@link Zahtev.Datum }
     */
    public Zahtev.Datum createZahtevDatum() {
        return new Zahtev.Datum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zahtev }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "zahtev")
    public JAXBElement<Zahtev> createZahtev(Zahtev value) {
        return new JAXBElement<Zahtev>(_Zahtev_QNAME, Zahtev.class, null, value);
    }

}
