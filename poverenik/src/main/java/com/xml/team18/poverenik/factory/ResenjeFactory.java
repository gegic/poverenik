package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.poverenik.*;
import com.xml.team18.poverenik.model.resenje.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.List;

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
public class ResenjeFactory extends PoverenikFactory {

  private static final QName _Resenje_QNAME = new QName("", "resenje");
  private static final QName _ObavestitiPrimalac_QNAME = new QName("", "primalac");
  private static final QName _NalogObavestiti_QNAME = new QName("", "obavestiti");
  private static final QName _NalogAkcija_QNAME = new QName("", "akcija");
  private static final QName _OdbijanjeUzrok_QNAME = new QName("", "uzrok");
  private static final QName _OdbijanjeZalilac_QNAME = new QName("", "zalilac");
  private static final QName _PravnoSredstvoSud_QNAME = new QName("", "sud");
  private static final QName _UputPoverenikaOsnov_QNAME = new QName("", "osnov");
  private static final QName _TeloOdbijanje_QNAME = new QName("", "odbijanje");
  private static final QName _TeloNalog_QNAME = new QName("", "nalog");
  private static final QName _AkcijaNacinDostave_QNAME = new QName("", "nacin-dostave");
  private static final QName _AkcijaCenzura_QNAME = new QName("", "cenzura");
  private static final QName _NacinDostaveElektronskaPosta_QNAME =
      new QName("", "elektronska-posta");
  private static final QName _NacinDostaveFaks_QNAME = new QName("", "faks");
  private static final QName _NacinDostavePosta_QNAME = new QName("", "posta");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: mypackage
   */
  public ResenjeFactory() {}

  /** Create an instance of {@link Akt } */
  public Akt createAkt() {
    return new Akt();
  }

  /** Create an instance of {@link Akt.Clan } */
  public Akt.Clan createAktClan() {
    return new Akt.Clan();
  }

  /** Create an instance of {@link Akt.Clan.Stav } */
  public Akt.Clan.Stav createAktClanStav() {
    return new Akt.Clan.Stav();
  }

  /** Create an instance of {@link ListObjave } */
  public ListObjave createListObjave() {
    return new ListObjave();
  }

  /** Create an instance of {@link NacinDostave } */
  public NacinDostave createNacinDostave() {
    return new NacinDostave();
  }

  /** Create an instance of {@link Resenje } */
  public Resenje createResenje() {
    return new Resenje();
  }

  /** Create an instance of {@link PodnetiZahtev } */
  public PodnetiZahtev createPodnetiZahtev() {
    return new PodnetiZahtev();
  }

  /** Create an instance of {@link Uzrok } */
  public Uzrok createUzrok() {
    return new Uzrok();
  }

  /** Create an instance of {@link Predgovor } */
  public Predgovor createPredgovor() {
    return new Predgovor();
  }

  /** Create an instance of {@link IzjavaZalbe } */
  public IzjavaZalbe createIzjavaZalbe() {
    return new IzjavaZalbe();
  }

  /** Create an instance of {@link Akcija } */
  public Akcija createAkcija() {
    return new Akcija();
  }

  /** Create an instance of {@link NegativnoObavestenje } */
  public NegativnoObavestenje createNegativnoObavestenje() {
    return new NegativnoObavestenje();
  }

  /** Create an instance of {@link Nepostupanje } */
  public Nepostupanje createNepostupanje() {
    return new Nepostupanje();
  }

  /** Create an instance of {@link Osnov } */
  public Osnov createOsnov() {
    return new Osnov();
  }

  /** Create an instance of {@link Obrazlozenje } */
  public Obrazlozenje createObrazlozenje() {
    return new Obrazlozenje();
  }

  /** Create an instance of {@link Osoba } */
  public Osoba createOsoba() {
    return new Osoba();
  }

  /** Create an instance of {@link Adresa } */
  public Adresa createAdresa() {
    return new Adresa();
  }

  /** Create an instance of {@link PravnoSredstvo } */
  public PravnoSredstvo createPravnoSredstvo() {
    return new PravnoSredstvo();
  }

  /** Create an instance of {@link Nalog } */
  public Nalog createNalog() {
    return new Nalog();
  }

  /** Create an instance of {@link Odbijanje } */
  public Odbijanje createOdbijanje() {
    return new Odbijanje();
  }

