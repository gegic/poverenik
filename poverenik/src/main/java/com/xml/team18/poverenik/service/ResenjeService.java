package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.generators.ResenjeGenerator;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.repository.ResenjeRepository;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import com.xml.team18.poverenik.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    public ResenjeService(ResenjeRepository resenjeRepository,
                          JaxB jaxB,
                          ZahtevSoapService zahtevSoapService,
                          ZalbaNaOdlukuRepository zalbaNaOdlukuRepository,
                          ZalbaCutanjeRepository zalbaCutanjeRepository,
                          ResenjeGenerator resenjeGenerator) {
        this.repository = resenjeRepository;
        this.jaxB = jaxB;
        this.zahtevSoapService = zahtevSoapService;
        this.zalbaNaOdlukuRepository = zalbaNaOdlukuRepository;
        this.zalbaCutanjeRepository = zalbaCutanjeRepository;
        this.resenjeGenerator = resenjeGenerator;
    }

    public String save(Resenje resenje) throws ResourceNotFoundException {
        Resenje added = this.repository.save(resenje);
        if (added.getZalba().getTip().equalsIgnoreCase("cutanje")) {
            ZalbaCutanje zc = this.zalbaCutanjeRepository.findById(added.getZalba().getId());
            zc.setTipResenja(added.getTip());
            this.zalbaCutanjeRepository.save(zc);
        } else {
            ZalbaNaOdluku zno = this.zalbaNaOdlukuRepository.findById(added.getZalba().getId());
            zno.setTipResenja(added.getTip());
            this.zalbaNaOdlukuRepository.save(zno);
        }
        Zahtev z = this.zahtevSoapService.getById(added.getZahtev().getId());
        z.setPrihvatanje(added.getTip());
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
}
