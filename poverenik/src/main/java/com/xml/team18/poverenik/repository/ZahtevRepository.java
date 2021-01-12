package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ZahtevRepository implements XmlRepository<Zahtev> {
    private final String collectionId = "/db/zahtevi";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ZahtevRepository(ExistManager existManager,
                            MetadataExtractor metadataExtractor,
                            FusekiWriter fusekiWriter,
                            JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public Zahtev save(Zahtev z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            JAXBElement<Zahtev> element = new JAXBElement<Zahtev>(QName.valueOf("zahtev"), Zahtev.class, z);
            String rawXml = jaxB.marshall(element, Zahtev.class, ZahtevFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            String graphUri = String.format("zahtevi/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Zahtev) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zahtev.class, com.xml.team18.poverenik.factory.ZahtevFactory.class))
                    .getValue();
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }



    public Zahtev findById(UUID uuid) throws ResourceNotFoundException {
        String id = uuid.toString();
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound = null;
        try {
            contentFound = found.getContent().toString();
            return (Zahtev) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zahtev.class, com.xml.team18.poverenik.factory.ZahtevFactory.class))
                    .getValue();
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Zahtev> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Zahtev) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Zahtev.class, com.xml.team18.poverenik.factory.ZahtevFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    private String checkForId(String xmlZahtev) throws JAXBException {
        Zahtev z = (Zahtev) ((JAXBElement<?>) jaxB
                .unmarshall(xmlZahtev, Zahtev.class, com.xml.team18.poverenik.factory.ZahtevFactory.class))
                .getValue();
        return z.getId();
    }
}
