package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.service.ObavestenjeSoapService;
import com.xml.team18.poverenik.service.ZahtevSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Obavestenje> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.obavestenjeSoapService.getById(id));
    }

    @PostMapping(value = "/generate-pdf/{id}")
    public ResponseEntity<String> generatePDFObavestenje(@PathVariable String id) {
        try {
            String path = obavestenjeSoapService.generatePdf(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/generate-xhtml/{id}")
    public ResponseEntity<String> generateXhtmlObavestenje(@PathVariable String id) {
        try {
            String path = obavestenjeSoapService.generateXhtml(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
