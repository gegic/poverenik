
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.sluzbenik.soap.zahtev;

import com.xml.team18.sluzbenik.model.ListaZahteva;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
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
                      wsdlLocation = "classpath:wsdl/zahtev.wsdl",
                      endpointInterface = "com.xml.team18.sluzbenik.soap.zahtev.ZahtevServicePortType")

@Service
public class ZahtevServiceSoapBindingImpl implements ZahtevServicePortType {

    private ZahtevRepository zahtevRepository;

    private static final Logger LOG = Logger.getLogger(ZahtevServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.xml.team18.sluzbenik.soap.zahtev.ZahtevServicePortType#odbijeniZahtevi(java.lang.String korisnikId)*
     */
    public ListaZahteva odbijeniZahtevi(String korisnikId) {
        LOG.info("Executing operation odbijeniZahtevi");
        System.out.println(korisnikId);
        try {
            ListaZahteva _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.xml.team18.sluzbenik.soap.zahtev.ZahtevServicePortType#neodgovoreniZahtevi(java.lang.String korisnikId)*
     */
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

    @Autowired
    public void setZahtevRepository(ZahtevRepository zahtevRepository) {
        this.zahtevRepository = zahtevRepository;
    }

}
