package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.service.ZalbaCutanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
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
}
