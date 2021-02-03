package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.generators.ZahtevGenerator;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.IzvestajRepository;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class ZahtevService {
    private final ZahtevRepository repository;
    private final JaxB jaxB;
    private final ZahtevGenerator zahtevGenerator;
    @Autowired
    public ZahtevService(ZahtevRepository zahtevRepository,
                         JaxB jaxB,
                         ZahtevGenerator generator) {
        this.repository = zahtevRepository;
        this.jaxB = jaxB;
        this.zahtevGenerator = generator;
    }

    public String save(Zahtev z) throws JAXBException {
        z.setPrihvatanje("neodgovoren");
        Korisnik k = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        z.getTrazilacInformacije().setId(k.getId());
        z.setProperty("pred:trazilac");
        z.setContent(k.getId());
        z = this.repository.save(z);
        return z.getId();
    }

    public Zahtev getById(String id) throws ResourceNotFoundException {
        return repository.findById(id);
    }

    public int count(String prihvatanje) {
        return repository.count(prihvatanje);
    }

    public List<Zahtev> getAllByKorisnikId(String id) throws Exception {
        return repository.getAllByKorisnikId(id);
    }

    public List<Zahtev> getAll() throws Exception {
        return repository.getAll();
    }

    public List<Zahtev> getAllNeodgovoreni() throws Exception {
        return repository.getAllNeodgovoreni();
    }

    public List<Zahtev> pretraga(String query) throws Exception {
        return repository.pretraga(query);
    }

    public String generatePdfZahtev(String id) throws Exception {
        Zahtev z = repository.findById(id);
        return zahtevGenerator.generatePDF(z);
    }

    public String generateXhtmlZahtev(String id) throws Exception {
        Zahtev z = repository.findById(id);
        return zahtevGenerator.generateXhtml(z);
    }

    public Zahtev odbij(String id) throws ResourceNotFoundException {
        Zahtev z = repository.findById(id);
        z.setPrihvatanje("odbijen");
        return repository.save(z);
    }

    public List<Zahtev> naprednaPretraga(String upit) {
        return repository.naprednaPretraga(upit);
    }
}
