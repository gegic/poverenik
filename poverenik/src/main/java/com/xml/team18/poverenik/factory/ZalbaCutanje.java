
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.zalbacutanje.*;
import com.xml.team18.poverenik.model.poverenik.*;

import org.springframework.stereotype.Component;

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
@Component
@XmlRegistry
public class ZalbaCutanje extends PoverenikFactory {

    private final static QName _ZalbaCutanje_QNAME = new QName("", "zalba-cutanje");
    private final static QName _ZalbaRazlog_QNAME = new QName("", "razlog");
    private final static QName _ZalbaPodnosilac_QNAME = new QName("", "podnosilac");
    private final static QName _ZalbaSvrha_QNAME = new QName("", "svrha");
    private final static QName _ZalbaNapomena_QNAME = new QName("", "napomena");
    private final static QName _ZalbaPrimalac_QNAME = new QName("", "primalac");
    private final static QName _ZalbaZakon_QNAME = new QName("", "zakon");
    private final static QName _ZalbaDatumZahteva_QNAME = new QName("", "datum-zahteva");
    private final static QName _ZalbaMesto_QNAME = new QName("", "mesto");
    private final static QName _ZalbaPodaciOZahtevu_QNAME = new QName("", "podaci-o-zahtevu");
    private final static QName _ZalbaProtiv_QNAME = new QName("", "protiv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ZalbaCutanje() {
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
     * Create an instance of {@link Zalba }
     * 
     */
    public Zalba createZalba() {
        return new Zalba();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Zalba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalba-cutanje")
    public JAXBElement<Zalba> createZalbaCutanje(Zalba value) {
        return new JAXBElement<Zalba>(_ZalbaCutanje_QNAME, Zalba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiranjeRazloga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "razlog", scope = Zalba.class)
    public JAXBElement<BiranjeRazloga> createZalbaRazlog(BiranjeRazloga value) {
        return new JAXBElement<BiranjeRazloga>(_ZalbaRazlog_QNAME, BiranjeRazloga.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Osoba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnosilac", scope = Zalba.class)
    public JAXBElement<Osoba> createZalbaPodnosilac(Osoba value) {
        return new JAXBElement<Osoba>(_ZalbaPodnosilac_QNAME, Osoba.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "svrha", scope = Zalba.class)
    public JAXBElement<String> createZalbaSvrha(String value) {
        return new JAXBElement<String>(_ZalbaSvrha_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "napomena", scope = Zalba.class)
    public JAXBElement<String> createZalbaNapomena(String value) {
        return new JAXBElement<String>(_ZalbaNapomena_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = Zalba.class)
    public JAXBElement<Organ> createZalbaPrimalac(Organ value) {
        return new JAXBElement<Organ>(_ZalbaPrimalac_QNAME, Organ.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Akt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = Zalba.class)
    public JAXBElement<Akt> createZalbaZakon(Akt value) {
        return new JAXBElement<Akt>(_ZalbaZakon_QNAME, Akt.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum-zahteva", scope = Zalba.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaDatumZahteva(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ZalbaDatumZahteva_QNAME, XMLGregorianCalendar.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mesto", scope = Zalba.class)
    public JAXBElement<String> createZalbaMesto(String value) {
        return new JAXBElement<String>(_ZalbaMesto_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podaci-o-zahtevu", scope = Zalba.class)
    public JAXBElement<String> createZalbaPodaciOZahtevu(String value) {
        return new JAXBElement<String>(_ZalbaPodaciOZahtevu_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "protiv", scope = Zalba.class)
    public JAXBElement<Organ> createZalbaProtiv(Organ value) {
        return new JAXBElement<Organ>(_ZalbaProtiv_QNAME, Organ.class, Zalba.class, value);
    }

}
