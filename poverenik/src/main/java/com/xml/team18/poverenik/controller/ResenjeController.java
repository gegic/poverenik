package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.service.ResenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;
import java.net.URI;

@RestController
@RequestMapping(
        path = "/api/resenja",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class ResenjeController {

    private final ResenjeService service;

    @Autowired
    public ResenjeController(ResenjeService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<String> addResenje(@RequestBody String xmlResenje) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(xmlResenje))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<String> getById(@PathVariable String id) throws ResourceNotFoundException, JAXBException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ResponseEntity<String> getResenje() {
        try {
            Scanner s = new Scanner(new File("./xml/xmlModel/resenje.xml"));
            String xml = s.useDelimiter("\\Z").next();
            Object o = jaxB.unmarshall(xml, Resenje.class, ResenjeFactory.class);
            Resenje r = (Resenje) ((JAXBElement) o).getValue();
            xml = jaxB.marshall(r, Resenje.class, ResenjeFactory.class);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
