package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.generators.IzvestajGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.poverenik.model.izvestaj.Izvestaj;
import com.xml.team18.poverenik.repository.IzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzvestajService {
    private final IzvestajRepository repository;
    private final JaxB jaxB;
    private final IzvestajGenerator izvestajGenerator;

    @Autowired
    public IzvestajService(IzvestajRepository izvestajRepository,
                           JaxB jaxB,
                           IzvestajGenerator generator) {
        this.repository = izvestajRepository;
        this.jaxB = jaxB;
        this.izvestajGenerator = generator;
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

    public String generatePdfIzvestaj(String id) throws Exception {
        Izvestaj z = repository.findById(id);
        return izvestajGenerator.generatePDF(z);
    }

    public String generateXhtmlIzvestaj(String id) throws Exception {
        Izvestaj z = repository.findById(id);
        return izvestajGenerator.generateXhtml(z);
    }
}
