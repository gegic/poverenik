
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.docs.*;
import com.xml.team18.poverenik.model.zalba.cutanje.BiranjeRazloga;
import com.xml.team18.poverenik.model.zalba.cutanje.IzborRazloga;
import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
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
@XmlRegistry
@Component
public class ZalbaCutanjeFactory {

    private final static QName _ZalbaCutanje_QNAME = new QName("", "zalba-cutanje");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ZalbaCutanjeFactory() {
    }

    /**
     * Create an instance of {@link Organ }
     * 
     */
    public Organ createOrgan() {
        return new Organ();
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
     * Create an instance of {@link PodnetiZahtev }
     * 
     */
    public PodnetiZahtev createPodnetiZahtev() {
        return new PodnetiZahtev();
    }

    /**
     * Create an instance of {@link ListObjave }
     * 
     */
    public ListObjave createListObjave() {
        return new ListObjave();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Osoba }
     * 
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Zalba }
     * 
     */
    public Zalba createZalba() {
        return new Zalba();
    }

    /**
     * Create an instance of {@link IzborRazloga }
     * 
     */
    public IzborRazloga createIzborRazloga() {
        return new IzborRazloga();
    }

    /**
     * Create an instance of {@link BiranjeRazloga }
     * 
     */
    public BiranjeRazloga createBiranjeRazloga() {
        return new BiranjeRazloga();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     * 
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav.Tacka }
     * 
     */
    public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
        return new Akt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link PodnetiZahtev.Datum }
     * 
     */
    public PodnetiZahtev.Datum createPodnetiZahtevDatum() {
        return new PodnetiZahtev.Datum();
    }

    /**
     * Create an instance of {@link PodnetiZahtev.OpisZahteva }
     * 
     */
    public PodnetiZahtev.OpisZahteva createPodnetiZahtevOpisZahteva() {
        return new PodnetiZahtev.OpisZahteva();
    }

    /**
     * Create an instance of {@link ListObjave.Broj }
     * 
     */
    public ListObjave.Broj createListObjaveBroj() {
        return new ListObjave.Broj();
    }

    /**
     * Create an instance of {@link Adresa.Mesto }
     * 
     */
    public Adresa.Mesto createAdresaMesto() {
        return new Adresa.Mesto();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     * 
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Osoba.ImePrezime }
     * 
     */
    public Osoba.ImePrezime createOsobaImePrezime() {
        return new Osoba.ImePrezime();
    }

    /**
     * Create an instance of {@link Zalba.Mesto }
     * 
     */
    public Zalba.Mesto createZalbaMesto() {
        return new Zalba.Mesto();
    }

    /**
     * Create an instance of {@link Zalba.Datum }
     * 
     */
    public Zalba.Datum createZalbaDatum() {
        return new Zalba.Datum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zalba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalba-cutanje")
    public JAXBElement<Zalba> createZalbaCutanje(Zalba value) {
        return new JAXBElement<Zalba>(_ZalbaCutanje_QNAME, Zalba.class, null, value);
    }

}
