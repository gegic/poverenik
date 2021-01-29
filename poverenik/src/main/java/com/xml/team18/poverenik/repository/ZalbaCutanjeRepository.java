package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ZalbaCutanjeRepository implements XmlRepository<Zalba> {
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

    public Zalba save(Zalba z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            JAXBElement<Zalba> element = new JAXBElement<Zalba>(QName.valueOf("zalba-cutanje"), Zalba.class, z);
            String rawXml = jaxB.marshall(element, Zalba.class, ZalbaCutanjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            String graphUri = String.format("zalbecutanje/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Zalba) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zalba.class, com.xml.team18.poverenik.factory.ZalbaCutanjeFactory.class))
                    .getValue();
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Zalba findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound = null;
        try {
            contentFound = found.getContent().toString();
            return (Zalba) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zalba.class, com.xml.team18.poverenik.factory.ZalbaCutanjeFactory.class))
                    .getValue();
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Zalba> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Zalba) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Zalba.class, com.xml.team18.poverenik.factory.ZalbaCutanjeFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }
}
