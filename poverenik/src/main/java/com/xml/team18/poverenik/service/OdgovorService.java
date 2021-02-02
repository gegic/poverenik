package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.generators.ZalbaCutanjeGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.repository.OdgovorRepository;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class OdgovorService {

    private final OdgovorRepository repository;
    private final JaxB jaxB;

    @Autowired
    public OdgovorService(OdgovorRepository odgovorRepository,
                          JaxB jaxB) {
        this.repository = odgovorRepository;
        this.jaxB = jaxB;
    }

    public String save(OdgovorIzjasnjenje odgovor) {
        OdgovorIzjasnjenje added = this.repository.save(odgovor);
        return added.getId();
    }


    public List<OdgovorIzjasnjenje> getAll() throws Exception {
        return repository.getAll();
    }

    public OdgovorIzjasnjenje getByIdZalbe(String idZalbe) {
        return repository.getByIdZalbe(idZalbe);
    }
}
