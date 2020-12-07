package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.obavestenje.*;
import com.xml.team18.poverenik.model.poverenik.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigInteger;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the mypackage package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@Component
@XmlRegistry
public class ObavestenjeFactory extends PoverenikFactory {

    private static final QName _Datum_QNAME = new QName("", "datum");
    private static final QName _Obavestenje_QNAME = new QName("", "obavestenje");
    private static final QName _ObavestenjeOrgan_QNAME = new QName("", "organ");
    private static final QName _ObavestenjeSadrzajObavestenja_QNAME =
            new QName("", "sadrzaj-obavestenja");
    private static final QName _ObavestenjePodnosilac_QNAME = new QName("", "podnosilac");
    private static final QName _ObavestenjeZakon_QNAME = new QName("", "zakon");
    private static final QName _ObavestenjeUredba_QNAME = new QName("", "uredba");
    private static final QName _ObavestenjePrimalac_QNAME = new QName("", "primalac");
    private static final QName _ObavestenjeDostavljeno_QNAME = new QName("", "dostavljeno");
    private static final QName _ObavestenjeOdluka_QNAME = new QName("", "odluka");
    private static final QName _ObavestenjeCena_QNAME = new QName("", "cena");
    private static final QName _ObavestenjeOpisZahteva_QNAME = new QName("", "opis-zahteva");
    private static final QName _ObavestenjeOpis_QNAME = new QName("", "opis");
    private static final QName _ObavestenjeCenovnik_QNAME = new QName("", "cenovnik");
    private static final QName _SadrzajVreme_QNAME = new QName("", "vreme");
    private static final QName _SadrzajKancelarija_QNAME = new QName("", "kancelarija");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes
     * for package: mypackage
     */
    public ObavestenjeFactory() {
    }

    /**
     * Create an instance of {@link Cenovnik }
     */
    public Cenovnik createCenovnik() {
        return new Cenovnik();
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
     * Create an instance of {@link ListObjave }
     */
    public ListObjave createListObjave() {
        return new ListObjave();
    }

    /**
     * Create an instance of {@link Obavestenje }
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link Kancelarija }
     */
    public Kancelarija createKancelarija() {
        return new Kancelarija();
    }

    /**
     * Create an instance of {@link VremePeriod }
     */
    public VremePeriod createVremePeriod() {
        return new VremePeriod();
    }

    /**
     * Create an instance of {@link Osoba }
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link Adresa }
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Sadrzaj }
     */
    public Sadrzaj createSadrzaj() {
        return new Sadrzaj();
    }

    /**
     * Create an instance of {@link Primalac }
     */
    public Primalac createPrimalac() {
        return new Primalac();
    }

    /**
     * Create an instance of {@link Vreme }
     */
    public Vreme createVreme() {
        return new Vreme();
    }

    /**
     * Create an instance of {@link Dostavljeno }
     */
    public Dostavljeno createDostavljeno() {
        return new Dostavljeno();
    }

    /**
     * Create an instance of {@link Organ }
     */
    public Organ createOrgan() {
        return new Organ();
    }

    /**
     * Create an instance of {@link Cenovnik.Stavka }
     */
    public Cenovnik.Stavka createCenovnikStavka() {
        return new Cenovnik.Stavka();
    }

    /**
     * Create an instance of {@link Akt.Clan.Stav.Tacka }
     */
    public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
        return new Akt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link ListObjave.Broj }
     */
    public ListObjave.Broj createListObjaveBroj() {
        return new ListObjave.Broj();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "datum")
    public JAXBElement<XMLGregorianCalendar> createDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(
                _Datum_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "obavestenje")
    public JAXBElement<Obavestenje> createObavestenje(Obavestenje value) {
        return new JAXBElement<Obavestenje>(_Obavestenje_QNAME, Obavestenje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "organ", scope = Obavestenje.class)
    public JAXBElement<Organ> createObavestenjeOrgan(Organ value) {
        return new JAXBElement<Organ>(_ObavestenjeOrgan_QNAME, Organ.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sadrzaj }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "sadrzaj-obavestenja", scope = Obavestenje.class)
    public JAXBElement<Sadrzaj> createObavestenjeSadrzajObavestenja(Sadrzaj value) {
        return new JAXBElement<Sadrzaj>(
                _ObavestenjeSadrzajObavestenja_QNAME, Sadrzaj.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "podnosilac", scope = Obavestenje.class)
    public JAXBElement<Lice> createObavestenjePodnosilac(Lice value) {
        return new JAXBElement<Lice>(
                _ObavestenjePodnosilac_QNAME, Lice.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Akt }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = Obavestenje.class)
    public JAXBElement<Akt> createObavestenjeZakon(Akt value) {
        return new JAXBElement<Akt>(_ObavestenjeZakon_QNAME, Akt.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Akt }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "uredba", scope = Obavestenje.class)
    public JAXBElement<Akt> createObavestenjeUredba(Akt value) {
        return new JAXBElement<Akt>(_ObavestenjeUredba_QNAME, Akt.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Primalac }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = Obavestenje.class)
    public JAXBElement<Primalac> createObavestenjePrimalac(Primalac value) {
        return new JAXBElement<Primalac>(
                _ObavestenjePrimalac_QNAME, Primalac.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dostavljeno }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "dostavljeno", scope = Obavestenje.class)
    public JAXBElement<Dostavljeno> createObavestenjeDostavljeno(Dostavljeno value) {
        return new JAXBElement<Dostavljeno>(
                _ObavestenjeDostavljeno_QNAME, Dostavljeno.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "odluka", scope = Obavestenje.class)
    public JAXBElement<String> createObavestenjeOdluka(String value) {
        return new JAXBElement<String>(
                _ObavestenjeOdluka_QNAME, String.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "cena", scope = Obavestenje.class)
    public JAXBElement<BigInteger> createObavestenjeCena(BigInteger value) {
        return new JAXBElement<BigInteger>(
                _ObavestenjeCena_QNAME, BigInteger.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "opis-zahteva", scope = Obavestenje.class)
    public JAXBElement<String> createObavestenjeOpisZahteva(String value) {
        return new JAXBElement<String>(
                _ObavestenjeOpisZahteva_QNAME, String.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "opis", scope = Obavestenje.class)
    public JAXBElement<String> createObavestenjeOpis(String value) {
        return new JAXBElement<String>(_ObavestenjeOpis_QNAME, String.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cenovnik }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "cenovnik", scope = Obavestenje.class)
    public JAXBElement<Cenovnik> createObavestenjeCenovnik(Cenovnik value) {
        return new JAXBElement<Cenovnik>(
                _ObavestenjeCenovnik_QNAME, Cenovnik.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Vreme }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "vreme", scope = Sadrzaj.class)
    public JAXBElement<Vreme> createSadrzajVreme(Vreme value) {
        return new JAXBElement<Vreme>(_SadrzajVreme_QNAME, Vreme.class, Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kancelarija }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "kancelarija", scope = Sadrzaj.class)
    public JAXBElement<Kancelarija> createSadrzajKancelarija(Kancelarija value) {
        return new JAXBElement<Kancelarija>(
                _SadrzajKancelarija_QNAME, Kancelarija.class, Sadrzaj.class, value);
    }
}
