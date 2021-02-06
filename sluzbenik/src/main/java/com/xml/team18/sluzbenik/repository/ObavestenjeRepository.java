package com.xml.team18.sluzbenik.repository;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.exist.ExistManager;
import com.xml.team18.sluzbenik.factory.ObavestenjeFactory;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.fuseki.FusekiWriter;
import com.xml.team18.sluzbenik.fuseki.MetadataExtractor;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.obavestenje.Cenovnik;
import com.xml.team18.sluzbenik.model.obavestenje.Obavestenje;
import com.xml.team18.sluzbenik.model.obavestenje.PrihvacenZahtev;
import com.xml.team18.sluzbenik.model.obavestenje.Primalac;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.validation.constraints.Null;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class ObavestenjeRepository {
    private final String collectionId = "/db/obavestenja";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ObavestenjeRepository(ExistManager existManager,
                                 MetadataExtractor metadataExtractor,
                                 FusekiWriter fusekiWriter,
                                 JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public Obavestenje save(Obavestenje o) {
        try {
            String id = o.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                o.setId(id);
            }
            long cijena = 0;
            for (Cenovnik.Stavka s : o.getIzdanaDokumenta().getCenovnik().getStavka()) {
                cijena += s.getCena().longValue();
            }
            o.getIzdanaDokumenta().setCena(BigInteger.valueOf(cijena));
            o.setVocab("http://team14.xml.com/rdf/obavestenja/predicate/");
            o.setAbout("http://team14.xml.com/rdf/obavestenja/" + id);
            LocalDate now = LocalDate.now();
            Instant i = now.atStartOfDay(ZoneId.systemDefault()).toInstant();
            o.setDatum(DatatypeFactory.newInstance().newXMLGregorianCalendar(i.toString()));
            o.getOrgan().getAdresa().getMesto().setProperty("pred:mesto-ustanove");
//            o.getOrgan().getAdresa().getMesto().setDatatype("xs:string");

            o.getOrgan().getAdresa().getUlica().setProperty("pred:ulica-ustanove");
            o.getOrgan().getAdresa().getUlica().setDatatype("xs:string");
            o.getOrgan().getNaziv().setProperty("pred:naziv-ustanove");
//            o.getOrgan().getNaziv().setDatatype("xs:string");

            o.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
//            o.getPodnosilac().getAdresa().getMesto().setDatatype("xs:string");
            o.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
//            o.getPodnosilac().getAdresa().getUlica().setDatatype("xs:string");
            o.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
//            o.getPodnosilac().getImePrezime().setDatatype("xs:string");

            o.getZahtev().getDatum().setProperty("pred:datum-zahteva");
//            o.getZahtev().getDatum().setDatatype("xs:date");
            o.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
//            o.getZahtev().getOpisZahteva().setDatatype("xs:string");

            if (o.getTip().equalsIgnoreCase("prihvatanje")) {
                PrihvacenZahtev.Datum d = new PrihvacenZahtev.Datum();
                d.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(i.toString()));
                d.setProperty("pred:datum-obavestenja");
//                d.setDatatype("xs:date");
                o.getSadrzajObavestenja().getPrihvacenZahtev().setDatum(d);

                o.getSadrzajObavestenja().getPrihvacenZahtev().getKancelarija().setProperty("pred:kancelarija");
//                o.getSadrzajObavestenja().getPrihvacenZahtev().getKancelarija().setDatatype("xs:positiveInt");

                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getMesto().setProperty("pred:mesto-uvida");
//                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getMesto().setDatatype("xs:string");

                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getUlica().setProperty("pred:ulica-uvida");
//                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getUlica().setDatatype("xs:string");
                Primalac p = new Primalac();
                p.setBrojRacuna("840-742328-843-30");
                p.setModel(97);
                p.setPozivNaBroj("12312");
                p.setOrgan(o.getOrgan());

                o.getIzdanaDokumenta().setPrimalac(p);
            }
            JAXBElement<Obavestenje> element = new JAXBElement<Obavestenje>(QName
                    .valueOf("obavestenje"), Obavestenje.class, o);
            String rawXml = jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "obavestenja");
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Obavestenje) jaxB
                    .unmarshall(contentFound, Obavestenje.class, ObavestenjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public Obavestenje saveFromPath(String path) throws Exception {
        String id = UUID.randomUUID().toString();
        try {
            this.existManager.saveFile(collectionId, id, path);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Obavestenje) jaxB
                    .unmarshall(contentFound, Obavestenje.class, ObavestenjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public List<Obavestenje> getAllByKorisnikId(String id) throws Exception {
        String query = String.format("/obavestenje[podnosilac/@id = '%s']", id);
        return this.getByQuery(query);
    }

    public Obavestenje getByZahtevId(String zahtevId) throws Exception {
        String query = String.format("/obavestenje[zahtev/@id = '%s']", zahtevId);
        return this.getByQuery(query).get(0);
    }

    public Obavestenje findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (Obavestenje) jaxB
                    .unmarshall(contentFound, Obavestenje.class, ObavestenjeFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Obavestenje> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Obavestenje) jaxB
                        .unmarshall(con, Obavestenje.class, ObavestenjeFactory.class);
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    public List<Obavestenje> pretraga(String tekst) throws Exception {
        String query = String.format("/obavestenje[descendant::*[text()[contains(lower-case(.), '%s')]]]", tekst.toLowerCase());
        return this.getByQuery(query);
    }

    public List<Obavestenje> naprednaPretraga(String upit) {
        Pattern p = Pattern.compile("([\\w:\\-]+)\\s+eq\\s+\"([\\w\\d \\-]+)\"");
        Matcher m = p.matcher(upit);
        String prvaZamena;
        if (m.find()) {
            prvaZamena = m.replaceAll("$1 \"$2\"^^<http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral>");  // number 46
        } else {
            return new ArrayList<>();
        }
        p = Pattern.compile("\"([\\w\\d]{8}(-[\\w\\d]{4}){3}-[\\w\\d]{12})\"\\^\\^<http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral>");
        m = p.matcher(prvaZamena);
        String drugaZamena;
        if (m.find()) {
            drugaZamena = m.replaceAll("\"$1\"^^<http://www.w3.org/2000/01/rdf-schema#Literal>");
        } else {
            drugaZamena = prvaZamena;
        }
        String filterQuery = drugaZamena.replaceAll(" and ", "; ").replaceAll(" or ", "} union { ?s ");
        String whereQuery = String.format("{?s %s }", filterQuery);
        List<String> ids = this.fusekiWriter.getIdsForString("obavestenja", whereQuery);
        try {
            return this.getByIds(ids);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Obavestenje> getByIds(List<String> ids) throws Exception {
        String idsJoined = ids.stream()
                .map(id -> id.replace("http://team14.xml.com/rdf/obavestenja/", ""))
                .collect(Collectors.joining(" "));
        String query = String.format("/obavestenje[contains('%s', @id)]", idsJoined);
        return this.getByQuery(query);
    }

    private List<Obavestenje> getByQuery(String query) throws Exception {
        List<Obavestenje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((Obavestenje) jaxB
                    .unmarshall(r.getContent().toString(), Obavestenje.class, ObavestenjeFactory.class));
        }
        return zahtevi;
    }
}
