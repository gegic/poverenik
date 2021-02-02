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
            o.getOrgan().getAdresa().getMesto().setDatatype("xs:string");

            o.getOrgan().getAdresa().getUlica().setProperty("pred:ulica-ustanove");
            o.getOrgan().getAdresa().getUlica().setDatatype("xs:string");
            o.getOrgan().getNaziv().setProperty("pred:naziv-ustanove");
            o.getOrgan().getNaziv().setDatatype("xs:string");

            o.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
            o.getPodnosilac().getAdresa().getMesto().setDatatype("xs:string");
            o.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
            o.getPodnosilac().getAdresa().getUlica().setDatatype("xs:string");
            o.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
            o.getPodnosilac().getImePrezime().setDatatype("xs:string");

            o.getZahtev().getDatum().setProperty("pred:datum-zahteva");
            o.getZahtev().getDatum().setDatatype("xs:date");
            o.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
            o.getZahtev().getOpisZahteva().setDatatype("xs:string");

            if (o.getTip().equalsIgnoreCase("prihvatanje")) {
                PrihvacenZahtev.Datum d = new PrihvacenZahtev.Datum();
                d.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(i.toString()));
                d.setProperty("pred:datum-obavestenja");
                d.setDatatype("xs:date");
                o.getSadrzajObavestenja().getPrihvacenZahtev().setDatum(d);

                o.getSadrzajObavestenja().getPrihvacenZahtev().getKancelarija().setProperty("pred:kancelarija");
                o.getSadrzajObavestenja().getPrihvacenZahtev().getKancelarija().setDatatype("xs:positiveInt");

                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getMesto().setProperty("pred:mesto-uvida");
                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getMesto().setDatatype("xs:string");

                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getUlica().setProperty("pred:ulica-uvida");
                o.getSadrzajObavestenja().getPrihvacenZahtev().getAdresa().getUlica().setDatatype("xs:string");
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
            String graphUri = String.format("obavestenja/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
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
