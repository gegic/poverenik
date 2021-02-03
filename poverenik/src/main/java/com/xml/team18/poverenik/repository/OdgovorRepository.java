package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.OdgovorFactory;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
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
public class OdgovorRepository {
    private final String collectionId = "/db/odgovori";

    private final ExistManager existManager;
    private final JaxB jaxB;

    @Autowired
    public OdgovorRepository(ExistManager existManager,
                             JaxB jaxB) {
        this.existManager = existManager;
        this.jaxB = jaxB;
    }

    public OdgovorIzjasnjenje save(OdgovorIzjasnjenje z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            String rawXml = jaxB.marshall(z, OdgovorIzjasnjenje.class, OdgovorFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (OdgovorIzjasnjenje) jaxB.unmarshall(contentFound, OdgovorIzjasnjenje.class, OdgovorFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public OdgovorIzjasnjenje findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (OdgovorIzjasnjenje) jaxB
                    .unmarshall(contentFound, OdgovorIzjasnjenje.class, OdgovorFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OdgovorIzjasnjenje> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (OdgovorIzjasnjenje) jaxB
                            .unmarshall(con, OdgovorIzjasnjenje.class, OdgovorFactory.class);
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

    public OdgovorIzjasnjenje getByIdZalbe(String idZalbe) {
        String query = String.format("/odgovor-izjasnjenje[@id-zalbe = '%s']", idZalbe);
        try {
            return this.getByQuery(query).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    private List<OdgovorIzjasnjenje> getByQuery(String query) throws Exception {
        List<OdgovorIzjasnjenje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((OdgovorIzjasnjenje) jaxB
                    .unmarshall(r.getContent().toString(), OdgovorIzjasnjenje.class, OdgovorFactory.class));
        }
        return zahtevi;
    }
}
