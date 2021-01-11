package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.na.odluku.Zalba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ZalbaNaOdlukuRepository implements XmlRepository<Zalba> {
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

    public Zalba save(Zalba z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
            }
            JAXBElement<Zalba> element = new JAXBElement<Zalba>(QName.valueOf("zalba"), Zalba.class, z);
            String rawXml = jaxB.marshall(element, Zalba.class, ZalbaNaOdlukuFactory.class);
             this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            String graphUri = String.format("zalbenaodluku/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
            XMLResource found = this.existManager.read(collectionId, id);
            return null;
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    @Override
    public Zalba findById(UUID uuid) throws Exception {
        return null;
    }

    public List<Zalba> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Zalba) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Zalba.class, com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }
}
