package com.xml.team18.sluzbenik.controller;

import com.xml.team18.sluzbenik.dto.PrijavaDto;
import com.xml.team18.sluzbenik.dto.TokenOdgovor;
import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.service.KorisnikService;
import com.xml.team18.sluzbenik.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_XML_VALUE)
public class AuthController {
    @Autowired
    KorisnikService korisnikService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(value = "/prijava", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody PrijavaDto authenticationRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(), authenticationRequest.getLozinka()));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Pogrešan e-mail ili lozinka.", HttpStatus.UNAUTHORIZED);
        }

        Korisnik korisnik = (Korisnik) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = TokenUtils.generateToken(korisnik);

        return ResponseEntity.ok(new TokenOdgovor(jwt, korisnik));
    }

    @PostMapping(value = "/registracija", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addUser(@Valid @RequestBody Korisnik userRequest) throws Exception {
        Korisnik existEmail = this.korisnikService.loadUserByUsername(userRequest.getEmail());
        if (existEmail != null) {
            return new ResponseEntity<>("Već postoji korisnik sa unetim e-mailom.", HttpStatus.CONFLICT);
        }
        Korisnik noviKorisnik;
        try {
            noviKorisnik = korisnikService.save(userRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        noviKorisnik.setLozinka(null);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }

}
