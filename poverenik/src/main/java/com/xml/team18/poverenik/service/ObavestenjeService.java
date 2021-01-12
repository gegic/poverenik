package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.repository.ObavestenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.UUID;

@Service
public class ObavestenjeService implements PoverenikService<Obavestenje> {
    private final ObavestenjeRepository repository;
    private final JaxB jaxB;

    @Autowired
    public ObavestenjeService(ObavestenjeRepository obavestenjeRepository,
                              JaxB jaxB) {
        this.repository = obavestenjeRepository;
        this.jaxB = jaxB;
    }

    public String save(String obavestenjeXml) throws JAXBException {
        Obavestenje r = (Obavestenje) ((JAXBElement<?>) this.jaxB.unmarshall(obavestenjeXml, Obavestenje.class, ObavestenjeFactory.class)).getValue();
        r = this.repository.save(r);
        JAXBElement<Obavestenje> element = new JAXBElement<Obavestenje>(QName.valueOf("obavestenje"), Obavestenje.class, r);
        return jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
    }

    @Override
    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Obavestenje found = repository.findById(UUID.fromString(id));
        JAXBElement<Obavestenje> element = new JAXBElement<Obavestenje>(QName.valueOf("obavestenje"), Obavestenje.class, found);
        return jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
    }
}
