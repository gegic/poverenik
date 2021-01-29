package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.korisnik.Korisnik;
import com.xml.team18.poverenik.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.xml.bind.JAXBException;

public class KorisnikService implements PoverenikService<Korisnik>, UserDetailsService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public String save(String rawXml) throws JAXBException {
        return null;
    }

    @Override
    public String getById(String id) throws ResourceNotFoundException, JAXBException {
        return null;
    }

    @Override
    public Korisnik loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return korisnikRepository.findByEmail(email);
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException(email);
        }
    }
}
