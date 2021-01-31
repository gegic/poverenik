package com.xml.team18.sluzbenik.utils;

import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.repository.KorisnikRepository;
import com.xml.team18.sluzbenik.service.KorisnikService;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SluzbenikInit {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void postConstruct() {
        Korisnik found = korisnikRepository.findByEmail("sluzbenik@mail.com");
        if (found != null) {
            return;
        }
        Korisnik k = new Korisnik("Sluzbenik sluzbenikic",
                "sluzbenik@mail.com",
                passwordEncoder.encode("admin123"),
                "sluzbenik",
                "sl1");
        korisnikRepository.save(k);
    }
}
