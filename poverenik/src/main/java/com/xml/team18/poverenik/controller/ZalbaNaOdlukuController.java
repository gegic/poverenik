package com.xml.team18.poverenik.controller;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalbacutanje.Zalba;
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
@RequestMapping(path = "/api/zalba-na-odluku")
public class ZalbaNaOdlukuController {

  private final ZalbaNaOdlukuFactory zalbaNaOdlukuFactory;
  private final JaxB jaxB;

  @Autowired
  public ZalbaNaOdlukuController(ZalbaNaOdlukuFactory zalbaNaOdlukuFactory, JaxB jaxB) {
    this.zalbaNaOdlukuFactory = zalbaNaOdlukuFactory;
    this.jaxB = jaxB;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  ResponseEntity<String> addZalbaNaOdluku(@RequestBody String xmlZalbaNaOdluku) {
    Zalba zalbaNaOdluku;
    try {
      Object o = jaxB.unmarshall(xmlZalbaNaOdluku, Zalba.class, zalbaNaOdlukuFactory.getClass());
      zalbaNaOdluku = (Zalba) ((JAXBElement) o).getValue();
      zalbaNaOdluku.setDatum(XMLGregorianCalendarImpl.createDate(2020, 12, 7, 1));

      String xml = jaxB.marshall(o, Zalba.class, zalbaNaOdlukuFactory.getClass());
      return ResponseEntity.ok(xml);
    } catch (JAXBException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
}
