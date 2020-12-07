
package com.xml.team18.poverenik.model;

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
public class ResenjeFactory extends PoverenikFactory {

    private final static QName _Resenje_QNAME = new QName("", "resenje");
    private final static QName _TIzjavaZalbeUzrok_QNAME = new QName("", "uzrok");
    private final static QName _TIzjavaZalbeZalilac_QNAME = new QName("", "zalilac");
    private final static QName _TNalogObavestiti_QNAME = new QName("", "obavestiti");
    private final static QName _TNalogPrimalac_QNAME = new QName("", "primalac");
    private final static QName _TNalogAkcija_QNAME = new QName("", "akcija");
    private final static QName _TUputPoverenikaOsnov_QNAME = new QName("", "osnov");
    private final static QName _TNacinDostaveElektronskaPosta_QNAME = new QName("", "elektronska-posta");
    private final static QName _TNacinDostaveFaks_QNAME = new QName("", "faks");
    private final static QName _TNacinDostavePosta_QNAME = new QName("", "posta");
    private final static QName _TTeloOdbijanje_QNAME = new QName("", "odbijanje");
    private final static QName _TTeloNalog_QNAME = new QName("", "nalog");
    private final static QName _TPravnoSredstvoSud_QNAME = new QName("", "sud");
    private final static QName _TAkcijaNacinDostave_QNAME = new QName("", "nacin-dostave");
    private final static QName _TAkcijaCenzura_QNAME = new QName("", "cenzura");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ResenjeFactory() {
    }

