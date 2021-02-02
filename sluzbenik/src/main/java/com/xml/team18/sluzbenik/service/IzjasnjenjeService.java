package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.sluzbenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.sluzbenik.repository.IzjasnjenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzjasnjenjeService {
    private final IzjasnjenjeRepository izjasnjenjeRepository;
    private final ZalbaSoapService zalbaSoapService;

    @Autowired
    public IzjasnjenjeService(IzjasnjenjeRepository izjasnjenjeRepository,
                              ZalbaSoapService zalbaSoapService) {
        this.izjasnjenjeRepository = izjasnjenjeRepository;
        this.zalbaSoapService = zalbaSoapService;
    }

    public List<Izjasnjenje> getAll() throws Exception {
        return this.izjasnjenjeRepository.getAll();
    }

    public void odgovori(OdgovorIzjasnjenje o, String id) throws Exception {
        this.izjasnjenjeRepository.deleteById(id);
        this.zalbaSoapService.odgovori(o);
    }
}
