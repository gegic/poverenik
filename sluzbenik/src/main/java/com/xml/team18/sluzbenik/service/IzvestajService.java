package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.generators.IzvestajGenerator;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.IzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class IzvestajService {
    private final IzvestajRepository repository;
    private final JaxB jaxB;
    private final IzvestajGenerator izvestajGenerator;
    private final IzvestajSoapService izvestajSoapService;

    @Autowired
    public IzvestajService(IzvestajRepository izvestajRepository,
                           JaxB jaxB,
                           IzvestajGenerator generator,
                           IzvestajSoapService izvestajSoapService) {
        this.repository = izvestajRepository;
        this.jaxB = jaxB;
        this.izvestajGenerator = generator;
        this.izvestajSoapService = izvestajSoapService;
    }

    public String save(Izvestaj z) throws Exception {
        z = this.repository.save(z);
        this.izvestajSoapService.podnesiIzvestaj(z);
        this.repository.resetGodisnjaStatistika();
        return z.getId();
    }

    public Izvestaj getById(String id) throws Exception {
        return repository.findById(id);
    }

    public List<Izvestaj> getAll() throws Exception {
        return repository.getAll();
    }

    public List<Izvestaj> pretraga(String query) throws Exception {
        return repository.pretraga(query);
    }

    public GodisnjaStatistika getStatistika() throws Exception {
        return this.repository.getGodisnjaStatistika();
    }

    public String generatePdfIzvestaj(String id) throws Exception {
        Izvestaj z = repository.findById(id);
        return izvestajGenerator.generatePDF(z);
    }

    public String generateXhtmlIzvestaj(String id) throws Exception {
        Izvestaj z = repository.findById(id);
        return izvestajGenerator.generateXhtml(z);
    }
}
