package com.xml.team18.sluzbenik.repository;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.exist.ExistManager;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.fuseki.FusekiWriter;
import com.xml.team18.sluzbenik.fuseki.MetadataExtractor;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class ZahtevRepository implements XmlRepository<Zahtev> {
    private final String collectionId = "/db/zahtevi";

    private final ExistManager existManager;
    private final MetadataExtractor metadataExtractor;
    private final FusekiWriter fusekiWriter;
    private final JaxB jaxB;

    @Autowired
    public ZahtevRepository(ExistManager existManager,
                            MetadataExtractor metadataExtractor,
                            FusekiWriter fusekiWriter,
                            JaxB jaxB) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
        this.fusekiWriter = fusekiWriter;
        this.jaxB = jaxB;
    }

    public Zahtev save(Zahtev z) {
        try {
            String id = z.getId();
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                z.setId(id);
            }
            Korisnik k = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            z.setVocab("http://team14.xml.com/rdf/zahtevi/predicate/");
            z.setAbout("http://team14.xml.com/rdf/zahtevi/" + id);
            z.getOrgan().getAdresa().getMesto().setProperty("pred:mesto-ustanove");
            z.getOrgan().getAdresa().getMesto().setDatatype("xs:string");
            z.getOrgan().getNaziv().setProperty("pred:naziv-ustanove");
            z.getOrgan().getNaziv().setDatatype("xs:string");
            z.getOpisZahteva().setProperty("pred:opis-zahteva");
            z.getOpisZahteva().setDatatype("xs:string");
            z.getMesto().setProperty("pred:mesto-zahteva");
            z.getMesto().setDatatype("xs:string");
            z.getDatum().setProperty("pred:datum-zahteva");
            z.getMesto().setDatatype("xs:date");
            z.getTrazilacInformacije().getAdresa().getMesto().setProperty("pred:mesto-trazioca");
            z.getTrazilacInformacije().getAdresa().getMesto().setDatatype("xs:string");
            z.getTrazilacInformacije().getAdresa().getUlica().setProperty("pred:ulica-trazioca");
            z.getTrazilacInformacije().getAdresa().getUlica().setDatatype("xs:string");
            z.getTrazilacInformacije().getImePrezime().setProperty("pred:ime-prezime-trazioca");
            z.getTrazilacInformacije().getImePrezime().setDatatype("xs:string");
            z.getTrazilacInformacije().setId(k.getId());

            JAXBElement<Zahtev> element = new JAXBElement<Zahtev>(QName.valueOf("zahtev"), Zahtev.class, z);
            String rawXml = jaxB.marshall(element, Zahtev.class, ZahtevFactory.class);
            this.existManager.saveRaw(collectionId, id, rawXml);
            String rdf = this.metadataExtractor.extractMetadata(rawXml);
            String graphUri = String.format("zahtevi/%s", id);
            this.fusekiWriter.saveRDF(rdf, graphUri);
            XMLResource found = this.existManager.read(collectionId, id);
            String contentFound = found.getContent().toString();
            return (Zahtev) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zahtev.class, ZahtevFactory.class))
                    .getValue();
        } catch (Exception e) {
            System.out.println("Not saved due to");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }


    public Zahtev findById(String id) throws ResourceNotFoundException {
        XMLResource found = this.existManager.read(collectionId, id);
        String contentFound;
        try {
            contentFound = found.getContent().toString();
            return (Zahtev) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Zahtev.class, ZahtevFactory.class))
                    .getValue();
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Zahtev> getAll() throws Exception {
        return this.existManager.readAll(collectionId).stream().map(con -> {
            try {
                return (Zahtev) ((JAXBElement<?>) jaxB
                        .unmarshall(con, Zahtev.class, ZahtevFactory.class))
                        .getValue();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    private String checkForId(String xmlZahtev) throws JAXBException {
        Zahtev z = (Zahtev) ((JAXBElement<?>) jaxB
                .unmarshall(xmlZahtev, Zahtev.class, ZahtevFactory.class))
                .getValue();
        return z.getId();
    }
}
