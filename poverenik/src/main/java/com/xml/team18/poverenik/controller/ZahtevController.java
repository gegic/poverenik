package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
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
@RequestMapping(path = "/api/zahtevi")
public class ZahtevController {

  private final ZahtevFactory zahtevFactory;
  private final JaxB jaxB;

  @Autowired
  public ZahtevController(ZahtevFactory zahtevFactory, JaxB jaxB) {
    this.zahtevFactory = zahtevFactory;
    this.jaxB = jaxB;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  ResponseEntity<String> addZahtev(@RequestBody String xmlZahtev) {
    Zahtev zahtev;
    try {
      Object o = jaxB.unmarshall(xmlZahtev, Zahtev.class, zahtevFactory.getClass());
      zahtev = (Zahtev) ((JAXBElement) o).getValue();
      zahtev.setDatum(XMLGregorianCalendarImpl.createDate(2020, 12, 7, 1));

      String xml = jaxB.marshall(o, Zahtev.class, zahtevFactory.getClass());
      return ResponseEntity.ok(xml);
    } catch (JAXBException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
}
