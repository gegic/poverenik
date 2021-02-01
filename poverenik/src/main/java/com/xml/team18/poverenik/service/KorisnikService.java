package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceExistsException;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.korisnik.Korisnik;
import com.xml.team18.poverenik.repository.KorisnikRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class KorisnikService implements UserDetailsService {

    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository,
                           PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Korisnik save(Korisnik korisnik) throws ResourceExistsException {
        Korisnik k = korisnikRepository.findByEmail(korisnik.getEmail());

        if (k != null) {
            throw new ResourceExistsException(korisnik.getClass().getName(), korisnik.getEmail());
        }

        korisnik.setUloga("gradjanin");
        korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));

        return this.korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik loadUserByUsername(String email) throws UsernameNotFoundException {
        Korisnik k = korisnikRepository.findByEmail(email);
        if (k == null) {
            throw new UsernameNotFoundException(email);
        }
        return k;
    }
}
