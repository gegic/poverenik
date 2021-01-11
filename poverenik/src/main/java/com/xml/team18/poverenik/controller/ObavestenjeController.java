package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

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
            String xml = jaxB.marshall(o, Obavestenje.class, obavestenjeFactory.getClass());
            return ResponseEntity.ok(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
