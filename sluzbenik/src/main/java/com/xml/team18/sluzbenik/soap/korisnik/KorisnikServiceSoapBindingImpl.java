
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.sluzbenik.soap.korisnik;

import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(
                      serviceName = "KorisnikService",
                      portName = "KorisnikServiceSoapBinding",
                      wsdlLocation = "src/main/resources/wsdl/korisnik.wsdl",
                      endpointInterface = "com.xml.team18.sluzbenik.soap.korisnik.KorisnikServicePortType")
@Service
public class KorisnikServiceSoapBindingImpl implements KorisnikServicePortType {

    private KorisnikRepository korisnikRepository;

    private static final Logger LOG = Logger.getLogger(KorisnikServiceSoapBindingImpl.class.getName());

    public Korisnik korisnikByEmail(String email) {
        LOG.info("Executing operation korisnikByEmail");
        try {
            return this.korisnikRepository.findByEmail(email);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Autowired
    public void setKorisnikRepository(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

}
