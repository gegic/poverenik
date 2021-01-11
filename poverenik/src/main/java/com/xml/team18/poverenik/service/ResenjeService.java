package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
import com.xml.team18.poverenik.repository.ResenjeRepository;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenjeService implements PoverenikService<Resenje> {
    private final ResenjeRepository repository;

    @Autowired
    public ResenjeService(ResenjeRepository resenjeRepository) {
        this.repository = resenjeRepository;
    }

    public Resenje save(Resenje r) {
        return this.repository.save(r);
    }
}
