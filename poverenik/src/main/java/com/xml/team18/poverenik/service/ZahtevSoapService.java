package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.soap.incoming.ZahtevServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ZahtevSoapService {
    private final URL wsdlLocation = new URL("http://localhost:8080/ws/zahtev?wsdl");
    private final QName serviceName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevService");
    private final QName portName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevServiceSoapBinding");
    private final javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
    private final ZahtevServicePortType endpoint = service.getPort(portName, ZahtevServicePortType.class);

    public ZahtevSoapService() throws MalformedURLException {
    }

    public ListaZahteva neodgovoreniZahtevi(String idKorisnika) throws MalformedURLException {
        return endpoint.neodgovoreniZahtevi(idKorisnika);
    }

    public Zahtev getById(String id) {
        return endpoint.getById(id);
    }
    
    public void saveZahtev(Zahtev z) {
        endpoint.updatePrihvatanje(z);
    }

}
