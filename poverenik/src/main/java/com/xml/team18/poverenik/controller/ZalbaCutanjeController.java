package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalbacutanje.Zalba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;

@RestController
@RequestMapping(path = "/api/zalba-cutanje")
public class ZalbaCutanjeController {

    private final ZalbaCutanjeFactory zalbaCutanjeFactory;
    private final JaxB jaxB;

    @Autowired
    public ZalbaCutanjeController(ZalbaCutanjeFactory zalbaCutanjeFactory, JaxB jaxB) {
        this.zalbaCutanjeFactory = zalbaCutanjeFactory;
        this.jaxB = jaxB;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<String> addZalbaCutanje(@RequestBody String xmlZalbaCutanje) {
        Zalba zalbaCutanje;
        try {
            Object o = jaxB.unmarshall(xmlZalbaCutanje, Zalba.class, zalbaCutanjeFactory.getClass());
            zalbaCutanje = (Zalba) ((JAXBElement) o).getValue();
            zalbaCutanje.setDatum(XMLGregorianCalendarImpl.createDate(2020, 12, 7, 1));

            String xml = jaxB.marshall(o, Zalba.class, zalbaCutanjeFactory.getClass());
            return ResponseEntity.ok(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ResponseEntity<String> getZalbaCutanje() {
        try {
            Scanner s = new Scanner(new File("./xml/xmlModel/zalbacutanje.xml"));
            String xml = s.useDelimiter("\\Z").next();
            Object o = jaxB.unmarshall(xml, Zalba.class, ZalbaCutanjeFactory.class);
            Zalba z = (Zalba) ((JAXBElement) o).getValue();
            xml = jaxB.marshall(z, Zalba.class, ZalbaCutanjeFactory.class);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
