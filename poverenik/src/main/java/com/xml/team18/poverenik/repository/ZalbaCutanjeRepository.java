package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ZalbaCutanjeRepository {
    private final String collectionId = "/db/zalbecutanje";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ZalbaCutanjeRepository(ExistManager existManager,
                                  MetadataExtractor metadataExtractor,
                                  FusekiWriter fusekiWriter,
                                  JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public ZalbaCutanje save(ZalbaCutanje z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            z.setVocab("http://team14.xml.com/rdf/zalbe-cutanje/predicate/");
            z.setAbout("http://team14.xml.com/rdf/zalbe-cutanje/" + id);
            z.getPrimalac().getAdresa().getMesto().setProperty("pred:mesto-poverenika");
            z.getPrimalac().getAdresa().getMesto().setDatatype("xs:string");
            z.getPrimalac().getAdresa().getUlica().setProperty("pred:ulica-poverenika");
            z.getPrimalac().getAdresa().getUlica().setDatatype("xs:string");
            z.getPrimalac().getNaziv().setProperty("pred:naziv-poverenika");
            z.getPrimalac().getNaziv().setDatatype("xs:string");
            z.getProtiv().getAdresa().getMesto().setProperty("pred:mesto-protivnika");
            z.getProtiv().getAdresa().getMesto().setDatatype("xs:string");
            z.getProtiv().getAdresa().getUlica().setProperty("pred:ulica-protivnika");
            z.getProtiv().getAdresa().getUlica().setDatatype("xs:string");
            z.getProtiv().getNaziv().setProperty("pred:naziv-protivnika");
            z.getProtiv().getNaziv().setDatatype("xs:string");
            z.getZahtev().getDatum().setProperty("pred:datum-zahteva");
            z.getZahtev().getDatum().setDatatype("xs:date");
            z.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
            z.getZahtev().getOpisZahteva().setDatatype("xs:string");
            z.getMesto().setProperty("pred:mesto-zalbe");
            z.getMesto().setDatatype("xs:string");
            z.getDatum().setProperty("pred:datum-zalbe");
            z.getDatum().setDatatype("xs:date");
            z.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
            z.getPodnosilac().getAdresa().getMesto().setDatatype("xs:string");
            z.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
            z.getPodnosilac().getAdresa().getUlica().setDatatype("xs:string");
            z.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
            z.getPodnosilac().getImePrezime().setDatatype("xs:string");
            JAXBElement<ZalbaCutanje> element = new JAXBElement<>(QName.valueOf("zalba-cutanje"), ZalbaCutanje.class, z);
            String rawXml = jaxB.marshall(element, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "zalbecutanje");
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (ZalbaCutanje) jaxB.unmarshall(contentFound, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ZalbaCutanje findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (ZalbaCutanje) jaxB
                    .unmarshall(contentFound, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ZalbaCutanje> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (ZalbaCutanje) jaxB
                            .unmarshall(con, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
                } catch (JAXBException e) {
                    e.printStackTrace();
                    return null;
                }
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<ZalbaCutanje> getAllByKorisnikId(String id) throws Exception {
        String query = String.format("/zalba-cutanje[podnosilac/@id = '%s']", id);
        return this.getByQuery(query);
    }

    public List<ZalbaCutanje> getAllNeresene() throws Exception {
        String query = "/zalba-cutanje[@tip-resenja = 'neresena']";
        return this.getByQuery(query);
    }

    private List<ZalbaCutanje> getByQuery(String query) throws Exception {
        List<ZalbaCutanje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((ZalbaCutanje) jaxB
                    .unmarshall(r.getContent().toString(), ZalbaCutanje.class, ZalbaCutanje.class));
        }
        return zahtevi;
    }
}
