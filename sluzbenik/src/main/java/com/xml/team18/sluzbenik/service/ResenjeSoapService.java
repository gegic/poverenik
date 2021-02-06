package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.generators.ResenjeGenerator;
import com.xml.team18.sluzbenik.model.ListaResenja;
import com.xml.team18.sluzbenik.model.resenje.Resenje;
import com.xml.team18.sluzbenik.soap.incoming.ResenjeServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ResenjeSoapService {
    private ResenjeServicePortType endpoint;

    @Autowired
    private ResenjeGenerator resenjeGenerator;

    public Resenje getById(String id) {
        this.setupService();
        return endpoint.getById(id);
    }

    public ListaResenja pretraga(String upit) {
        this.setupService();
        return endpoint.pretraga(upit);
    }

    public String generatePdf(String id) throws Exception {
        Resenje z = endpoint.getById(id);
        return resenjeGenerator.generatePDF(z);
    }

    public String generateXhtml(String id) throws Exception {
        Resenje z = endpoint.getById(id);
        return resenjeGenerator.generateXhtml(z);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8079/ws/resenje?wsdl");
            QName serviceName = new QName("http://resenje.soap.poverenik.team18.xml.com/", "ResenjeService");
            QName portName = new QName("http://resenje.soap.poverenik.team18.xml.com/", "ResenjeServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, ResenjeServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
