package com.xml.team18.poverenik.soap.zalba;

import com.xml.team18.poverenik.model.ListaZalbiCutanje;
import com.xml.team18.poverenik.model.ListaZalbiNaOdluku;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.repository.OdgovorRepository;
import com.xml.team18.poverenik.repository.ZalbaCutanjeRepository;
import com.xml.team18.poverenik.repository.ZalbaNaOdlukuRepository;
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
    private ZalbaNaOdlukuRepository zalbaNaOdlukuRepository;
    private ZalbaCutanjeRepository zalbaCutanjeRepository;
    
    private static final Logger LOG = Logger.getLogger(ZalbaServiceSoapBindingImpl.class.getName());

    @Override
    public ZalbaNaOdluku getByIdZalbaNaOdluku(String id) {
        LOG.info("Executing operation getByIdZalbaNaOdluku");
        try {
            return this.zalbaNaOdlukuRepository.findById(id);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

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

    @Override
    public ZalbaCutanje getByIdZalbaCutanje(String id) {
        LOG.info("Executing operation getByIdZalbaCutanje");
        try {
            return this.zalbaCutanjeRepository.findById(id);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ListaZalbiNaOdluku pretragaZalbaNaOdluku(String id) {
        LOG.info("Executing operation pretragaZalbaNaOdluku");
        try {
            return new ListaZalbiNaOdluku(this.zalbaNaOdlukuRepository.naprednaPretraga(id));
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ListaZalbiCutanje pretragaZalbaCutanje(String id) {
        LOG.info("Executing operation pretragaZalbaNaOdluku");
        try {
            return new ListaZalbiCutanje(this.zalbaCutanjeRepository.naprednaPretraga(id));
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Autowired
    public void setOdgovorRepository(OdgovorRepository odgovorRepository) {
        this.odgovorRepository = odgovorRepository;
    }

    @Autowired
    public void setZalbaNaOdlukuRepository(ZalbaNaOdlukuRepository zalbaNaOdlukuRepository) {
        this.zalbaNaOdlukuRepository = zalbaNaOdlukuRepository;
    }

    @Autowired
    public void setZalbaCutanjeRepository(ZalbaCutanjeRepository zalbaCutanjeRepository) {
        this.zalbaCutanjeRepository = zalbaCutanjeRepository;
    }

}
