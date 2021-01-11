package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.cutanje.Zalba;
import com.xml.team18.poverenik.service.ZalbaCutanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/zalba-cutanje",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class ZalbaCutanjeController {

    private final ZalbaCutanjeService service;

    @Autowired
    public ZalbaCutanjeController(ZalbaCutanjeService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<String> addZalbaCutanje(@RequestBody String xmlZalbaCutanje) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(xmlZalbaCutanje))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<String> getById(@PathVariable String id) throws ResourceNotFoundException, JAXBException {
        return ResponseEntity.ok(service.getById(id));
    }
}
