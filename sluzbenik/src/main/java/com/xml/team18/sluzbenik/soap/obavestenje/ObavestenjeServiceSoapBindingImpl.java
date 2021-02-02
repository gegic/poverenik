
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.sluzbenik.soap.obavestenje;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import com.xml.team18.sluzbenik.model.obavestenje.Obavestenje;
import com.xml.team18.sluzbenik.repository.ObavestenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;
import java.util.logging.Logger;

@WebService(
                      serviceName = "ObavestenjeService",
                      portName = "ObavestenjeServiceSoapBinding",
                      targetNamespace = "http://obavestenje.soap.sluzbenik.team18.xml.com/",
                      wsdlLocation = "src/main/resources/wsdl/obavestenje.wsdl",
                      endpointInterface = "com.xml.team18.sluzbenik.soap.obavestenje.ObavestenjeServicePortType")

@Service
public class ObavestenjeServiceSoapBindingImpl implements ObavestenjeServicePortType {

    private ObavestenjeRepository obavestenjeRepository;

    private static final Logger LOG = Logger.getLogger(ObavestenjeServiceSoapBindingImpl.class.getName());

    @Override
    public Obavestenje getByZahtevId(String zahtevId) {
        LOG.info("Executing operation getByZahtevId");
        try {
            return this.obavestenjeRepository.getByZahtevId(zahtevId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Obavestenje getById(String id) {
        LOG.info("Executing operation getById");
        try {
            return this.obavestenjeRepository.findById(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    public void setObavestenjeRepository(ObavestenjeRepository obavestenjeRepository) {
        this.obavestenjeRepository = obavestenjeRepository;
    }


}
