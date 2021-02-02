package com.xml.team18.sluzbenik.repository;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.exist.ExistManager;
import com.xml.team18.sluzbenik.factory.GodisnjaStatistikaFactory;
import com.xml.team18.sluzbenik.factory.IzvestajFactory;
import com.xml.team18.sluzbenik.factory.KorisnikFactory;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.fuseki.FusekiWriter;
import com.xml.team18.sluzbenik.fuseki.MetadataExtractor;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
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
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
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
            return (Izvestaj) ((JAXBElement<?>) jaxB
                    .unmarshall(contentFound, Izvestaj.class, IzvestajFactory.class))
                    .getValue();
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createGodisnjaStatistika() {
        try {
            this.existManager.read(collectionId, "godisnja-statistika");
            return;
        } catch (ResourceNotFoundException ignored) {
        }
        GodisnjaStatistika godisnjaStatistika = new GodisnjaStatistika();
        godisnjaStatistika.setGodina(LocalDate.now().getYear());
        godisnjaStatistika.setZalbeNaOdluku(BigInteger.valueOf(0));
        godisnjaStatistika.setOdbijeniZahtevi(BigInteger.valueOf(0));
        godisnjaStatistika.setPrihvaceniZahtevi(BigInteger.valueOf(0));
        godisnjaStatistika.setZalbeCutanje(BigInteger.valueOf(0));
        this.saveGodisnjaStatistika(godisnjaStatistika);
    }

    public void saveGodisnjaStatistika(GodisnjaStatistika godisnjaStatistika) {
        String rawXml;
        try {
            rawXml = jaxB.marshall(godisnjaStatistika, GodisnjaStatistika.class, GodisnjaStatistikaFactory.class);
        } catch (JAXBException e) {
            return;
        }
        try {
            this.existManager.saveRaw(collectionId, "godisnja-statistika", rawXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GodisnjaStatistika getGodisnjaStatistika() throws Exception {
        String xml = this.existManager.read(collectionId, "godisnja-statistika").getContent().toString();
        return (GodisnjaStatistika) jaxB
                .unmarshall(xml, GodisnjaStatistika.class, GodisnjaStatistikaFactory.class);
    }

    public void resetGodisnjaStatistika() throws Exception {
        GodisnjaStatistika g = this.getGodisnjaStatistika();
        g.setGodina(LocalDate.now().getYear());
        g.setZalbeNaOdluku(BigInteger.valueOf(0));
        g.setOdbijeniZahtevi(BigInteger.valueOf(0));
        g.setPrihvaceniZahtevi(BigInteger.valueOf(0));
        g.setZalbeCutanje(BigInteger.valueOf(0));
        this.saveGodisnjaStatistika(g);
    }

    public void zahtevPrihvacen() throws Exception {
        GodisnjaStatistika g = this.getGodisnjaStatistika();
        g.setPrihvaceniZahtevi(g.getPrihvaceniZahtevi().add(BigInteger.ONE));
        this.saveGodisnjaStatistika(g);
    }

    public void zahtevOdbijen() throws Exception {
        GodisnjaStatistika g = this.getGodisnjaStatistika();
        g.setOdbijeniZahtevi(g.getOdbijeniZahtevi().add(BigInteger.ONE));
        this.saveGodisnjaStatistika(g);
    }

    public void zalbaCutanjePodneta() throws Exception {
        GodisnjaStatistika g = this.getGodisnjaStatistika();
        g.setZalbeCutanje(g.getZalbeCutanje().add(BigInteger.ONE));
        this.saveGodisnjaStatistika(g);
    }

    public void zalbaNaOdlukuPodneta() throws Exception {
        GodisnjaStatistika g = this.getGodisnjaStatistika();
        g.setZalbeNaOdluku(g.getZalbeNaOdluku().add(BigInteger.ONE));
        this.saveGodisnjaStatistika(g);
    }

    public List<Izvestaj> getAll() throws Exception {
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
