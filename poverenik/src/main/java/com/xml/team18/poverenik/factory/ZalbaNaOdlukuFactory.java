package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.poverenik.*;
import com.xml.team18.poverenik.model.zalbanaodluku.Odluka;
import com.xml.team18.poverenik.model.zalbanaodluku.Zalba;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

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
public class ZalbaNaOdlukuFactory extends PoverenikFactory {

    private static final QName _Zalba_QNAME = new QName("", "zalba");
    private static final QName _ZalbaDatum_QNAME = new QName("", "datum");
    private static final QName _ZalbaPodnosilac_QNAME = new QName("", "podnosilac");
    private static final QName _ZalbaSvrha_QNAME = new QName("", "svrha");
    private static final QName _ZalbaDeoPobijanja_QNAME = new QName("", "deo-pobijanja");
    private static final QName _ZalbaPrimalac_QNAME = new QName("", "primalac");
    private static final QName _ZalbaZakon_QNAME = new QName("", "zakon");
    private static final QName _ZalbaMesto_QNAME = new QName("", "mesto");
    private static final QName _ZalbaZalilac_QNAME = new QName("", "zalilac");
    private static final QName _ZalbaProtiv_QNAME = new QName("", "protiv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes
     * for package: mypackage
     */
    public ZalbaNaOdlukuFactory() {
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
     * Create an instance of {@link Zalba }
     */
    public Zalba createZalba() {
        return new Zalba();
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
     * Create an instance of {@link Odluka }
     */
    public Odluka createOdluka() {
        return new Odluka();
    }

    /**
     * Create an instance of {@link Organ }
     */
    public Organ createOrgan() {
        return new Organ();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Zalba }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "zalba")
    public JAXBElement<Zalba> createZalba(Zalba value) {
        return new JAXBElement<Zalba>(_Zalba_QNAME, Zalba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "datum", scope = Zalba.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(
                _ZalbaDatum_QNAME, XMLGregorianCalendar.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Osoba }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "podnosilac", scope = Zalba.class)
    public JAXBElement<Osoba> createZalbaPodnosilac(Osoba value) {
        return new JAXBElement<Osoba>(_ZalbaPodnosilac_QNAME, Osoba.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "svrha", scope = Zalba.class)
    public JAXBElement<String> createZalbaSvrha(String value) {
        return new JAXBElement<String>(_ZalbaSvrha_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(
            namespace = "",
            name = "deo-pobijanja",
            scope = Zalba.class,
            defaultValue = "\u0443 \u0446\u0435\u043b\u043e\u0441\u0442\u0438")
    public JAXBElement<String> createZalbaDeoPobijanja(String value) {
        return new JAXBElement<String>(_ZalbaDeoPobijanja_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = Zalba.class)
    public JAXBElement<Organ> createZalbaPrimalac(Organ value) {
        return new JAXBElement<Organ>(_ZalbaPrimalac_QNAME, Organ.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Akt }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "zakon", scope = Zalba.class)
    public JAXBElement<Akt> createZalbaZakon(Akt value) {
        return new JAXBElement<Akt>(_ZalbaZakon_QNAME, Akt.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "mesto", scope = Zalba.class)
    public JAXBElement<String> createZalbaMesto(String value) {
        return new JAXBElement<String>(_ZalbaMesto_QNAME, String.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = Zalba.class)
    public JAXBElement<Lice> createZalbaZalilac(Lice value) {
        return new JAXBElement<Lice>(_ZalbaZalilac_QNAME, Lice.class, Zalba.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Odluka }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "protiv", scope = Zalba.class)
    public JAXBElement<Odluka> createZalbaProtiv(Odluka value) {
        return new JAXBElement<Odluka>(_ZalbaProtiv_QNAME, Odluka.class, Zalba.class, value);
    }
}