    /**
     * Create an instance of {@link TNacinDostave }
     * 
     */
    public TNacinDostave createTNacinDostave() {
        return new TNacinDostave();
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
     * Create an instance of {@link TListObjave }
     * 
     */
    public TListObjave createTListObjave() {
        return new TListObjave();
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link TResenje }
     * 
     */
    public TResenje createTResenje() {
        return new TResenje();
    }

    /**
     * Create an instance of {@link TPravnoSredstvo }
     * 
     */
    public TPravnoSredstvo createTPravnoSredstvo() {
        return new TPravnoSredstvo();
    }

    /**
     * Create an instance of {@link TIzjavaZalbe }
     * 
     */
    public TIzjavaZalbe createTIzjavaZalbe() {
        return new TIzjavaZalbe();
    }

    /**
     * Create an instance of {@link TNepostupanje }
     * 
     */
    public TNepostupanje createTNepostupanje() {
        return new TNepostupanje();
    }

    /**
     * Create an instance of {@link TUputPoverenika }
     * 
     */
    public TUputPoverenika createTUputPoverenika() {
        return new TUputPoverenika();
    }

    /**
     * Create an instance of {@link TOsnov }
     * 
     */
    public TOsnov createTOsnov() {
        return new TOsnov();
    }

    /**
     * Create an instance of {@link TPredgovor }
     * 
     */
    public TPredgovor createTPredgovor() {
        return new TPredgovor();
    }

    /**
     * Create an instance of {@link TObavestiti }
     * 
     */
    public TObavestiti createTObavestiti() {
        return new TObavestiti();
    }

    /**
     * Create an instance of {@link TUzrok }
     * 
     */
    public TUzrok createTUzrok() {
        return new TUzrok();
    }

    /**
     * Create an instance of {@link TTelo }
     * 
     */
    public TTelo createTTelo() {
        return new TTelo();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TNalog }
     * 
     */
    public TNalog createTNalog() {
        return new TNalog();
    }

    /**
     * Create an instance of {@link TAkcija }
     * 
     */
    public TAkcija createTAkcija() {
        return new TAkcija();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TObavestenje }
     * 
     */
    public TObavestenje createTObavestenje() {
        return new TObavestenje();
    }

    /**
     * Create an instance of {@link TObrazlozenje }
     * 
     */
    public TObrazlozenje createTObrazlozenje() {
        return new TObrazlozenje();
    }

    /**
     * Create an instance of {@link TOrgan }
     * 
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link TDonosenjeOdluke }
     * 
     */
    public TDonosenjeOdluke createTDonosenjeOdluke() {
        return new TDonosenjeOdluke();
    }

    /**
     * Create an instance of {@link TTok }
     * 
     */
    public TTok createTTok() {
        return new TTok();
    }

    /**
     * Create an instance of {@link TOdbijanje }
     * 
     */
    public TOdbijanje createTOdbijanje() {
        return new TOdbijanje();
    }

    /**
     * Create an instance of {@link TNacinDostave.Posta }
     * 
     */
    public TNacinDostave.Posta createTNacinDostavePosta() {
        return new TNacinDostave.Posta();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav.Tacka }
     * 
     */
    public TAkt.Clan.Stav.Tacka createTAktClanStavTacka() {
        return new TAkt.Clan.Stav.Tacka();
    }

    /**
     * Create an instance of {@link TListObjave.Broj }
     * 
     */
    public TListObjave.Broj createTListObjaveBroj() {
        return new TListObjave.Broj();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resenje")
    public JAXBElement<TResenje> createResenje(TResenje value) {
        return new JAXBElement<TResenje>(_Resenje_QNAME, TResenje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUzrok }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uzrok", scope = TIzjavaZalbe.class)
    public JAXBElement<TUzrok> createTIzjavaZalbeUzrok(TUzrok value) {
        return new JAXBElement<TUzrok>(_TIzjavaZalbeUzrok_QNAME, TUzrok.class, TIzjavaZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = TIzjavaZalbe.class)
    public JAXBElement<TLice> createTIzjavaZalbeZalilac(TLice value) {
        return new JAXBElement<TLice>(_TIzjavaZalbeZalilac_QNAME, TLice.class, TIzjavaZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TObavestiti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "obavestiti", scope = TNalog.class)
    public JAXBElement<TObavestiti> createTNalogObavestiti(TObavestiti value) {
        return new JAXBElement<TObavestiti>(_TNalogObavestiti_QNAME, TObavestiti.class, TNalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = TNalog.class)
    public JAXBElement<TOrgan> createTNalogPrimalac(TOrgan value) {
        return new JAXBElement<TOrgan>(_TNalogPrimalac_QNAME, TOrgan.class, TNalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAkcija }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "akcija", scope = TNalog.class)
    public JAXBElement<TAkcija> createTNalogAkcija(TAkcija value) {
        return new JAXBElement<TAkcija>(_TNalogAkcija_QNAME, TAkcija.class, TNalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOsnov }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "osnov", scope = TUputPoverenika.class)
    public JAXBElement<TOsnov> createTUputPoverenikaOsnov(TOsnov value) {
        return new JAXBElement<TOsnov>(_TUputPoverenikaOsnov_QNAME, TOsnov.class, TUputPoverenika.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUzrok }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uzrok", scope = TOdbijanje.class)
    public JAXBElement<TUzrok> createTOdbijanjeUzrok(TUzrok value) {
        return new JAXBElement<TUzrok>(_TIzjavaZalbeUzrok_QNAME, TUzrok.class, TOdbijanje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = TOdbijanje.class)
    public JAXBElement<TLice> createTOdbijanjeZalilac(TLice value) {
        return new JAXBElement<TLice>(_TIzjavaZalbeZalilac_QNAME, TLice.class, TOdbijanje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUzrok }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uzrok", scope = TPredgovor.class)
    public JAXBElement<TUzrok> createTPredgovorUzrok(TUzrok value) {
        return new JAXBElement<TUzrok>(_TIzjavaZalbeUzrok_QNAME, TUzrok.class, TPredgovor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOsnov }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "osnov", scope = TPredgovor.class)
    public JAXBElement<TOsnov> createTPredgovorOsnov(TOsnov value) {
        return new JAXBElement<TOsnov>(_TUputPoverenikaOsnov_QNAME, TOsnov.class, TPredgovor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = TPredgovor.class)
    public JAXBElement<TLice> createTPredgovorZalilac(TLice value) {
        return new JAXBElement<TLice>(_TIzjavaZalbeZalilac_QNAME, TLice.class, TPredgovor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "elektronska-posta", scope = TNacinDostave.class)
    public JAXBElement<String> createTNacinDostaveElektronskaPosta(String value) {
        return new JAXBElement<String>(_TNacinDostaveElektronskaPosta_QNAME, String.class, TNacinDostave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "faks", scope = TNacinDostave.class)
    public JAXBElement<String> createTNacinDostaveFaks(String value) {
        return new JAXBElement<String>(_TNacinDostaveFaks_QNAME, String.class, TNacinDostave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNacinDostave.Posta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "posta", scope = TNacinDostave.class)
    public JAXBElement<TNacinDostave.Posta> createTNacinDostavePosta(TNacinDostave.Posta value) {
        return new JAXBElement<TNacinDostave.Posta>(_TNacinDostavePosta_QNAME, TNacinDostave.Posta.class, TNacinDostave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOdbijanje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "odbijanje", scope = TTelo.class)
    public JAXBElement<TOdbijanje> createTTeloOdbijanje(TOdbijanje value) {
        return new JAXBElement<TOdbijanje>(_TTeloOdbijanje_QNAME, TOdbijanje.class, TTelo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nalog", scope = TTelo.class)
    public JAXBElement<TNalog> createTTeloNalog(TNalog value) {
        return new JAXBElement<TNalog>(_TTeloNalog_QNAME, TNalog.class, TTelo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sud", scope = TPravnoSredstvo.class)
    public JAXBElement<TOrgan> createTPravnoSredstvoSud(TOrgan value) {
        return new JAXBElement<TOrgan>(_TPravnoSredstvoSud_QNAME, TOrgan.class, TPravnoSredstvo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrgan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "primalac", scope = TObavestiti.class)
    public JAXBElement<TOrgan> createTObavestitiPrimalac(TOrgan value) {
        return new JAXBElement<TOrgan>(_TNalogPrimalac_QNAME, TOrgan.class, TObavestiti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNacinDostave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nacin-dostave", scope = TAkcija.class)
    public JAXBElement<TNacinDostave> createTAkcijaNacinDostave(TNacinDostave value) {
        return new JAXBElement<TNacinDostave>(_TAkcijaNacinDostave_QNAME, TNacinDostave.class, TAkcija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zalilac", scope = TAkcija.class)
    public JAXBElement<Object> createTAkcijaZalilac(Object value) {
        return new JAXBElement<Object>(_TIzjavaZalbeZalilac_QNAME, Object.class, TAkcija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cenzura", scope = TAkcija.class)
    public JAXBElement<List<String>> createTAkcijaCenzura(List<String> value) {
        return new JAXBElement<List<String>>(_TAkcijaCenzura_QNAME, ((Class) List.class), TAkcija.class, ((List<String> ) value));
    }

}
