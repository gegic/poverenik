package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.service.ZalbaCutanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/zalbe-cutanje",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class ZalbaCutanjeController {

    private final ZalbaCutanjeService service;

    @Autowired
    public ZalbaCutanjeController(ZalbaCutanjeService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<String> addZalbaCutanje(@RequestBody ZalbaCutanje zalbaCutanje) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(zalbaCutanje))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<ZalbaCutanje> getById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(path = "/korisnik/{korisnikId}")
    ResponseEntity<EntityList<ZalbaCutanje>> getAllByKorisnikId(@PathVariable String korisnikId) throws Exception {
        return ResponseEntity.ok(
                new EntityList<>(service.getAllByKorisnikId(korisnikId)));
    }

    @GetMapping(path = "/neresene")
    ResponseEntity<EntityList<ZalbaCutanje>> getAllNeresene() throws Exception {
        return ResponseEntity.ok(
                new EntityList<ZalbaCutanje>(service.getAllNeresene()));
    }


    @GetMapping
    ResponseEntity<EntityList<ZalbaCutanje>> getAll() throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.getAll()));
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

    @GetMapping(path = "/pretraga", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<EntityList<ZalbaCutanje>> pretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.pretraga(upit)));
    }

    @GetMapping(path = "/napredna-pretraga", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<EntityList<ZalbaCutanje>> naprednaPretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.naprednaPretraga(upit)));
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
