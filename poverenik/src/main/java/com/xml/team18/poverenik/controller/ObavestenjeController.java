package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import com.xml.team18.poverenik.service.ObavestenjeSoapService;
import com.xml.team18.poverenik.service.ZahtevSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/obavestenja")
public class ObavestenjeController {

    ObavestenjeSoapService obavestenjeSoapService;

    @Autowired
    public ObavestenjeController(ObavestenjeSoapService obavestenjeSoapService) {
        this.obavestenjeSoapService = obavestenjeSoapService;
    }

    @GetMapping(path = "/zahtev/{zahtevId}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Obavestenje> getByZahtevId(@PathVariable String zahtevId) {
        return ResponseEntity.ok(this.obavestenjeSoapService.getByZahtevId(zahtevId));
    }

}
