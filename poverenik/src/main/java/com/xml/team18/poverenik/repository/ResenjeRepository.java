package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.OdgovorFactory;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.model.resenje.Resenje;
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
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ResenjeRepository {
    private final String collectionId = "/db/resenja";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ResenjeRepository(ExistManager existManager,
                             MetadataExtractor metadataExtractor,
                             FusekiWriter fusekiWriter,
                             JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public Resenje save(Resenje z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            z.setVocab("http://team14.xml.com/rdf/resenja/predicate/");
            z.setAbout("http://team14.xml.com/rdf/resenja/" + id);
            z.setProperty("pred:zalba");
            z.setContent(z.getZalba().getId());
            z.getDatum().setProperty("pred:datum-resenja");
            z.getDatum().setDatatype("xs:date");
            z.getPoverenik().getImePrezime().setProperty("pred:ime-prezime-poverenika");
            z.getPoverenik().getImePrezime().setDatatype("xs:string");
            z.getZalilac().getImePrezime().setProperty("pred:ime-prezime-zalioca");
            z.getZalilac().getImePrezime().setDatatype("xs:string");
            z.getProtiv().getNaziv().setProperty("pred:naziv-ustanove");
            z.getProtiv().getNaziv().setDatatype("xs:string");

            String rawXml = jaxB.marshall(z, Resenje.class, ResenjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            String graphUri = String.format("resenja/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Resenje) jaxB.unmarshall(contentFound, Resenje.class, ResenjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public Resenje findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound = null;
        try {
            contentFound = found.getContent().toString();
            return (Resenje) jaxB
                    .unmarshall(contentFound, Resenje.class, ResenjeFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Resenje> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Resenje) jaxB.unmarshall(con, Resenje.class, ResenjeFactory.class);
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    public List<Resenje> getByKorisnikId(String idZalbe) throws Exception {
        String query = String.format("/resenje[zalilac@id = '%s']", idZalbe);
        return this.getByQuery(query);
    }


    private List<Resenje> getByQuery(String query) throws Exception {
        List<Resenje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((Resenje) jaxB
                    .unmarshall(r.getContent().toString(), Resenje.class, ResenjeFactory.class));
        }
        return zahtevi;
    }
}
