package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
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
public class ZalbaNaOdlukuRepository {
    private final String collectionId = "/db/zalbenaodluku";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ZalbaNaOdlukuRepository(ExistManager existManager,
                                  MetadataExtractor metadataExtractor,
                                  FusekiWriter fusekiWriter,
                                  JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public ZalbaNaOdluku save(ZalbaNaOdluku z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            z.setVocab("http://team14.xml.com/rdf/zalbe-na-odluku/predicate/");
            z.setAbout("http://team14.xml.com/rdf/zalbe-na-odluku/" + id);
            z.getPrimalac().getAdresa().getMesto().setProperty("pred:mesto-poverenika");
            z.getPrimalac().getAdresa().getMesto().setDatatype("xs:string");
            z.getPrimalac().getAdresa().getUlica().setProperty("pred:ulica-poverenika");
            z.getPrimalac().getAdresa().getUlica().setDatatype("xs:string");
            z.getPrimalac().getNaziv().setProperty("pred:naziv-poverenika");
            z.getPrimalac().getNaziv().setDatatype("xs:string");
            z.getProtiv().getDonosilac().getAdresa().getMesto().setProperty("pred:mesto-protivnika");
            z.getProtiv().getDonosilac().getAdresa().getMesto().setDatatype("xs:string");
            z.getProtiv().getDonosilac().getAdresa().getUlica().setProperty("pred:ulica-protivnika");
            z.getProtiv().getDonosilac().getAdresa().getUlica().setDatatype("xs:string");
            z.getProtiv().getDonosilac().getNaziv().setProperty("pred:naziv-protivnika");
            z.getProtiv().getDonosilac().getNaziv().setDatatype("xs:string");
            z.getZahtev().getDatum().setProperty("pred:datum-zahteva");
            z.getZahtev().getDatum().setDatatype("xs:date");
            z.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
            z.getZahtev().getOpisZahteva().setDatatype("xs:string");
            z.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
            z.getPodnosilac().getAdresa().getMesto().setDatatype("xs:string");
            z.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
            z.getPodnosilac().getAdresa().getUlica().setDatatype("xs:string");
            z.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
            z.getPodnosilac().getImePrezime().setDatatype("xs:string");
            JAXBElement<ZalbaNaOdluku> element = new JAXBElement<>(QName.valueOf("zalba-na-odluku"), ZalbaNaOdluku.class, z);
            String rawXml = jaxB.marshall(element, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "zalbenaodluku");
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (ZalbaNaOdluku) jaxB.unmarshall(contentFound, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ZalbaNaOdluku findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (ZalbaNaOdluku) jaxB
                    .unmarshall(contentFound, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ZalbaNaOdluku> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (ZalbaNaOdluku) jaxB
                            .unmarshall(con, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
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

    public List<ZalbaNaOdluku> getAllByKorisnikId(String id) throws Exception {
        String query = String.format("/zalba-na-odluku[podnosilac/@id = '%s']", id);
        return this.getByQuery(query);
    }

    public List<ZalbaNaOdluku> getAllNeresene() throws Exception {
        String query = "/zalba-na-odluku[@tip-resenja = 'neresena']";
        return this.getByQuery(query);
    }

    private List<ZalbaNaOdluku> getByQuery(String query) throws Exception {
        List<ZalbaNaOdluku> zalbeNaOdluku = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zalbeNaOdluku.add((ZalbaNaOdluku) jaxB
                    .unmarshall(r.getContent().toString(), ZalbaNaOdluku.class, ZalbaNaOdluku.class));
        }
        return zalbeNaOdluku;
    }
}
