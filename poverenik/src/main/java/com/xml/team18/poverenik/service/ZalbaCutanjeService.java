package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZalbaCutanjeService implements PoverenikService<Zalba> {

    private final ZalbaCutanjeRepository repository;

    @Autowired
    public ZalbaCutanjeService(ZalbaCutanjeRepository zalbaCutanjeRepository) {
        this.repository = zalbaCutanjeRepository;
    }

    public Zalba save(Zalba z) {
        return this.repository.save(z);
    }
}
