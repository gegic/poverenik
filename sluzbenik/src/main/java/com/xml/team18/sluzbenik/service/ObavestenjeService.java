package com.xml.team18.sluzbenik.service;


import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.factory.ObavestenjeFactory;
import com.xml.team18.sluzbenik.generators.ObavestenjeGenerator;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.obavestenje.Obavestenje;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.ObavestenjeRepository;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.UUID;

@Service
public class ObavestenjeService {
    private final ObavestenjeRepository repository;
    private final ZahtevRepository zahtevRepository;
    private final JaxB jaxB;
    private final ObavestenjeGenerator obavestenjeGenerator;

    @Autowired
    public ObavestenjeService(ObavestenjeRepository obavestenjeRepository,
                              JaxB jaxB,
                              ZahtevRepository zahtevRepository,
                              ObavestenjeGenerator obavestenjeGenerator) {
        this.repository = obavestenjeRepository;
        this.jaxB = jaxB;
        this.zahtevRepository = zahtevRepository;
        this.obavestenjeGenerator = obavestenjeGenerator;
    }

    public String save(Obavestenje obavestenje) throws JAXBException, ResourceNotFoundException {
        Zahtev z = zahtevRepository.findById(obavestenje.getZahtev().getId());
        obavestenje.setProperty("pred:zahtev-obavestenja");
        obavestenje.setContent(obavestenje.getZahtev().getId());
        Obavestenje o = this.repository.save(obavestenje);
        z.setPrihvatanje("prihvacen");
        zahtevRepository.save(z);
        return o.getId();
    }

    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Obavestenje found = repository.findById(id);
        JAXBElement<Obavestenje> element = new JAXBElement<Obavestenje>(QName.valueOf("obavestenje"), Obavestenje.class, found);
        return jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
    }

    public List<Obavestenje> getAllByKorisnikId(String korisnikId) throws Exception {
        return repository.getAllByKorisnikId(korisnikId);
    }

    public List<Obavestenje> getAll() throws Exception {
        return repository.getAll();
    }


    public String generatePdf(String id) throws Exception {
        Obavestenje o = repository.findById(id);
        return obavestenjeGenerator.generatePDF(o);
    }

    public String generateXhtml(String id) throws Exception {
        Obavestenje o = repository.findById(id);
        return obavestenjeGenerator.generateXhtml(o);
    }
}
