package com.xml.team18.sluzbenik.repository;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.exist.ExistManager;
import com.xml.team18.sluzbenik.factory.KorisnikFactory;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
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
public class KorisnikRepository {
    private final String collectionId = "/db/korisnici";

    private final ExistManager existManager;
    private final JaxB jaxB;

    @Autowired
    public KorisnikRepository(ExistManager existManager, JaxB jaxB) {
        this.existManager = existManager;
        this.jaxB = jaxB;
    }

    public Korisnik save(Korisnik o) {
        try {
            String id = o.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                o.setId(id);
            }
            JAXBElement<Korisnik> element = new JAXBElement<>(QName
                    .valueOf("korisnik"), Korisnik.class, o);
            String rawXml = jaxB.marshall(element, Korisnik.class, KorisnikFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Korisnik) jaxB
                    .unmarshall(contentFound, Korisnik.class, KorisnikFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public Korisnik findById(String id) throws Exception {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (Korisnik) jaxB
                    .unmarshall(contentFound, Korisnik.class, KorisnikFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Korisnik> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Korisnik) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Korisnik.class, KorisnikFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    public Korisnik findByEmail(String email) {
        String xPath = String.format("/korisnik[email = '%s']", email);
        String contentFound;
        try {
            contentFound = this.existManager.query(collectionId, xPath).getResource(0).getContent().toString();
            return (Korisnik) jaxB
                    .unmarshall(contentFound, Korisnik.class, KorisnikFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            return null;
        }

    }
}
