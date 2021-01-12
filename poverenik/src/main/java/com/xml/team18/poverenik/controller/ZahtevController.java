package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalbacutanje.Zalba;
import com.xml.team18.poverenik.service.ZahtevService;
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
    ResponseEntity<String> addZahtev(@RequestBody String xmlZahtev) throws JAXBException {
        return ResponseEntity.created(URI.create(this.service.save(xmlZahtev))).build();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<String> getById(@PathVariable String id) throws ResourceNotFoundException, JAXBException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ResponseEntity<String> getZahtev() {
        try {
            Scanner s = new Scanner(new File("./xml/xmlModel/zahtev.xml"));
            String xml = s.useDelimiter("\\Z").next();
            Object o = jaxB.unmarshall(xml, Zahtev.class, ZahtevFactory.class);
            Zahtev z = (Zahtev) ((JAXBElement) o).getValue();
            xml = jaxB.marshall(z, Zahtev.class, ZahtevFactory.class);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
