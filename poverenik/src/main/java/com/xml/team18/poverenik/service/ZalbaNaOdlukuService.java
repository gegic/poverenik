package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.generators.ZalbaNaOdlukuGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class ZalbaNaOdlukuService {

    private final ZalbaNaOdlukuRepository repository;
    private final JaxB jaxB;
    private final ZahtevSoapService zahtevSoapService;
    private final ZalbaNaOdlukuGenerator generator;

    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository zalbaNaOdlukuRepository,
                               JaxB jaxB,
                               ZahtevSoapService zahtevSoapService,
                               ZalbaNaOdlukuGenerator generator) {
        this.repository = zalbaNaOdlukuRepository;
        this.jaxB = jaxB;
        this.zahtevSoapService = zahtevSoapService;
        this.generator = generator;
    }

    public String save(ZalbaNaOdluku zalbaNaOdluku) throws JAXBException {
        zalbaNaOdluku.setProperty("pred:zahtev");
        zalbaNaOdluku.setContent(zalbaNaOdluku.getZahtev().getId());
        zalbaNaOdluku.setTipResenja("neresena");
        ZalbaNaOdluku added = this.repository.save(zalbaNaOdluku);

        Zahtev z = this.zahtevSoapService.getById(added.getZahtev().getId());
        z.setPrihvatanje("zalba-na-odluku");
        this.zahtevSoapService.saveZahtev(z);

        return added.getId();
    }

    public ZalbaNaOdluku getById(String id) throws ResourceNotFoundException {
        return repository.findById(id);
    }

    public List<ZalbaNaOdluku> getAll() throws Exception {
        return repository.getAll();
    }

    public List<ZalbaNaOdluku> getAllByKorisnikId(String id) throws Exception {
        return repository.getAllByKorisnikId(id);
    }

    public List<ZalbaNaOdluku> getAllNeresene() throws Exception {
        return repository.getAllNeresene();
    }

    public String generatePdf(String id) throws Exception {
        ZalbaNaOdluku z = repository.findById(id);
        return generator.generatePDF(z);
    }

    public String generateXhtml(String id) throws Exception {
        ZalbaNaOdluku z = repository.findById(id);
        return generator.generateXhtml(z);
    }
}
