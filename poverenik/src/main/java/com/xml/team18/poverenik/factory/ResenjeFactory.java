
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.docs.*;
import com.xml.team18.poverenik.model.resenje.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.List;


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
public class ResenjeFactory {

    private final static QName _Resenje_QNAME = new QName("", "resenje");
    private final static QName _PravnoSredstvoSud_QNAME = new QName("", "sud");
    private final static QName _AkcijaNacinDostave_QNAME = new QName("", "nacin-dostave");
    private final static QName _AkcijaPodnetiZahtev_QNAME = new QName("", "podneti-zahtev");
    private final static QName _AkcijaZalilac_QNAME = new QName("", "zalilac");
    private final static QName _AkcijaCenzura_QNAME = new QName("", "cenzura");
    private final static QName _OdbijanjeUzrok_QNAME = new QName("", "uzrok");
    private final static QName _UputPoverenikaOsnov_QNAME = new QName("", "osnov");
    private final static QName _TeloOdbijanje_QNAME = new QName("", "odbijanje");
    private final static QName _TeloNalog_QNAME = new QName("", "nalog");
    private final static QName _NacinDostaveElektronskaPosta_QNAME = new QName("", "elektronska-posta");
    private final static QName _NacinDostaveFaks_QNAME = new QName("", "faks");
    private final static QName _NacinDostavePosta_QNAME = new QName("", "posta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ResenjeFactory() {
    }

