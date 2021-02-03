
package com.xml.team18.sluzbenik.factory;

import com.xml.team18.sluzbenik.model.docs.*;
import com.xml.team18.sluzbenik.model.resenje.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRegistry;


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
public class ResenjeFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ResenjeFactory() {
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
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
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Obrazlozenje }
     * 
     */
    public Obrazlozenje createObrazlozenje() {
        return new Obrazlozenje();
    }

    /**
     * Create an instance of {@link Telo }
     * 
     */
    public Telo createTelo() {
        return new Telo();
    }

    /**
     * Create an instance of {@link Telo.Nalog }
     * 
     */
    public Telo.Nalog createTeloNalog() {
        return new Telo.Nalog();
    }

    /**
     * Create an instance of {@link PodnetiZahtev }
     * 
     */
    public PodnetiZahtev createPodnetiZahtev() {
        return new PodnetiZahtev();
    }

    /**
     * Create an instance of {@link Resenje.Zalba }
     * 
     */
    public Resenje.Zalba createResenjeZalba() {
        return new Resenje.Zalba();
    }

    /**
     * Create an instance of {@link Organ }
     * 
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link Osoba }
     * 
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Resenje.Datum }
     * 
     */
    public Resenje.Datum createResenjeDatum() {
        return new Resenje.Datum();
    }

    /**
     * Create an instance of {@link Resenje.Osnov }
     * 
     */
    public Resenje.Osnov createResenjeOsnov() {
        return new Resenje.Osnov();
    }

    /**
     * Create an instance of {@link PravnoSredstvo }
     * 
     */
    public PravnoSredstvo createPravnoSredstvo() {
        return new PravnoSredstvo();
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
     * Create an instance of {@link Obrazlozenje.Izjasnjenje }
     * 
     */
    public Obrazlozenje.Izjasnjenje createObrazlozenjeIzjasnjenje() {
        return new Obrazlozenje.Izjasnjenje();
    }

    /**
     * Create an instance of {@link Telo.Nalog.Obavestiti }
     * 
     */
    public Telo.Nalog.Obavestiti createTeloNalogObavestiti() {
        return new Telo.Nalog.Obavestiti();
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
     * Create an instance of {@link Resenje.Zalba.Obavestenje }
     * 
     */
    public Resenje.Zalba.Obavestenje createResenjeZalbaObavestenje() {
        return new Resenje.Zalba.Obavestenje();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     * 
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
    }

    /**
     * Create an instance of {@link Osoba.ImePrezime }
     * 
     */
    public Osoba.ImePrezime createOsobaImePrezime() {
        return new Osoba.ImePrezime();
    }

}
