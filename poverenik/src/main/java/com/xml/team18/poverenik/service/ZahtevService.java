package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevService implements PoverenikService<Zahtev> {
    private final ZahtevRepository repository;

    @Autowired
    public ZahtevService(ZahtevRepository zahtevRepository) {
        this.repository = zahtevRepository;
    }

    public Zahtev save(Zahtev r) {
        return this.repository.save(r);
    }
}
