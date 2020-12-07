
package com.xml.team18.poverenik.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
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
public class ZalbaCutanjeFactory extends PoverenikFactory {

    private final static QName _ZalbaCutanje_QNAME = new QName("", "zalba-cutanje");
    private final static QName _TZalbaRazlog_QNAME = new QName("", "razlog");
    private final static QName _TZalbaPodnosilac_QNAME = new QName("", "podnosilac");
    private final static QName _TZalbaSvrha_QNAME = new QName("", "svrha");
    private final static QName _TZalbaNapomena_QNAME = new QName("", "napomena");
    private final static QName _TZalbaPrimalac_QNAME = new QName("", "primalac");
    private final static QName _TZalbaZakon_QNAME = new QName("", "zakon");
    private final static QName _TZalbaDatumZahteva_QNAME = new QName("", "datum-zahteva");
    private final static QName _TZalbaMesto_QNAME = new QName("", "mesto");
    private final static QName _TZalbaPodaciOZahtevu_QNAME = new QName("", "podaci-o-zahtevu");
    private final static QName _TZalbaProtiv_QNAME = new QName("", "protiv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ZalbaCutanjeFactory() {
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
     * Create an instance of {@link TZalba }
     * 
     */
    public TZalba createTZalba() {
        return new TZalba();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TBiranjeRazloga }
     * 
     */
    public TBiranjeRazloga createTBiranjeRazloga() {
        return new TBiranjeRazloga();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TOrgan }
     * 
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link TIzborRazloga }
     * 
     */
    public TIzborRazloga createTIzborRazloga() {
        return new TIzborRazloga();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalba-cutanje")
    public JAXBElement<TZalba> createZalbaCutanje(TZalba value) {
        return new JAXBElement<TZalba>(_ZalbaCutanje_QNAME, TZalba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TBiranjeRazloga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "razlog", scope = TZalba.class)
    public JAXBElement<TBiranjeRazloga> createTZalbaRazlog(TBiranjeRazloga value) {
        return new JAXBElement<TBiranjeRazloga>(_TZalbaRazlog_QNAME, TBiranjeRazloga.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOsoba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnosilac", scope = TZalba.class)
    public JAXBElement<TOsoba> createTZalbaPodnosilac(TOsoba value) {
        return new JAXBElement<TOsoba>(_TZalbaPodnosilac_QNAME, TOsoba.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "svrha", scope = TZalba.class)
    public JAXBElement<String> createTZalbaSvrha(String value) {
        return new JAXBElement<String>(_TZalbaSvrha_QNAME, String.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "napomena", scope = TZalba.class)
    public JAXBElement<String> createTZalbaNapomena(String value) {
        return new JAXBElement<String>(_TZalbaNapomena_QNAME, String.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = TZalba.class)
    public JAXBElement<TOrgan> createTZalbaPrimalac(TOrgan value) {
        return new JAXBElement<TOrgan>(_TZalbaPrimalac_QNAME, TOrgan.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAkt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = TZalba.class)
    public JAXBElement<TAkt> createTZalbaZakon(TAkt value) {
        return new JAXBElement<TAkt>(_TZalbaZakon_QNAME, TAkt.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum-zahteva", scope = TZalba.class)
    public JAXBElement<XMLGregorianCalendar> createTZalbaDatumZahteva(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TZalbaDatumZahteva_QNAME, XMLGregorianCalendar.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mesto", scope = TZalba.class)
    public JAXBElement<String> createTZalbaMesto(String value) {
        return new JAXBElement<String>(_TZalbaMesto_QNAME, String.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podaci-o-zahtevu", scope = TZalba.class)
    public JAXBElement<String> createTZalbaPodaciOZahtevu(String value) {
        return new JAXBElement<String>(_TZalbaPodaciOZahtevu_QNAME, String.class, TZalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "protiv", scope = TZalba.class)
    public JAXBElement<TOrgan> createTZalbaProtiv(TOrgan value) {
        return new JAXBElement<TOrgan>(_TZalbaProtiv_QNAME, TOrgan.class, TZalba.class, value);
    }

}
