package com.xml.team18.poverenik.utils;

import com.xml.team18.poverenik.model.korisnik.Korisnik;
import com.xml.team18.poverenik.repository.KorisnikRepository;
import com.xml.team18.poverenik.service.KorisnikService;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PoverenikInit {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void postConstruct() {
        Korisnik found = korisnikRepository.findByEmail("poverenik@mail.com");
        if (found != null) {
            return;
        }
        Korisnik k = new Korisnik("Poverenik Poverenikic",
                "poverenik@mail.com",
                passwordEncoder.encode("admin123"),
                "poverenik",
                "pv1");
        korisnikRepository.save(k);
    }
}
