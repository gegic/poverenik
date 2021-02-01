package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.repository.ResenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.UUID;

@Service
public class ResenjeService implements PoverenikService<Resenje> {
    private final ResenjeRepository repository;
    private final JaxB jaxB;

    @Autowired
    public ResenjeService(ResenjeRepository resenjeRepository,
                          JaxB jaxB) {
        this.repository = resenjeRepository;
        this.jaxB = jaxB;
    }

    public String save(String resenjeXml) throws JAXBException {
        Resenje r = (Resenje) ((JAXBElement<?>) this.jaxB.unmarshall(resenjeXml, Resenje.class, ResenjeFactory.class)).getValue();
        r = this.repository.save(r);
        return r.getId();
    }

    @Override
    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Resenje found = repository.findById(id);
        JAXBElement<Resenje> element = new JAXBElement<Resenje>(QName.valueOf("resenje"), Resenje.class, found);
        return jaxB.marshall(element, Resenje.class, ResenjeFactory.class);
    }
}
