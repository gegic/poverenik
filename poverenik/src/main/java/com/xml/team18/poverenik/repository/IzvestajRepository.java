package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.IzvestajFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.poverenik.model.izvestaj.Izvestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class IzvestajRepository {
    private final String collectionId = "/db/izvestaji";

    private final ExistManager existManager;
    private final JaxB jaxB;

    @Autowired
    public IzvestajRepository(ExistManager existManager,
                              JaxB jaxB) {
        this.existManager = existManager;
        this.jaxB = jaxB;
    }


    public Izvestaj save(Izvestaj o) {
        try {
            String id = o.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                o.setId(id);
            }
            JAXBElement<Izvestaj> element = new JAXBElement<>(QName
                    .valueOf("izvestaj"), Izvestaj.class, o);
            String rawXml = jaxB.marshall(element, Izvestaj.class, IzvestajFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Izvestaj) jaxB
                    .unmarshall(contentFound, Izvestaj.class, IzvestajFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public Izvestaj findById(String id) throws Exception {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (Izvestaj) jaxB
                    .unmarshall(contentFound, Izvestaj.class, IzvestajFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Izvestaj> pretraga(String tekst) throws Exception {
        String query = String.format("/izvestaj[//*/text()[contains(lower-case(.), '%s')]]", tekst.toLowerCase());
        return this.getByQuery(query);
    }

    public List<Izvestaj> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(str ->
                    {
                        try {
                            return (Izvestaj) jaxB
                                    .unmarshall(str, Izvestaj.class, IzvestajFactory.class);
                        } catch (JAXBException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Izvestaj> getByQuery(String query) throws Exception {
        List<Izvestaj> izvestaji = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            izvestaji.add((Izvestaj) ((JAXBElement<?>) jaxB
                    .unmarshall(r.getContent().toString(), Izvestaj.class, IzvestajFactory.class))
                    .getValue());
        }
        return izvestaji;
    }
}
