package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.ListaZahteva;
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
@RequestMapping(path = "/api/zahtevi")
public class ZahtevController {

    ZahtevSoapService zahtevSoapService;

    @Autowired
    public ZahtevController(ZahtevSoapService zahtevSoapService) {
        this.zahtevSoapService = zahtevSoapService;
    }

    @GetMapping(path = "/neodgovoreni/{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ListaZahteva> getNeodgovoreniById(@PathVariable String idKorisnika) {
        return ResponseEntity.ok(this.zahtevSoapService.neodgovoreniZahtevi(idKorisnika));
    }

    @GetMapping(path = "/odbijeni/{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ListaZahteva> getOdbijeniById(@PathVariable String idKorisnika) {
        return ResponseEntity.ok(this.zahtevSoapService.odbijeniZahtevi(idKorisnika));
    }

}
