package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.soap.incoming.ObavestenjeServicePortType;
import com.xml.team18.poverenik.soap.incoming.ZahtevServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ObavestenjeSoapService {
    private ObavestenjeServicePortType endpoint;

    public Obavestenje getByZahtevId(String zahtevId) {
        this.setupService();
        return endpoint.getByZahtevId(zahtevId);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8080/ws/obavestenje?wsdl");
            QName serviceName = new QName("http://obavestenje.soap.sluzbenik.team18.xml.com/", "ObavestenjeService");
            QName portName = new QName("http://obavestenje.soap.sluzbenik.team18.xml.com/", "ObavestenjeServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, ObavestenjeServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
