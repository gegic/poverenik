package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.generators.ZalbaCutanjeGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class ZalbaCutanjeService {

    private final ZalbaCutanjeRepository repository;
    private final JaxB jaxB;
    private final ZahtevSoapService zahtevSoapService;
    private final ZalbaCutanjeGenerator generator;

    @Autowired
    public ZalbaCutanjeService(ZalbaCutanjeRepository zalbaCutanjeRepository,
                               JaxB jaxB,
                               ZahtevSoapService zahtevSoapService,
                               ZalbaCutanjeGenerator generator) {
        this.repository = zalbaCutanjeRepository;
        this.jaxB = jaxB;
        this.zahtevSoapService = zahtevSoapService;
        this.generator = generator;
    }

    public String save(ZalbaCutanje zalbaCutanje) throws JAXBException {
        zalbaCutanje.setProperty("pred:zahtev");
        zalbaCutanje.setContent(zalbaCutanje.getZahtev().getId());
        zalbaCutanje.setTipResenja("neresena");
        ZalbaCutanje added = this.repository.save(zalbaCutanje);

        Zahtev z = this.zahtevSoapService.getById(added.getZahtev().getId());
        z.setPrihvatanje("zalba-cutanje");
        this.zahtevSoapService.saveZahtev(z);

        return added.getId();
    }

    public ZalbaCutanje getById(String id) throws ResourceNotFoundException {
        return repository.findById(id);
    }

    public List<ZalbaCutanje> getAll() throws Exception {
        return repository.getAll();
    }

    public List<ZalbaCutanje> getAllByKorisnikId(String id) throws Exception {
        return repository.getAllByKorisnikId(id);
    }

    public List<ZalbaCutanje> getAllNeresene() throws Exception {
        return repository.getAllNeresene();
    }

    public String generatePdf(String id) throws Exception {
        ZalbaCutanje z = repository.findById(id);
        return generator.generatePDF(z);
    }

    public String generateXhtml(String id) throws Exception {
        ZalbaCutanje z = repository.findById(id);
        return generator.generateXhtml(z);
    }
}
