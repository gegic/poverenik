package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.soap.incoming.ZahtevServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ZahtevSoapService {

    public void neodgovoreniZahtevi(String idKorisnika) throws MalformedURLException {
        URL wsdlLocation = new URL("http://localhost:8080/ws/zahtev?wsdl");
        QName serviceName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevService");
        QName portName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevServiceSoapBinding");
        javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);

        ZahtevServicePortType zahtev = service.getPort(portName, ZahtevServicePortType.class);

        ListaZahteva response = zahtev.neodgovoreniZahtevi(idKorisnika);

        System.out.println(response);
    }

}
