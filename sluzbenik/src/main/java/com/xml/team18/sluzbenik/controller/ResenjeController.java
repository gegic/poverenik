package com.xml.team18.sluzbenik.controller;

import com.xml.team18.sluzbenik.dto.EntityList;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.ListaResenja;
import com.xml.team18.sluzbenik.model.resenje.Resenje;
import com.xml.team18.sluzbenik.service.ResenjeSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/resenja")
public class ResenjeController {

    private final ResenjeSoapService service;

    @Autowired
    public ResenjeController(ResenjeSoapService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Resenje> getById(@PathVariable String id) throws ResourceNotFoundException, JAXBException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(path = "/napredna-pretraga", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ListaResenja> pretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(service.pretraga(upit));
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
