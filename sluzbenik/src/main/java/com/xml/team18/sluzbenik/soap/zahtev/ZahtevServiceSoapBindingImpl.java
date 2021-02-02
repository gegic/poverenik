
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.sluzbenik.soap.zahtev;

import com.xml.team18.sluzbenik.model.ListaZahteva;
import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import com.xml.team18.sluzbenik.repository.IzjasnjenjeRepository;
import com.xml.team18.sluzbenik.repository.IzvestajRepository;
import com.xml.team18.sluzbenik.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(
                      serviceName = "ZahtevService",
                      portName = "ZahtevServiceSoapBinding",
                      targetNamespace = "http://zahtev.soap.sluzbenik.team18.xml.com/",
                      wsdlLocation = "src/main/resources/wsdl/zahtev.wsdl",
                      endpointInterface = "com.xml.team18.sluzbenik.soap.zahtev.ZahtevServicePortType")

@Service
public class ZahtevServiceSoapBindingImpl implements ZahtevServicePortType {

    private ZahtevRepository zahtevRepository;
    private IzjasnjenjeRepository izjasnjenjeRepository;
    private IzvestajRepository izvestajRepository;

    private static final Logger LOG = Logger.getLogger(ZahtevServiceSoapBindingImpl.class.getName());

    public ListaZahteva odbijeniZahtevi(String korisnikId) {
        LOG.info("Executing operation odbijeniZahtevi");
        System.out.println(korisnikId);
        try {
            List<Zahtev> zahtevi = this.zahtevRepository.getOdbijeniByKorisnikId(korisnikId);
            return new ListaZahteva(zahtevi);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public ListaZahteva neodgovoreniZahtevi(String korisnikId) {
        LOG.info("Executing operation neodgovoreniZahtevi");
        System.out.println(korisnikId);
        try {
            List<Zahtev> zahtevi = this.zahtevRepository.getNeodgovoreniByKorisnikId(korisnikId);
            return new ListaZahteva(zahtevi);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public boolean updatePrihvatanje(Zahtev zahtev) {
        LOG.info("Executing operation saveZahtev");
        System.out.println(zahtev);
        try {
            Zahtev z = this.zahtevRepository.findById(zahtev.getId());
            z.setPrihvatanje(zahtev.getPrihvatanje());
            if (z.getPrihvatanje().equalsIgnoreCase("zalba-na-odluku")) {
                this.izvestajRepository.zalbaNaOdlukuPodneta();
            } else if (z.getPrihvatanje().equalsIgnoreCase("zalba-cutanje")) {
                this.izvestajRepository.zalbaCutanjePodneta();
            }
            return this.zahtevRepository.save(z) == null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public Zahtev getById(String id) {
        LOG.info("Executing operation getById");
        System.out.println(id);
        try {
            return this.zahtevRepository.findById(id);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean zahtevajIzjasnjenje(Izjasnjenje izjasnjenje) {
        LOG.info("Executing operation zahtevajIzjasnjenje");
        System.out.println(izjasnjenje.getId());
        try {
            return this.izjasnjenjeRepository.save(izjasnjenje) != null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Autowired
    public void setZahtevRepository(ZahtevRepository zahtevRepository) {
        this.zahtevRepository = zahtevRepository;
    }


    @Autowired
    public void setIzjasnjenjeRepository(IzjasnjenjeRepository izjasnjenjeRepository) {
        this.izjasnjenjeRepository = izjasnjenjeRepository;
    }

    @Autowired
    public void setIzvestajRepository(IzvestajRepository izvestajRepository) {
        this.izvestajRepository = izvestajRepository;
    }

}
