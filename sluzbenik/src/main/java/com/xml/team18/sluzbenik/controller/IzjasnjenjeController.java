package com.xml.team18.sluzbenik.controller;

import com.xml.team18.sluzbenik.dto.EntityList;
import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.sluzbenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.sluzbenik.service.IzjasnjenjeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/izjasnjenja")
public class IzjasnjenjeController {

    private final IzjasnjenjeService izjasnjenjeService;

    public IzjasnjenjeController(IzjasnjenjeService izjasnjenjeService) {
        this.izjasnjenjeService = izjasnjenjeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<EntityList<Izjasnjenje>> getAll() throws Exception {
        return ResponseEntity.ok(new EntityList<>(this.izjasnjenjeService.getAll()));
    }

    @PostMapping(path = "/odgovori/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Void> odgovori(@RequestBody OdgovorIzjasnjenje o, @PathVariable String id) throws Exception {
        this.izjasnjenjeService.odgovori(o, id);
        return ResponseEntity.ok().build();
    }
}
