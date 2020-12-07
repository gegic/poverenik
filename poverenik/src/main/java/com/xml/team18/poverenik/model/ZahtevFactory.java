
package com.xml.team18.poverenik.model;

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
public class ZahtevFactory extends PoverenikFactory {

    private final static QName _Zahtev_QNAME = new QName("", "zahtev");
    private final static QName _TZahtevOrgan_QNAME = new QName("", "organ");
    private final static QName _TZahtevNaslov_QNAME = new QName("", "naslov");
    private final static QName _TZahtevZakon_QNAME = new QName("", "zakon");
    private final static QName _TZahtevTipZahteva_QNAME = new QName("", "tip-zahteva");
    private final static QName _TZahtevTipInformacije_QNAME = new QName("", "tip-informacije");
    private final static QName _TZahtevMesto_QNAME = new QName("", "mesto");
    private final static QName _TZahtevTrazilacInformacije_QNAME = new QName("", "trazilac-informacije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ZahtevFactory() {
        super();
    }

    /**
     * Create an instance of {@link TListObjave }
     * 
     */
    public TListObjave createTListObjave() {
        return new TListObjave();
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
     * Create an instance of {@link TZahtev }
     * 
     */
    public TZahtev createTZahtev() {
        return new TZahtev();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TBiranjeZahteva }
     * 
     */
    public TBiranjeZahteva createTBiranjeZahteva() {
        return new TBiranjeZahteva();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TIzborZahteva }
     * 
     */
    public TIzborZahteva createTIzborZahteva() {
        return new TIzborZahteva();
    }

    /**
     * Create an instance of {@link TOrgan }
     * 
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link TListObjave.Broj }
     * 
     */
    public TListObjave.Broj createTListObjaveBroj() {
        return new TListObjave.Broj();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav.Tacka }
     * 
     */
    public TAkt.Clan.Stav.Tacka createTAktClanStavTacka() {
        return new TAkt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZahtev }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zahtev")
    public JAXBElement<TZahtev> createZahtev(TZahtev value) {
        return new JAXBElement<TZahtev>(_Zahtev_QNAME, TZahtev.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "organ", scope = TZahtev.class)
    public JAXBElement<TOrgan> createTZahtevOrgan(TOrgan value) {
        return new JAXBElement<TOrgan>(_TZahtevOrgan_QNAME, TOrgan.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "naslov", scope = TZahtev.class)
    public JAXBElement<String> createTZahtevNaslov(String value) {
        return new JAXBElement<String>(_TZahtevNaslov_QNAME, String.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAkt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = TZahtev.class)
    public JAXBElement<TAkt> createTZahtevZakon(TAkt value) {
        return new JAXBElement<TAkt>(_TZahtevZakon_QNAME, TAkt.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TBiranjeZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tip-zahteva", scope = TZahtev.class)
    public JAXBElement<TBiranjeZahteva> createTZahtevTipZahteva(TBiranjeZahteva value) {
        return new JAXBElement<TBiranjeZahteva>(_TZahtevTipZahteva_QNAME, TBiranjeZahteva.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tip-informacije", scope = TZahtev.class)
    public JAXBElement<String> createTZahtevTipInformacije(String value) {
        return new JAXBElement<String>(_TZahtevTipInformacije_QNAME, String.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mesto", scope = TZahtev.class)
    public JAXBElement<String> createTZahtevMesto(String value) {
        return new JAXBElement<String>(_TZahtevMesto_QNAME, String.class, TZahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOsoba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "trazilac-informacije", scope = TZahtev.class)
    public JAXBElement<TOsoba> createTZahtevTrazilacInformacije(TOsoba value) {
        return new JAXBElement<TOsoba>(_TZahtevTrazilacInformacije_QNAME, TOsoba.class, TZahtev.class, value);
    }

}
