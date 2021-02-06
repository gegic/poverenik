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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            z.getDatum().setProperty("pred:datum-resenja");
            z.getPoverenik().getImePrezime().setProperty("pred:ime-prezime-poverenika");
            z.getZalilac().getImePrezime().setProperty("pred:ime-prezime-zalioca");
            z.getProtiv().getNaziv().setProperty("pred:naziv-ustanove");

            String rawXml = jaxB.marshall(z, Resenje.class, ResenjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "resenja");
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

    public List<Resenje> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (Resenje) jaxB.unmarshall(con, Resenje.class, ResenjeFactory.class);
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

    public List<Resenje> pretraga(String tekst) throws Exception {
        String query = String.format("/resenje[descendant::*[text()[contains(lower-case(.), '%s')]]]", tekst.toLowerCase());
        return this.getByQuery(query);
    }

    public List<Resenje> naprednaPretraga(String upit) {
        Pattern p = Pattern.compile("([\\w:\\-]+)\\s+eq\\s+\"([\\w\\d \\-]+)\"");
        Matcher m = p.matcher(upit);
        String prvaZamena;
        if (m.find()) {
            prvaZamena = m.replaceAll("$1 \"$2\"^^<http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral>");  // number 46
        } else {
            return new ArrayList<>();
        }
        p = Pattern.compile("\"([\\w\\d]{8}(-[\\w\\d]{4}){3}-[\\w\\d]{12})\"\\^\\^<http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral>");
        m = p.matcher(prvaZamena);
        String drugaZamena;
        if (m.find()) {
            drugaZamena = m.replaceAll("\"$1\"^^<http://www.w3.org/2000/01/rdf-schema#Literal>");
        } else {
            drugaZamena = prvaZamena;
        }
        String filterQuery = drugaZamena.replaceAll(" and ", "; ").replaceAll(" or ", "} union { ?s ");
        String whereQuery = String.format("{?s %s }", filterQuery);
        List<String> ids = this.fusekiWriter.getIdsForString("resenja", whereQuery);
        try {
            return this.getByIds(ids);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Resenje> getByIds(List<String> ids) throws Exception {
        String idsJoined = ids.stream()
                .map(id -> id.replace("http://team14.xml.com/rdf/resenja/", ""))
                .collect(Collectors.joining(" "));
        String query = String.format("/resenje[contains('%s', @id)]", idsJoined);
        return this.getByQuery(query);
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