  /** Create an instance of {@link Tok } */
  public Tok createTok() {
    return new Tok();
  }

  /** Create an instance of {@link Obavestiti } */
  public Obavestiti createObavestiti() {
    return new Obavestiti();
  }

  /** Create an instance of {@link Telo } */
  public Telo createTelo() {
    return new Telo();
  }

  /** Create an instance of {@link DonosenjeOdluke } */
  public DonosenjeOdluke createDonosenjeOdluke() {
    return new DonosenjeOdluke();
  }

  /** Create an instance of {@link Organ } */
  public Organ createOrgan() {
    return new Organ();
  }

  /** Create an instance of {@link UputPoverenika } */
  public UputPoverenika createUputPoverenika() {
    return new UputPoverenika();
  }

  /** Create an instance of {@link Akt.Clan.Stav.Tacka } */
  public Akt.Clan.Stav.Tacka createAktClanStavTacka() {
    return new Akt.Clan.Stav.Tacka();
  }

  /** Create an instance of {@link ListObjave.Broj } */
  public ListObjave.Broj createListObjaveBroj() {
    return new ListObjave.Broj();
  }

  /** Create an instance of {@link NacinDostave.Posta } */
  public NacinDostave.Posta createNacinDostavePosta() {
    return new NacinDostave.Posta();
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Resenje }{@code >}} */
  @XmlElementDecl(namespace = "", name = "resenje")
  public JAXBElement<Resenje> createResenje(Resenje value) {
    return new JAXBElement<Resenje>(_Resenje_QNAME, Resenje.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}} */
  @XmlElementDecl(namespace = "", name = "primalac", scope = Obavestiti.class)
  public JAXBElement<Organ> createObavestitiPrimalac(Organ value) {
    return new JAXBElement<Organ>(_ObavestitiPrimalac_QNAME, Organ.class, Obavestiti.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Obavestiti }{@code >}} */
  @XmlElementDecl(namespace = "", name = "obavestiti", scope = Nalog.class)
  public JAXBElement<Obavestiti> createNalogObavestiti(Obavestiti value) {
    return new JAXBElement<Obavestiti>(
        _NalogObavestiti_QNAME, Obavestiti.class, Nalog.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}} */
  @XmlElementDecl(namespace = "", name = "primalac", scope = Nalog.class)
  public JAXBElement<Organ> createNalogPrimalac(Organ value) {
    return new JAXBElement<Organ>(_ObavestitiPrimalac_QNAME, Organ.class, Nalog.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Akcija }{@code >}} */
  @XmlElementDecl(namespace = "", name = "akcija", scope = Nalog.class)
  public JAXBElement<Akcija> createNalogAkcija(Akcija value) {
    return new JAXBElement<Akcija>(_NalogAkcija_QNAME, Akcija.class, Nalog.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Uzrok }{@code >}} */
  @XmlElementDecl(namespace = "", name = "uzrok", scope = Odbijanje.class)
  public JAXBElement<Uzrok> createOdbijanjeUzrok(Uzrok value) {
    return new JAXBElement<Uzrok>(_OdbijanjeUzrok_QNAME, Uzrok.class, Odbijanje.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}} */
  @XmlElementDecl(namespace = "", name = "zalilac", scope = Odbijanje.class)
  public JAXBElement<Lice> createOdbijanjeZalilac(Lice value) {
    return new JAXBElement<Lice>(_OdbijanjeZalilac_QNAME, Lice.class, Odbijanje.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Organ }{@code >}} */
  @XmlElementDecl(namespace = "", name = "sud", scope = PravnoSredstvo.class)
  public JAXBElement<Organ> createPravnoSredstvoSud(Organ value) {
    return new JAXBElement<Organ>(
        _PravnoSredstvoSud_QNAME, Organ.class, PravnoSredstvo.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Uzrok }{@code >}} */
  @XmlElementDecl(namespace = "", name = "uzrok", scope = IzjavaZalbe.class)
  public JAXBElement<Uzrok> createIzjavaZalbeUzrok(Uzrok value) {
    return new JAXBElement<Uzrok>(_OdbijanjeUzrok_QNAME, Uzrok.class, IzjavaZalbe.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}} */
  @XmlElementDecl(namespace = "", name = "zalilac", scope = IzjavaZalbe.class)
  public JAXBElement<Lice> createIzjavaZalbeZalilac(Lice value) {
    return new JAXBElement<Lice>(_OdbijanjeZalilac_QNAME, Lice.class, IzjavaZalbe.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Osnov }{@code >}} */
  @XmlElementDecl(namespace = "", name = "osnov", scope = UputPoverenika.class)
  public JAXBElement<Osnov> createUputPoverenikaOsnov(Osnov value) {
    return new JAXBElement<Osnov>(
        _UputPoverenikaOsnov_QNAME, Osnov.class, UputPoverenika.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Odbijanje }{@code >}} */
  @XmlElementDecl(namespace = "", name = "odbijanje", scope = Telo.class)
  public JAXBElement<Odbijanje> createTeloOdbijanje(Odbijanje value) {
    return new JAXBElement<Odbijanje>(_TeloOdbijanje_QNAME, Odbijanje.class, Telo.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Nalog }{@code >}} */
  @XmlElementDecl(namespace = "", name = "nalog", scope = Telo.class)
  public JAXBElement<Nalog> createTeloNalog(Nalog value) {
    return new JAXBElement<Nalog>(_TeloNalog_QNAME, Nalog.class, Telo.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link NacinDostave }{@code >}} */
  @XmlElementDecl(namespace = "", name = "nacin-dostave", scope = Akcija.class)
  public JAXBElement<NacinDostave> createAkcijaNacinDostave(NacinDostave value) {
    return new JAXBElement<NacinDostave>(
        _AkcijaNacinDostave_QNAME, NacinDostave.class, Akcija.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}} */
  @XmlElementDecl(namespace = "", name = "zalilac", scope = Akcija.class)
  public JAXBElement<Object> createAkcijaZalilac(Object value) {
    return new JAXBElement<Object>(_OdbijanjeZalilac_QNAME, Object.class, Akcija.class, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code
   * >}{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "cenzura", scope = Akcija.class)
  public JAXBElement<List<String>> createAkcijaCenzura(List<String> value) {
    return new JAXBElement<List<String>>(
        _AkcijaCenzura_QNAME, ((Class) List.class), Akcija.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}} */
  @XmlElementDecl(namespace = "", name = "elektronska-posta", scope = NacinDostave.class)
  public JAXBElement<String> createNacinDostaveElektronskaPosta(String value) {
    return new JAXBElement<String>(
        _NacinDostaveElektronskaPosta_QNAME, String.class, NacinDostave.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}} */
  @XmlElementDecl(namespace = "", name = "faks", scope = NacinDostave.class)
  public JAXBElement<String> createNacinDostaveFaks(String value) {
    return new JAXBElement<String>(
        _NacinDostaveFaks_QNAME, String.class, NacinDostave.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link NacinDostave.Posta }{@code >}} */
  @XmlElementDecl(namespace = "", name = "posta", scope = NacinDostave.class)
  public JAXBElement<NacinDostave.Posta> createNacinDostavePosta(NacinDostave.Posta value) {
    return new JAXBElement<NacinDostave.Posta>(
        _NacinDostavePosta_QNAME, NacinDostave.Posta.class, NacinDostave.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Uzrok }{@code >}} */
  @XmlElementDecl(namespace = "", name = "uzrok", scope = Predgovor.class)
  public JAXBElement<Uzrok> createPredgovorUzrok(Uzrok value) {
    return new JAXBElement<Uzrok>(_OdbijanjeUzrok_QNAME, Uzrok.class, Predgovor.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Osnov }{@code >}} */
  @XmlElementDecl(namespace = "", name = "osnov", scope = Predgovor.class)
  public JAXBElement<Osnov> createPredgovorOsnov(Osnov value) {
    return new JAXBElement<Osnov>(_UputPoverenikaOsnov_QNAME, Osnov.class, Predgovor.class, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link Lice }{@code >}} */
  @XmlElementDecl(namespace = "", name = "zalilac", scope = Predgovor.class)
  public JAXBElement<Lice> createPredgovorZalilac(Lice value) {
    return new JAXBElement<Lice>(_OdbijanjeZalilac_QNAME, Lice.class, Predgovor.class, value);
  }
}
