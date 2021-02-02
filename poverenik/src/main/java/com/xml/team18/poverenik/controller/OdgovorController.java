package com.xml.team18.poverenik.controller;

import com.xml.team18.poverenik.dto.EntityList;
import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.service.OdgovorService;
import com.xml.team18.poverenik.service.ZahtevSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/odgovori")
public class OdgovorController {

    private final OdgovorService odgovorService;

    @Autowired
    public OdgovorController(OdgovorService odgovorService) {
        this.odgovorService = odgovorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<EntityList<OdgovorIzjasnjenje>> getOdgovori() throws Exception {
        return ResponseEntity.ok(new EntityList<>(this.odgovorService.getAll()));
    }

    @GetMapping(path = "/zalba/{idZalbe}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<OdgovorIzjasnjenje> getByIdZalbe(@PathVariable String idZalbe) {
        OdgovorIzjasnjenje found = this.odgovorService.getByIdZalbe(idZalbe);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found);
    }
}
