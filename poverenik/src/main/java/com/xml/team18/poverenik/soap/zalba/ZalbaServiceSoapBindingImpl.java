package com.xml.team18.poverenik.soap.zalba;

import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.repository.OdgovorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(
                      serviceName = "ZalbaService",
                      portName = "ZalbaServiceSoapBinding",
                      targetNamespace = "http://zalba.soap.poverenik.team18.xml.com/",
                      wsdlLocation = "src/main/resources/wsdl/zalba.wsdl",
                      endpointInterface = "com.xml.team18.poverenik.soap.zalba.ZalbaServicePortType")
@Service
public class ZalbaServiceSoapBindingImpl implements ZalbaServicePortType {

    private OdgovorRepository odgovorRepository;

    private static final Logger LOG = Logger.getLogger(ZalbaServiceSoapBindingImpl.class.getName());

    public boolean odgovori(OdgovorIzjasnjenje odgovor) {
        LOG.info("Executing operation odgovori");
        System.out.println(odgovor);
        try {
            this.odgovorRepository.save(odgovor);
            return true;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Autowired
    public void setOdgovorRepository(OdgovorRepository odgovorRepository) {
        this.odgovorRepository = odgovorRepository;
    }

}
