package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;

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
        Resenje resenje;
        try {
            Object o = jaxB.unmarshall(xmlResenje, Resenje.class, resenjeFactory.getClass());
            resenje = (Resenje) ((JAXBElement) o).getValue();
            resenje.setDatum(XMLGregorianCalendarImpl.createDate(2020, 12, 7, 1));

            String xml = jaxB.marshall(o, Resenje.class, resenjeFactory.getClass());
            return ResponseEntity.ok(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
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
