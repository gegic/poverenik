package com.xml.team18.sluzbenik.repository;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.exist.ExistManager;
import com.xml.team18.sluzbenik.factory.IzjasnjenjeFactory;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.fuseki.FusekiWriter;
import com.xml.team18.sluzbenik.fuseki.MetadataExtractor;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
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
public class IzjasnjenjeRepository {
    private final String collectionId = "/db/izjasnjenja";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public IzjasnjenjeRepository(ExistManager existManager,
                                 MetadataExtractor metadataExtractor,
                                 FusekiWriter fusekiWriter,
                                 JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public Izjasnjenje save(Izjasnjenje z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }

            String rawXml = jaxB.marshall(z, Izjasnjenje.class, IzjasnjenjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Izjasnjenje) jaxB.unmarshall(contentFound, Izjasnjenje.class, IzjasnjenjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public List<Izjasnjenje> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(str ->
                {
                    try {
                        return (Izjasnjenje) jaxB
                                .unmarshall(str, Izjasnjenje.class, IzjasnjenjeFactory.class);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
        ).collect(Collectors.toList());
    }

    public void deleteById(String id) {
        try {
            this.existManager.deleteById(collectionId, id);
        } catch (Exception ignored) {
        }
    }

    public void deleteByIdZahteva(String idZahteva) throws Exception {
        Izjasnjenje i = this.getByIdZahteva(idZahteva);
        this.existManager.deleteById(collectionId, i.getId());
    }

    public void deleteByIdZalbe(String idZalbe) throws Exception {
        Izjasnjenje i = this.getByIdZalbe(idZalbe);
        this.existManager.deleteById(collectionId, i.getId());
    }

    public Izjasnjenje getByIdZahteva(String idZahteva) throws Exception {
        String query = String.format("/izjasnjenje[@id-zahteva = '%s']", idZahteva);
        return this.getByQuery(query).get(0);
    }

    public Izjasnjenje getByIdZalbe(String idZalbe) throws Exception {
        String query = String.format("/izjasnjenje[@id-zalbe = '%s']", idZalbe);
        return this.getByQuery(query).get(0);
    }

    private List<Izjasnjenje> getByQuery(String query) throws Exception {
        List<Izjasnjenje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((Izjasnjenje) jaxB
                    .unmarshall(r.getContent().toString(), Zahtev.class, ZahtevFactory.class));
        }
        return zahtevi;
    }
}
