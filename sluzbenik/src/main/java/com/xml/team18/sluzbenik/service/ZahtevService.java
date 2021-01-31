package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.generators.ZahtevGenerator;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        z = this.repository.save(z);
        return z.getId();
    }

    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Zahtev found = repository.findById(id);
        return jaxB.marshall(found, Zahtev.class, ZahtevFactory.class);
    }

    public List<Zahtev> getAll(String id) throws Exception {
        return repository.getAllByKorisnikId(id);
    }

    public List<Zahtev> getAllNeodgovoreni() throws Exception {
        return repository.getAllNeodgovoreni();
    }

    public String generatePdfZahtev(String id) throws Exception {
        Zahtev z = repository.findById(id);
        return zahtevGenerator.generatePDF(z);
    }

    public String generateXhtmlZahtev(String id) throws Exception {
        Zahtev z = repository.findById(id);
        return zahtevGenerator.generateXhtml(z);
    }
}
