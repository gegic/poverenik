package com.xml.team18.sluzbenik.controller;

import com.xml.team18.sluzbenik.dto.EntityList;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.ListaZalbiNaOdluku;
import com.xml.team18.sluzbenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.ListaZalbiCutanje;
import com.xml.team18.sluzbenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.sluzbenik.service.ZalbaSoapService;
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

    private final ZalbaSoapService service;

    @Autowired
    public ZalbaNaOdlukuController(ZalbaSoapService service) {
        this.service = service;
    }


    @GetMapping(path = "/{id}")
    ResponseEntity<ZalbaNaOdluku> getById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getByIdZalbaNaOdluku(id));
    }

    @PostMapping(value = "/generate-pdf/{id}")
    public ResponseEntity<String> generatePDF(@PathVariable String id) {
        try {
            String path = service.generatePdfZalbaNaOdluku(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/generate-xhtml/{id}")
    public ResponseEntity<String> generateXhtml(@PathVariable String id) {
        try {
            String path = service.generateXhtmlZalbaNaOdluku(id);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/napredna-pretraga", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ListaZalbiNaOdluku> naprednaPretraga(@RequestParam String upit) throws Exception {
        return ResponseEntity.ok(service.pretragaZalbaNaOdluku(upit));
    }
}
