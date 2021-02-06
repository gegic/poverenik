package com.xml.team18.sluzbenik.controller;

import com.xml.team18.sluzbenik.dto.EntityList;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/zahtevi",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class ZahtevController {

    private final ZahtevService service;

    @Autowired
    public ZahtevController(ZahtevService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<String> addZahtev(@RequestBody Zahtev zahtev) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(zahtev))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Zahtev> getById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    ResponseEntity<EntityList<Zahtev>> getAll() throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.getAll()));
    }

    @GetMapping(path = "/pretraga")
    ResponseEntity<EntityList<Zahtev>> pretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.pretraga(upit)));
    }

    @GetMapping(path = "/napredna-pretraga")
    ResponseEntity<EntityList<Zahtev>> naprednaPretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.naprednaPretraga(upit)));
    }

    @GetMapping(path = "/korisnik/{korisnikId}")
    ResponseEntity<EntityList<Zahtev>> getAllByKorisnikId(@PathVariable String korisnikId) throws Exception {
        return ResponseEntity.ok(
                new EntityList<Zahtev>(service.getAllByKorisnikId(korisnikId)));
    }

    @GetMapping(path = "/neodgovoreni")
    ResponseEntity<EntityList<Zahtev>> getAllNeodgovoreni() throws Exception {
        return ResponseEntity.ok(
                new EntityList<Zahtev>(service.getAllNeodgovoreni()));
    }

    @PostMapping(value = "/generate-pdf/{id}")
    public ResponseEntity<String> generatePDFZahtev(@PathVariable String id) {
        try {
            String path = service.generatePdfZahtev(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/generate-xhtml/{id}")
    public ResponseEntity<String> generateXhtmlZahtev(@PathVariable String id) {
        try {
            String path = service.generateXhtmlZahtev(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping(value = "/odbij/{id}")
    public ResponseEntity<Zahtev> odbij(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.odbij(id));
    }

    @PostMapping(value = "/generate-json/{id}")
    public String getJsonById(@PathVariable String id) throws FileNotFoundException {
        return service.getJsonById(id);
    }

    @PostMapping(value = "/generate-rdf/{id}")
    public String getRdfById(@PathVariable String id) throws FileNotFoundException {
        return service.getRdfById(id);
    }
}
