package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.UUID;

@Service
public class ZalbaCutanjeService implements PoverenikService<Zalba> {

    private final ZalbaCutanjeRepository repository;
    private final JaxB jaxB;

    @Autowired
    public ZalbaCutanjeService(ZalbaCutanjeRepository zalbaCutanjeRepository,
                               JaxB jaxB) {
        this.repository = zalbaCutanjeRepository;
        this.jaxB = jaxB;
    }

    public String save(String zalbaXml) throws JAXBException {
        Zalba z = (Zalba) ((JAXBElement<?>) this.jaxB.unmarshall(zalbaXml, Zalba.class, ZalbaCutanjeFactory.class)).getValue();
        z = this.repository.save(z);
        return z.getId();
    }

    @Override
    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        Zalba found = repository.findById(id);
        JAXBElement<Zalba> element = new JAXBElement<Zalba>(QName.valueOf("zalba-cutanje"), Zalba.class, found);
        return jaxB.marshall(element, Zalba.class, ZalbaCutanjeFactory.class);
    }
}
