/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.poverenik.soap.korisnik;

import com.xml.team18.poverenik.model.korisnik.Korisnik;
import com.xml.team18.poverenik.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.logging.Logger;

/**
 * This class was by Apache CXF 3.2.1
 * 2021-02-01T23:10:18.287+01:00
 * source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "KorisnikService",
                      portName = "KorisnikServiceSoapBinding",
                      wsdlLocation = "src/main/resources/wsdl/korisnik.wsdl",
                      endpointInterface = "com.xml.team18.poverenik.soap.korisnik.KorisnikServicePortType")
@Service
public class KorisnikServiceSoapBindingImpl implements KorisnikServicePortType {

    private KorisnikRepository korisnikRepository;

    private static final Logger LOG = Logger.getLogger(KorisnikServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see cxf.KorisnikServicePortType#neodgovoreniKorisniki(java.lang.String email)*
     */
    public Korisnik korisnikByEmail(String email) {
        LOG.info("Executing operation neodgovoreniKorisniki");
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
