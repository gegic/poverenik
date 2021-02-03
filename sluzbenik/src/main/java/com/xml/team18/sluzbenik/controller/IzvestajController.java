package com.xml.team18.sluzbenik.controller;


import com.xml.team18.sluzbenik.dto.EntityList;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.service.IzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/izvestaji",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class IzvestajController {

    private final IzvestajService service;

    @Autowired
    public IzvestajController(IzvestajService service) {
        this.service = service;
    }

    @GetMapping(path = "godisnja-statistika")
    ResponseEntity<GodisnjaStatistika> generateEmpty() throws Exception {
        return ResponseEntity.ok(service.getStatistika());
    }

    @PostMapping
    ResponseEntity<String> addIzvestaj(@RequestBody Izvestaj izvestaj) throws Exception {
        return ResponseEntity.created(URI.create(this.service.save(izvestaj))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Izvestaj> getById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    ResponseEntity<EntityList<Izvestaj>> getAll() throws Exception {
        return ResponseEntity.ok(new EntityList<>(service.getAll()));
    }

    @PostMapping(value = "/generate-pdf/{id}")
    public ResponseEntity<String> generatePDFIzvestaj(@PathVariable String id) {
        try {
            String path = service.generatePdfIzvestaj(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/generate-xhtml/{id}")
    public ResponseEntity<String> generateXhtmlIzvestaj(@PathVariable String id) {
        try {
            String path = service.generateXhtmlIzvestaj(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
