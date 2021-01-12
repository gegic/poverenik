package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.UUID;

@Service
public class ZahtevService implements PoverenikService<Zahtev> {
    private final ZahtevRepository repository;
    private final JaxB jaxB;

    @Autowired
    public ZahtevService(ZahtevRepository zahtevRepository,
                         JaxB jaxB) {
        this.repository = zahtevRepository;
        this.jaxB = jaxB;
    }

    public String save(String zahtevXml) throws JAXBException {
        Zahtev z = (Zahtev) ((JAXBElement<?>) this.jaxB.unmarshall(zahtevXml, Zahtev.class, ZahtevFactory.class)).getValue();
        z = this.repository.save(z);
        return z.getId();
    }

    @Override
    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Zahtev found = repository.findById(UUID.fromString(id));
        JAXBElement<Zahtev> element = new JAXBElement<Zahtev>(QName.valueOf("zahtev"), Zahtev.class, found);
        return jaxB.marshall(element, Zahtev.class, ZahtevFactory.class);
    }
}
