package com.xml.team18.poverenik.soap.resenje;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;
import com.xml.team18.poverenik.model.ListaResenja;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.repository.OdgovorRepository;
import com.xml.team18.poverenik.repository.ResenjeRepository;
import com.xml.team18.poverenik.soap.resenje.ResenjeServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.logging.Logger;

@WebService(
                      serviceName = "ResenjeService",
                      portName = "ResenjeServiceSoapBinding",
                      targetNamespace = "http://resenje.soap.poverenik.team18.xml.com/",
                      wsdlLocation = "src/main/resources/wsdl/resenje.wsdl",
                      endpointInterface = "com.xml.team18.poverenik.soap.resenje.ResenjeServicePortType")
@Service
public class ResenjeServiceSoapBindingImpl implements ResenjeServicePortType {

    private ResenjeRepository resenjeRepository;

    private static final Logger LOG = Logger.getLogger(ResenjeServiceSoapBindingImpl.class.getName());


    @Autowired
    public void setResenjeRepository(ResenjeRepository resenjeRepository) {
        this.resenjeRepository = resenjeRepository;
    }

    @Override
    public Resenje getById(String idResenja) {
        try {
            return this.resenjeRepository.findById(idResenja);
        } catch (ResourceNotFoundException e) {
            return null;
        }
    }

    @Override
    public ListaResenja pretraga(String upit) {
        return new ListaResenja(this.resenjeRepository.naprednaPretraga(upit));
    }
}
