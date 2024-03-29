
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.docs.*;
import com.xml.team18.poverenik.model.obavestenje.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the package.
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
public class ObavestenjeFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ObavestenjeFactory() {
    }

    /**
     * Create an instance of {@link PrihvacenZahtev }
     *
     */
    public PrihvacenZahtev createPrihvacenZahtev() {
        return new PrihvacenZahtev();
    }

    /**
     * Create an instance of {@link Cenovnik }
     *
     */
    public Cenovnik createCenovnik() {
        return new Cenovnik();
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
     * Create an instance of {@link PodnetiZahtev }
     *
     */
    public PodnetiZahtev createPodnetiZahtev() {
        return new PodnetiZahtev();
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
     * Create an instance of {@link Osoba }
     *
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Organ }
     *
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link Obavestenje }
     *
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link Sadrzaj }
     *
     */
    public Sadrzaj createSadrzaj() {
        return new Sadrzaj();
    }

    /**
     * Create an instance of {@link IzdanaDokumenta }
     *
     */
    public IzdanaDokumenta createIzdanaDokumenta() {
        return new IzdanaDokumenta();
    }

    /**
     * Create an instance of {@link Dostavljeno }
     *
     */
    public Dostavljeno createDostavljeno() {
        return new Dostavljeno();
    }

    /**
     * Create an instance of {@link VremePeriod }
     *
     */
    public VremePeriod createVremePeriod() {
        return new VremePeriod();
    }

    /**
     * Create an instance of {@link Primalac }
     *
     */
    public Primalac createPrimalac() {
        return new Primalac();
    }

    /**
     * Create an instance of {@link Vreme }
     *
     */
    public Vreme createVreme() {
        return new Vreme();
    }

    /**
     * Create an instance of {@link PrihvacenZahtev.Datum }
     *
     */
    public PrihvacenZahtev.Datum createPrihvacenZahtevDatum() {
        return new PrihvacenZahtev.Datum();
    }

    /**
     * Create an instance of {@link PrihvacenZahtev.Kancelarija }
     *
     */
    public PrihvacenZahtev.Kancelarija createPrihvacenZahtevKancelarija() {
        return new PrihvacenZahtev.Kancelarija();
    }

    /**
     * Create an instance of {@link Cenovnik.Stavka }
     *
     */
    public Cenovnik.Stavka createCenovnikStavka() {
        return new Cenovnik.Stavka();
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
     * Create an instance of {@link Akt.Clan.Stav.Tacka }
     *
     */
    public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
        return new Akt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link Osoba.ImePrezime }
     *
     */
    public Osoba.ImePrezime createOsobaImePrezime() {
        return new Osoba.ImePrezime();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     *
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
    }

}
