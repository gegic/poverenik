package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.fuseki.FusekiWriter;
import com.xml.team18.poverenik.fuseki.MetadataExtractor;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
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
public class ZalbaNaOdlukuRepository {
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

    public ZalbaNaOdluku save(ZalbaNaOdluku z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            z.setVocab("http://team14.xml.com/rdf/zalbe-na-odluku/predicate/");
            z.setAbout("http://team14.xml.com/rdf/zalbe-na-odluku/" + id);
            z.getPrimalac().getAdresa().getMesto().setProperty("pred:mesto-poverenika");
            z.getPrimalac().getAdresa().getUlica().setProperty("pred:ulica-poverenika");
            z.getPrimalac().getNaziv().setProperty("pred:naziv-poverenika");
            z.getProtiv().getDonosilac().getAdresa().getMesto().setProperty("pred:mesto-protivnika");
            z.getProtiv().getDonosilac().getAdresa().getUlica().setProperty("pred:ulica-protivnika");
            z.getProtiv().getDonosilac().getNaziv().setProperty("pred:naziv-protivnika");
            z.getZahtev().getDatum().setProperty("pred:datum-zahteva");
            z.getZahtev().getOpisZahteva().setProperty("pred:opis-zahteva");
            z.getPodnosilac().getAdresa().getMesto().setProperty("pred:mesto-podnosioca");
            z.getPodnosilac().getAdresa().getUlica().setProperty("pred:ulica-podnosioca");
            z.getPodnosilac().getImePrezime().setProperty("pred:ime-prezime-podnosioca");
            JAXBElement<ZalbaNaOdluku> element = new JAXBElement<>(QName.valueOf("zalba-na-odluku"), ZalbaNaOdluku.class, z);
            String rawXml = jaxB.marshall(element, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            this.fusekiWriter.saveRDF(rdf, "zalbenaodluku");
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (ZalbaNaOdluku) jaxB.unmarshall(contentFound, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ZalbaNaOdluku findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (ZalbaNaOdluku) jaxB
                    .unmarshall(contentFound, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ZalbaNaOdluku> getAll() {
        try {
            return this.existManager.readAll(collectionId).stream().map(con -> {
                try {
                    return (ZalbaNaOdluku) jaxB
                            .unmarshall(con, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
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

    public List<ZalbaNaOdluku> getAllByKorisnikId(String id) throws Exception {
        String query = String.format("/zalba-na-odluku[podnosilac/@id = '%s']", id);
        return this.getByQuery(query);
    }

    public List<ZalbaNaOdluku> getAllNeresene() throws Exception {
        String query = "/zalba-na-odluku[@tip-resenja = 'neresena']";
        return this.getByQuery(query);
    }

    public List<ZalbaNaOdluku> pretraga(String tekst) throws Exception {
        String query = String.format("/zalba-na-odluku[descendant::*[text()[contains(lower-case(.), '%s')]]]", tekst.toLowerCase());
        return this.getByQuery(query);
    }


    public List<ZalbaNaOdluku> naprednaPretraga(String upit) {
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
        List<String> ids = this.fusekiWriter.getIdsForString("zalbenaodluku", whereQuery);
        try {
            return this.getByIds(ids);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<ZalbaNaOdluku> getByIds(List<String> ids) throws Exception {
        String idsJoined = ids.stream()
                .map(id -> id.replace("http://team14.xml.com/rdf/zalbenaodluku/", ""))
                .collect(Collectors.joining(" "));
        String query = String.format("/zalba-na-odluku[contains('%s', @id)]", idsJoined);
        return this.getByQuery(query);
    }

    private List<ZalbaNaOdluku> getByQuery(String query) throws Exception {
        List<ZalbaNaOdluku> zalbeNaOdluku = new ArrayList<>();
        ResourceIterator iterator = this.existManager.query(collectionId, query).getIterator();

        while(iterator.hasMoreResources()) {
            Resource r = iterator.nextResource();
            zalbeNaOdluku.add((ZalbaNaOdluku) jaxB
                    .unmarshall(r.getContent().toString(), ZalbaNaOdluku.class, ZalbaNaOdluku.class));
        }
        return zalbeNaOdluku;
    }
}
