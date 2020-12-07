
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigInteger;


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
public class ObavestenjeFactory extends PoverenikFactory {

    private final static QName _Datum_QNAME = new QName("", "datum");
    private final static QName _Obavestenje_QNAME = new QName("", "obavestenje");
    private final static QName _TSadrzajVreme_QNAME = new QName("", "vreme");
    private final static QName _TSadrzajKancelarija_QNAME = new QName("", "kancelarija");
    private final static QName _TObavestenjeOrgan_QNAME = new QName("", "organ");
    private final static QName _TObavestenjeSadrzajObavestenja_QNAME = new QName("", "sadrzaj-obavestenja");
    private final static QName _TObavestenjePodnosilac_QNAME = new QName("", "podnosilac");
    private final static QName _TObavestenjeZakon_QNAME = new QName("", "zakon");
    private final static QName _TObavestenjeUredba_QNAME = new QName("", "uredba");
    private final static QName _TObavestenjePrimalac_QNAME = new QName("", "primalac");
    private final static QName _TObavestenjeDostavljeno_QNAME = new QName("", "dostavljeno");
    private final static QName _TObavestenjeOdluka_QNAME = new QName("", "odluka");
    private final static QName _TObavestenjeCena_QNAME = new QName("", "cena");
    private final static QName _TObavestenjeOpisZahteva_QNAME = new QName("", "opis-zahteva");
    private final static QName _TObavestenjeOpis_QNAME = new QName("", "opis");
    private final static QName _TObavestenjeCenovnik_QNAME = new QName("", "cenovnik");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ObavestenjeFactory() {
    }

    /**
     * Create an instance of {@link TAkt }
     * 
     */
    public TAkt createTAkt() {
        return new TAkt();
    }

    /**
     * Create an instance of {@link TAkt.Clan }
     * 
     */
    public TAkt.Clan createTAktClan() {
        return new TAkt.Clan();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav }
     * 
     */
    public TAkt.Clan.Stav createTAktClanStav() {
        return new TAkt.Clan.Stav();
    }

    /**
     * Create an instance of {@link TCenovnik }
     * 
     */
    public TCenovnik createTCenovnik() {
        return new TCenovnik();
    }

    /**
     * Create an instance of {@link TListObjave }
     * 
     */
    public TListObjave createTListObjave() {
        return new TListObjave();
    }

    /**
     * Create an instance of {@link TObavestenje }
     * 
     */
    public TObavestenje createTObavestenje() {
        return new TObavestenje();
    }

    /**
     * Create an instance of {@link TVreme }
     * 
     */
    public TVreme createTVreme() {
        return new TVreme();
    }

    /**
     * Create an instance of {@link TKancelarija }
     * 
     */
    public TKancelarija createTKancelarija() {
        return new TKancelarija();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TDostavljeno }
     * 
     */
    public TDostavljeno createTDostavljeno() {
        return new TDostavljeno();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TPrimalac }
     * 
     */
    public TPrimalac createTPrimalac() {
        return new TPrimalac();
    }

    /**
     * Create an instance of {@link TSadrzaj }
     * 
     */
    public TSadrzaj createTSadrzaj() {
        return new TSadrzaj();
    }

    /**
     * Create an instance of {@link TOrgan }
     * 
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link TVremePeriod }
     * 
     */
    public TVremePeriod createTVremePeriod() {
        return new TVremePeriod();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav.Tacka }
     * 
     */
    public TAkt.Clan.Stav.Tacka createTAktClanStavTacka() {
        return new TAkt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link TCenovnik.Stavka }
     * 
     */
    public TCenovnik.Stavka createTCenovnikStavka() {
        return new TCenovnik.Stavka();
    }

    /**
     * Create an instance of {@link TListObjave.Broj }
     * 
     */
    public TListObjave.Broj createTListObjaveBroj() {
        return new TListObjave.Broj();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum")
    public JAXBElement<XMLGregorianCalendar> createDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Datum_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TObavestenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "obavestenje")
    public JAXBElement<TObavestenje> createObavestenje(TObavestenje value) {
        return new JAXBElement<TObavestenje>(_Obavestenje_QNAME, TObavestenje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TVreme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "vreme", scope = TSadrzaj.class)
    public JAXBElement<TVreme> createTSadrzajVreme(TVreme value) {
        return new JAXBElement<TVreme>(_TSadrzajVreme_QNAME, TVreme.class, TSadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TKancelarija }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "kancelarija", scope = TSadrzaj.class)
    public JAXBElement<TKancelarija> createTSadrzajKancelarija(TKancelarija value) {
        return new JAXBElement<TKancelarija>(_TSadrzajKancelarija_QNAME, TKancelarija.class, TSadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "organ", scope = TObavestenje.class)
    public JAXBElement<TOrgan> createTObavestenjeOrgan(TOrgan value) {
        return new JAXBElement<TOrgan>(_TObavestenjeOrgan_QNAME, TOrgan.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TSadrzaj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sadrzaj-obavestenja", scope = TObavestenje.class)
    public JAXBElement<TSadrzaj> createTObavestenjeSadrzajObavestenja(TSadrzaj value) {
        return new JAXBElement<TSadrzaj>(_TObavestenjeSadrzajObavestenja_QNAME, TSadrzaj.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnosilac", scope = TObavestenje.class)
    public JAXBElement<TLice> createTObavestenjePodnosilac(TLice value) {
        return new JAXBElement<TLice>(_TObavestenjePodnosilac_QNAME, TLice.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAkt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = TObavestenje.class)
    public JAXBElement<TAkt> createTObavestenjeZakon(TAkt value) {
        return new JAXBElement<TAkt>(_TObavestenjeZakon_QNAME, TAkt.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAkt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uredba", scope = TObavestenje.class)
    public JAXBElement<TAkt> createTObavestenjeUredba(TAkt value) {
        return new JAXBElement<TAkt>(_TObavestenjeUredba_QNAME, TAkt.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPrimalac }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = TObavestenje.class)
    public JAXBElement<TPrimalac> createTObavestenjePrimalac(TPrimalac value) {
        return new JAXBElement<TPrimalac>(_TObavestenjePrimalac_QNAME, TPrimalac.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDostavljeno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dostavljeno", scope = TObavestenje.class)
    public JAXBElement<TDostavljeno> createTObavestenjeDostavljeno(TDostavljeno value) {
        return new JAXBElement<TDostavljeno>(_TObavestenjeDostavljeno_QNAME, TDostavljeno.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "odluka", scope = TObavestenje.class)
    public JAXBElement<String> createTObavestenjeOdluka(String value) {
        return new JAXBElement<String>(_TObavestenjeOdluka_QNAME, String.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cena", scope = TObavestenje.class)
    public JAXBElement<BigInteger> createTObavestenjeCena(BigInteger value) {
        return new JAXBElement<BigInteger>(_TObavestenjeCena_QNAME, BigInteger.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "opis-zahteva", scope = TObavestenje.class)
    public JAXBElement<String> createTObavestenjeOpisZahteva(String value) {
        return new JAXBElement<String>(_TObavestenjeOpisZahteva_QNAME, String.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "opis", scope = TObavestenje.class)
    public JAXBElement<String> createTObavestenjeOpis(String value) {
        return new JAXBElement<String>(_TObavestenjeOpis_QNAME, String.class, TObavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCenovnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cenovnik", scope = TObavestenje.class)
    public JAXBElement<TCenovnik> createTObavestenjeCenovnik(TCenovnik value) {
        return new JAXBElement<TCenovnik>(_TObavestenjeCenovnik_QNAME, TCenovnik.class, TObavestenje.class, value);
    }

}
