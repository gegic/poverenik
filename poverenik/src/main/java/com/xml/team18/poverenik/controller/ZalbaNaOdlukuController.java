package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.service.ZalbaNaOdlukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/zalbe-na-odluku",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class ZalbaNaOdlukuController {

    private final ZalbaNaOdlukuService service;

    @Autowired
    public ZalbaNaOdlukuController(ZalbaNaOdlukuService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<String> addZalbaNaOdluku(@RequestBody ZalbaNaOdluku zalbaNaOdluku) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(zalbaNaOdluku))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<ZalbaNaOdluku> getById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(path = "/korisnik/{korisnikId}")
    ResponseEntity<EntityList<ZalbaNaOdluku>> getAllByKorisnikId(@PathVariable String korisnikId) throws Exception {
        return ResponseEntity.ok(
                new EntityList<>(service.getAllByKorisnikId(korisnikId)));
    }

    @GetMapping(path = "/neresene")
    ResponseEntity<EntityList<ZalbaNaOdluku>> getAllNeresene() throws Exception {
        return ResponseEntity.ok(
                new EntityList<>(service.getAllNeresene()));
    }

    @PostMapping(value = "/generate-pdf/{id}")
    public ResponseEntity<String> generatePDF(@PathVariable String id) {
        try {
            String path = service.generatePdf(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/generate-xhtml/{id}")
    public ResponseEntity<String> generateXhtml(@PathVariable String id) {
        try {
            String path = service.generateXhtml(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
