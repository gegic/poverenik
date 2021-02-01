package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.service.ZahtevSoapService;
import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URI;

@RestController
@RequestMapping(path = "/auth/zahtevi")
public class ZahtevController {

    ZahtevSoapService zahtevSoapService;

    @Autowired
    public ZahtevController(ZahtevSoapService zahtevSoapService) {
        this.zahtevSoapService = zahtevSoapService;
    }

    @GetMapping(path = "/neodgovoreniZahtevi/{idKorisnika}")
    ResponseEntity<Zahtev> getById(@PathVariable String idKorisnika) throws ResourceNotFoundException, MalformedURLException {
        this.zahtevSoapService.neodgovoreniZahtevi(idKorisnika);
        return ResponseEntity.noContent().build();
    }
}
