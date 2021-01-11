package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping(path = "/api/resenja")
public class ResenjeController {

    private final ResenjeFactory resenjeFactory;
    private final JaxB jaxB;

    @Autowired
    public ResenjeController(ResenjeFactory resenjeFactory, JaxB jaxB) {
        this.resenjeFactory = resenjeFactory;
        this.jaxB = jaxB;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<String> addResenje(@RequestBody String xmlResenje) {
        try {
            Resenje resenje = (Resenje) jaxB.unmarshall(xmlResenje, Resenje.class, resenjeFactory.getClass());

            String xml = jaxB.marshall(resenje, Resenje.class, resenjeFactory.getClass());
            return ResponseEntity.ok(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
