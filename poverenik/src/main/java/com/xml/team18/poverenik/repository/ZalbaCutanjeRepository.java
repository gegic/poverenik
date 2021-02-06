package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class ZalbaCutanjeRepository {
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

    public ZalbaCutanje save(ZalbaCutanje z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            z.setVocab("http://team14.xml.com/rdf/zalbe-cutanje/predicate/");
            z.setAbout("http://team14.xml.com/rdf/zalbe-cutanje/" + id);
            z.getPrimalac().getAdresa().getMesto().setProperty("pred:mesto-poverenika");
            z.getPrimalac().getAdresa().getUlica().setProperty("pred:ulica-poverenika");
            z.getPrimalac().getNaziv().setProperty("pred:naziv-poverenika");
            z.getProtiv().getAdresa().getMesto().setProperty("pred:mesto-protivnika");
            z.getProtiv().getAdresa().getUlica().setProperty("pred:ulica-protivnika");
            z.getProtiv().getNaziv().setProperty("pred:naziv-protivnika");
            z.getZahtev().getDatum().setProperty("pred:datum-zahteva");
            z.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
            z.getMesto().setProperty("pred:mesto-zalbe");
            z.getDatum().setProperty("pred:datum-zalbe");
            z.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
            z.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
            z.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
            JAXBElement<ZalbaCutanje> element = new JAXBElement<>(QName.valueOf("zalba-cutanje"), ZalbaCutanje.class, z);
            String rawXml = jaxB.marshall(element, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "zalbecutanje");
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (ZalbaCutanje) jaxB.unmarshall(contentFound, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ZalbaCutanje findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (ZalbaCutanje) jaxB
                    .unmarshall(contentFound, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ZalbaCutanje> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (ZalbaCutanje) jaxB
                            .unmarshall(con, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
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

    public List<ZalbaCutanje> naprednaPretraga(String upit) {
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
        List<String> ids = this.fusekiWriter.getIdsForString("zalbecutanje", whereQuery);
        try {
            return this.getByIds(ids);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<ZalbaCutanje> getByIds(List<String> ids) throws Exception {
        String idsJoined = ids.stream()
                .map(id -> id.replace("http://team14.xml.com/rdf/zalbecutanje/", ""))
                .collect(Collectors.joining(" "));
        String query = String.format("/zalba-cutanje[contains('%s', @id)]", idsJoined);
        return this.getByQuery(query);
    }
    public List<ZalbaCutanje> getAllByKorisnikId(String id) throws Exception {
        String query = String.format("/zalba-cutanje[podnosilac/@id = '%s']", id);
        return this.getByQuery(query);
    }

    public List<ZalbaCutanje> getAllNeresene() throws Exception {
        String query = "/zalba-cutanje[@tip-resenja = 'neresena']";
        return this.getByQuery(query);
    }

    private List<ZalbaCutanje> getByQuery(String query) throws Exception {
        List<ZalbaCutanje> zahtevi = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zahtevi.add((ZalbaCutanje) jaxB
                    .unmarshall(r.getContent().toString(), ZalbaCutanje.class, ZalbaCutanje.class));
        }
        return zahtevi;
    }
}
