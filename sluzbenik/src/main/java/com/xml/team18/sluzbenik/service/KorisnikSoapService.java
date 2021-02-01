package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import com.xml.team18.sluzbenik.soap.incoming.KorisnikServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class KorisnikSoapService {
    public Korisnik korisnikByEmail(String email) throws MalformedURLException {
        URL wsdlLocation = new URL("http://localhost:8079/ws/korisnik?wsdl");
        QName serviceName = new QName("http://korisnik.soap.poverenik.team18.xml.com/", "KorisnikService");
        QName portName = new QName("http://korisnik.soap.poverenik.team18.xml.com/", "KorisnikServiceSoapBinding");
        javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);

        KorisnikServicePortType korisnikPort = service.getPort(portName, KorisnikServicePortType.class);

        try {
            return korisnikPort.korisnikByEmail(email);
        } catch (Exception e) {
            return null;
        }

    }
}
