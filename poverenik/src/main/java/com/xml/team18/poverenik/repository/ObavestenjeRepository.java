package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
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
public class ObavestenjeRepository implements XmlRepository<Obavestenje> {
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
            return (Obavestenje) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Obavestenje.class, com.xml.team18.poverenik.factory.ObavestenjeFactory.class))
                    .getValue();
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
            return (Obavestenje) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Obavestenje.class, com.xml.team18.poverenik.factory.ObavestenjeFactory.class))
                    .getValue();
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public Obavestenje findById(UUID uuid) throws ResourceNotFoundException {
        String id = uuid.toString();
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound = null;
        try {
            contentFound = found.getContent().toString();
            return (Obavestenje) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Obavestenje.class, com.xml.team18.poverenik.factory.ObavestenjeFactory.class))
                    .getValue();
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Obavestenje> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Obavestenje) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Obavestenje.class, com.xml.team18.poverenik.factory.ObavestenjeFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }
}
