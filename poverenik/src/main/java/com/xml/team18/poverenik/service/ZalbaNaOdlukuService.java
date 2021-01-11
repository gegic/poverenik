package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.zalba.na.odluku.Zalba;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import com.xml.team18.poverenik.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZalbaNaOdlukuService implements PoverenikService<Zalba> {
    private final ZalbaNaOdlukuRepository repository;

    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository zalbaNaOdlukuRepository) {
        this.repository = zalbaNaOdlukuRepository;
    }

    public Zalba save(Zalba z) {
        return this.repository.save(z);
    }
}
