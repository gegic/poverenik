package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.dto.EmailDto;
import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.factory.EmailDtoFactory;
import com.xml.team18.poverenik.generators.ResenjeGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.repository.KorisnikRepository;
import com.xml.team18.poverenik.repository.ResenjeRepository;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import com.xml.team18.poverenik.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class ResenjeService {
    private final ResenjeRepository repository;
    private final ZahtevSoapService zahtevSoapService;
    private final ZalbaNaOdlukuRepository zalbaNaOdlukuRepository;
    private final ZalbaCutanjeRepository zalbaCutanjeRepository;
    private final JaxB jaxB;
    private final ResenjeGenerator resenjeGenerator;
    private final KorisnikRepository korisnikRepository;
    @Autowired
    public ResenjeService(ResenjeRepository resenjeRepository,
                          JaxB jaxB,
                          ZahtevSoapService zahtevSoapService,
                          ZalbaNaOdlukuRepository zalbaNaOdlukuRepository,
                          ZalbaCutanjeRepository zalbaCutanjeRepository,
                          ResenjeGenerator resenjeGenerator,
                          KorisnikRepository korisnikRepository) {
        this.repository = resenjeRepository;
        this.jaxB = jaxB;
        this.zahtevSoapService = zahtevSoapService;
        this.zalbaNaOdlukuRepository = zalbaNaOdlukuRepository;
        this.zalbaCutanjeRepository = zalbaCutanjeRepository;
        this.resenjeGenerator = resenjeGenerator;
        this.korisnikRepository = korisnikRepository;
    }

    public String save(Resenje resenje) throws Exception {
        Resenje added = this.repository.save(resenje);
        if (added.getZalba().getTip().equalsIgnoreCase("cutanje")) {
            ZalbaCutanje zc = this.zalbaCutanjeRepository.findById(added.getZalba().getId());
            added.getZalba().setProperty("pred:zalba");
            added.getZalba().setContent(added.getZalba().getId());
            zc.setTipResenja(added.getTip());
            this.zalbaCutanjeRepository.save(zc);
        } else {
            ZalbaNaOdluku zno = this.zalbaNaOdlukuRepository.findById(added.getZalba().getId());
            added.getZalba().setProperty("pred:zalba");
            added.getZalba().setContent(added.getZalba().getId());
            added.getZalba().getObavestenje().setProperty("pred:obavestenje");
            added.getZalba().getObavestenje().setContent(added.getZalba().getObavestenje().getId());
            zno.setTipResenja(added.getTip());
            this.zalbaNaOdlukuRepository.save(zno);
        }
        Zahtev z = this.zahtevSoapService.getById(added.getZahtev().getId());
        z.setPrihvatanje(added.getTip());
        String email = korisnikRepository.findById(added.getZalilac().getId()).getEmail();
        this.generatePdf(added.getId());
        this.sendEmailResenje(added.getId(), email);
        this.zahtevSoapService.updatePrihvatanje(z);
        return added.getId();
    }

    public Resenje getById(String id) throws ResourceNotFoundException, JAXBException {
        return repository.findById(id);
    }

    public List<Resenje> getAll() throws Exception {
        return repository.getAll();
    }

    public List<Resenje> getByKorisnikId(String korisnikId) throws Exception {
        return repository.getByKorisnikId(korisnikId);
    }

    public String generatePdf(String id) throws Exception {
        Resenje z = repository.findById(id);
        return resenjeGenerator.generatePDF(z);
    }

    public String generateXhtml(String id) throws Exception {
        Resenje z = repository.findById(id);
        return resenjeGenerator.generateXhtml(z);
    }

    @Async
    public void sendEmailResenje(String id, String email) {
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(email);
        emailDto.setSubject("Novo resenje");
        emailDto.setContent("U vezi sa Vasom zalbom je doneto novo resenje. Mozete ga procitati i preuzeti na " +
                "&lt;a href=&quot;http://localhost:4201/pdf/" + id + ".pdf&quot;&gt;ovoj adresi&lt;/a&gt;.");
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

    public List<Resenje> naprednaPretraga(String upit) {
        return repository.naprednaPretraga(upit);
    }

    public List<Resenje> pretraga(String query) throws Exception {
        return repository.pretraga(query);
    }

}