    /**
     * Create an instance of {@link Organ }
     * 
     */
    public Organ createOrgan() {
        return new Organ();
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
     * Create an instance of {@link NacinDostave }
     * 
     */
    public NacinDostave createNacinDostave() {
        return new NacinDostave();
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
    }

    /**
     * Create an instance of {@link Uzrok }
     * 
     */
    public Uzrok createUzrok() {
        return new Uzrok();
    }

    /**
     * Create an instance of {@link Predgovor }
     * 
     */
    public Predgovor createPredgovor() {
        return new Predgovor();
    }

    /**
     * Create an instance of {@link IzjavaZalbe }
     * 
     */
    public IzjavaZalbe createIzjavaZalbe() {
        return new IzjavaZalbe();
    }

    /**
     * Create an instance of {@link Akcija }
     * 
     */
    public Akcija createAkcija() {
        return new Akcija();
    }

    /**
     * Create an instance of {@link NegativnoObavestenje }
     * 
     */
    public NegativnoObavestenje createNegativnoObavestenje() {
        return new NegativnoObavestenje();
    }

    /**
     * Create an instance of {@link Nepostupanje }
     * 
     */
    public Nepostupanje createNepostupanje() {
        return new Nepostupanje();
    }

    /**
     * Create an instance of {@link Osnov }
     * 
     */
    public Osnov createOsnov() {
        return new Osnov();
    }

    /**
     * Create an instance of {@link Obrazlozenje }
     * 
     */
    public Obrazlozenje createObrazlozenje() {
        return new Obrazlozenje();
    }

    /**
     * Create an instance of {@link PravnoSredstvo }
     * 
     */
    public PravnoSredstvo createPravnoSredstvo() {
        return new PravnoSredstvo();
    }

    /**
     * Create an instance of {@link Nalog }
     * 
     */
    public Nalog createNalog() {
        return new Nalog();
    }

    /**
     * Create an instance of {@link Odbijanje }
     * 
     */
    public Odbijanje createOdbijanje() {
        return new Odbijanje();
    }

    /**
     * Create an instance of {@link Tok }
     * 
     */
    public Tok createTok() {
        return new Tok();
    }

    /**
     * Create an instance of {@link Obavestiti }
     * 
     */
    public Obavestiti createObavestiti() {
        return new Obavestiti();
    }

    /**
     * Create an instance of {@link Telo }
     * 
     */
    public Telo createTelo() {
        return new Telo();
    }

    /**
     * Create an instance of {@link DonosenjeOdluke }
     * 
     */
    public DonosenjeOdluke createDonosenjeOdluke() {
        return new DonosenjeOdluke();
    }

    /**
     * Create an instance of {@link UputPoverenika }
     * 
     */
    public UputPoverenika createUputPoverenika() {
        return new UputPoverenika();
    }

    /**
     * Create an instance of {@link Organ.Naziv }
     * 
     */
    public Organ.Naziv createOrganNaziv() {
        return new Organ.Naziv();
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
     * Create an instance of {@link NacinDostave.Posta }
     * 
     */
    public NacinDostave.Posta createNacinDostavePosta() {
        return new NacinDostave.Posta();
    }

    /**
     * Create an instance of {@link Resenje.Datum }
     * 
     */
    public Resenje.Datum createResenjeDatum() {
        return new Resenje.Datum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resenje")
    public JAXBElement<Resenje> createResenje(Resenje value) {
        return new JAXBElement<Resenje>(_Resenje_QNAME, Resenje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sud", scope = PravnoSredstvo.class)
    public JAXBElement<Organ> createPravnoSredstvoSud(Organ value) {
        return new JAXBElement<Organ>(_PravnoSredstvoSud_QNAME, Organ.class, PravnoSredstvo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NacinDostave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nacin-dostave", scope = Akcija.class)
    public JAXBElement<NacinDostave> createAkcijaNacinDostave(NacinDostave value) {
        return new JAXBElement<NacinDostave>(_AkcijaNacinDostave_QNAME, NacinDostave.class, Akcija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PodnetiZahtev }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podneti-zahtev", scope = Akcija.class)
    public JAXBElement<PodnetiZahtev> createAkcijaPodnetiZahtev(PodnetiZahtev value) {
        return new JAXBElement<PodnetiZahtev>(_AkcijaPodnetiZahtev_QNAME, PodnetiZahtev.class, Akcija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Osoba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = Akcija.class)
    public JAXBElement<Osoba> createAkcijaZalilac(Osoba value) {
        return new JAXBElement<Osoba>(_AkcijaZalilac_QNAME, Osoba.class, Akcija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cenzura", scope = Akcija.class)
    public JAXBElement<List<String>> createAkcijaCenzura(List<String> value) {
        return new JAXBElement<List<String>>(_AkcijaCenzura_QNAME, ((Class) List.class), Akcija.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Uzrok }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uzrok", scope = Odbijanje.class)
    public JAXBElement<Uzrok> createOdbijanjeUzrok(Uzrok value) {
        return new JAXBElement<Uzrok>(_OdbijanjeUzrok_QNAME, Uzrok.class, Odbijanje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = Odbijanje.class)
    public JAXBElement<Lice> createOdbijanjeZalilac(Lice value) {
        return new JAXBElement<Lice>(_AkcijaZalilac_QNAME, Lice.class, Odbijanje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Osnov }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "osnov", scope = UputPoverenika.class)
    public JAXBElement<Osnov> createUputPoverenikaOsnov(Osnov value) {
        return new JAXBElement<Osnov>(_UputPoverenikaOsnov_QNAME, Osnov.class, UputPoverenika.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Odbijanje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "odbijanje", scope = Telo.class)
    public JAXBElement<Odbijanje> createTeloOdbijanje(Odbijanje value) {
        return new JAXBElement<Odbijanje>(_TeloOdbijanje_QNAME, Odbijanje.class, Telo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nalog", scope = Telo.class)
    public JAXBElement<Nalog> createTeloNalog(Nalog value) {
        return new JAXBElement<Nalog>(_TeloNalog_QNAME, Nalog.class, Telo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "elektronska-posta", scope = NacinDostave.class)
    public JAXBElement<String> createNacinDostaveElektronskaPosta(String value) {
        return new JAXBElement<String>(_NacinDostaveElektronskaPosta_QNAME, String.class, NacinDostave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "faks", scope = NacinDostave.class)
    public JAXBElement<String> createNacinDostaveFaks(String value) {
        return new JAXBElement<String>(_NacinDostaveFaks_QNAME, String.class, NacinDostave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NacinDostave.Posta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "posta", scope = NacinDostave.class)
    public JAXBElement<NacinDostave.Posta> createNacinDostavePosta(NacinDostave.Posta value) {
        return new JAXBElement<NacinDostave.Posta>(_NacinDostavePosta_QNAME, NacinDostave.Posta.class, NacinDostave.class, value);
    }

}
