package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.factory.ZahtevFactory;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.List;

@Service
public class ZahtevService {
    private final ZahtevRepository repository;
    private final JaxB jaxB;

    @Autowired
    public ZahtevService(ZahtevRepository zahtevRepository,
                         JaxB jaxB) {
        this.repository = zahtevRepository;
        this.jaxB = jaxB;
    }

    public String save(Zahtev z) throws JAXBException {
        z = this.repository.save(z);
        return z.getId();
    }

    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Zahtev found = repository.findById(id);
        return jaxB.marshall(found, Zahtev.class, ZahtevFactory.class);
    }

    public List<Zahtev> getAll() throws Exception {
        return repository.getAll();
    }
}
