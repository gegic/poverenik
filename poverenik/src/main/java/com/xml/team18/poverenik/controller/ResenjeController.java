package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.service.ResenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/resenja")
public class ResenjeController {

    private final ResenjeService service;

    @Autowired
    public ResenjeController(ResenjeService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<String> addResenje(@RequestBody Resenje resenje) throws ResourceNotFoundException {
        return ResponseEntity.created(URI.create(this.service.save(resenje))).build();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Resenje> getById(@PathVariable String id) throws ResourceNotFoundException, JAXBException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<EntityList<Resenje>> getAll() throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.getAll()));
    }

    @GetMapping(path = "korisnik/{korisnikId}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<EntityList<Resenje>> getByKorisnikId(@PathVariable String korisnikId) throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.getByKorisnikId(korisnikId)));
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
