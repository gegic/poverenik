package com.xml.team18.sluzbenik.service;


import com.xml.team18.sluzbenik.dto.EmailDto;
import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.factory.EmailDtoFactory;
import com.xml.team18.sluzbenik.factory.ObavestenjeFactory;
import com.xml.team18.sluzbenik.generators.ObavestenjeGenerator;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.obavestenje.Obavestenje;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.IzvestajRepository;
import com.xml.team18.sluzbenik.repository.KorisnikRepository;
import com.xml.team18.sluzbenik.repository.ObavestenjeRepository;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ObavestenjeService {
    private final ObavestenjeRepository repository;
    private final ZahtevRepository zahtevRepository;
    private final JaxB jaxB;
    private final ObavestenjeGenerator obavestenjeGenerator;
    private final IzvestajRepository izvestajRepository;
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public ObavestenjeService(ObavestenjeRepository obavestenjeRepository,
                              JaxB jaxB,
                              ZahtevRepository zahtevRepository,
                              ObavestenjeGenerator obavestenjeGenerator,
                              IzvestajRepository izvestajRepository,
                              KorisnikRepository korisnikRepository) {
        this.repository = obavestenjeRepository;
        this.jaxB = jaxB;
        this.zahtevRepository = zahtevRepository;
        this.obavestenjeGenerator = obavestenjeGenerator;
        this.izvestajRepository = izvestajRepository;
        this.korisnikRepository = korisnikRepository;
    }

    public String save(Obavestenje obavestenje) throws Exception {
        Zahtev z = zahtevRepository.findById(obavestenje.getZahtev().getId());
        obavestenje.getZahtev().setProperty("pred:zahtev");
        obavestenje.getZahtev().setContent(obavestenje.getZahtev().getId());
        Obavestenje o = this.repository.save(obavestenje);
        if (o.getTip().equalsIgnoreCase("prihvatanje")) {
            z.setPrihvatanje("prihvacen");
            this.izvestajRepository.zahtevPrihvacen();
        } else {
            z.setPrihvatanje("odbijen");
            this.izvestajRepository.zahtevOdbijen();
        }
        String email = korisnikRepository.findById(o.getPodnosilac().getId()).getEmail();
        this.generatePdf(o.getId());
        this.sendEmailObavestenje(o.getId(), email);
        zahtevRepository.save(z);
        return o.getId();
    }

    public Obavestenje getById(String id) throws ResourceNotFoundException {
        return repository.findById(id);
    }

    public List<Obavestenje> naprednaPretraga(String upit) {
        return repository.naprednaPretraga(upit);
    }

    public List<Obavestenje> getAllByKorisnikId(String korisnikId) throws Exception {
        return repository.getAllByKorisnikId(korisnikId);
    }

    public List<Obavestenje> getAll() throws Exception {
        return repository.getAll();
    }

    public List<Obavestenje> pretraga(String query) throws Exception {
        return repository.pretraga(query);
    }

    public String generatePdf(String id) throws Exception {
        Obavestenje o = repository.findById(id);
        return obavestenjeGenerator.generatePDF(o);
    }

    public String generateXhtml(String id) throws Exception {
        Obavestenje o = repository.findById(id);
        return obavestenjeGenerator.generateXhtml(o);
    }

    @Async
    public void sendEmailObavestenje(String id, String email) {
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(email);
        emailDto.setSubject("Novo obavestenje");
        emailDto.setContent("U vezi sa Vasim zahtevom je doneto novo obavestenje. Mozete ga procitati i preuzeti na " +
                "&lt;a href=&quot;http://localhost:4200/pdf/" + id + ".pdf&quot;&gt;ovoj adresi&lt;/a&gt;.");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        try {
            String xml = jaxB.marshall(emailDto, EmailDto.class, EmailDtoFactory.class);
            HttpEntity<String> entity = new HttpEntity<String>(xml, headers);

            restTemplate.postForEntity("http://localhost:8078/api/email", entity, Void.class);
        } catch (JAXBException ignored) {
        }

    }

    public String getJsonById(String id) throws FileNotFoundException {
        return repository.getJsonById(id);
    }

    public String getRdfById(String id) throws FileNotFoundException {
        return repository.getRdfById(id);
    }
}
