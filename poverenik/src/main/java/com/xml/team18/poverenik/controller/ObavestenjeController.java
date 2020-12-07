package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import com.xml.team18.poverenik.model.resenje.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;

@RestController
@RequestMapping(path = "/api/obavestenja")
public class ObavestenjeController {

    private final ObavestenjeFactory obavestenjeFactory;
    private final JaxB jaxB;

    @Autowired
    public ObavestenjeController(ObavestenjeFactory obavestenjeFactory, JaxB jaxB) {
        this.obavestenjeFactory = obavestenjeFactory;
        this.jaxB = jaxB;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<String> addObavestenje(@RequestBody String xmlObavestenje) {
        Obavestenje obavestenje;
        try {
            Object o = jaxB.unmarshall(xmlObavestenje, Obavestenje.class, obavestenjeFactory.getClass());
            obavestenje = (Obavestenje) ((JAXBElement) o).getValue();
            obavestenje.setDatum(XMLGregorianCalendarImpl.createDate(2020, 12, 7, 1));

            String xml = jaxB.marshall(o, Obavestenje.class, obavestenjeFactory.getClass());
            return ResponseEntity.ok(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ResponseEntity<String> getObavestenje() {
        try {
            Scanner s = new Scanner(new File("./xml/xmlModel/obavestenje.xml"));
            String xml = s.useDelimiter("\\Z").next();
            Object o = jaxB.unmarshall(xml, Obavestenje.class, ObavestenjeFactory.class);
            Obavestenje oba = (Obavestenje) ((JAXBElement) o).getValue();
            xml = jaxB.marshall(oba, Obavestenje.class, ObavestenjeFactory.class);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
