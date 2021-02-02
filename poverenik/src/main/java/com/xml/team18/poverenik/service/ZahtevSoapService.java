package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.model.ListaZahteva;
import com.xml.team18.poverenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.poverenik.soap.incoming.ZahtevServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ZahtevSoapService {
    private ZahtevServicePortType endpoint;

    public ListaZahteva neodgovoreniZahtevi(String idKorisnika) {
        this.setupService();
        return endpoint.neodgovoreniZahtevi(idKorisnika);
    }

    public ListaZahteva odbijeniZahtevi(String idKorisnika) {
        this.setupService();
        return endpoint.odbijeniZahtevi(idKorisnika);
    }

    public Zahtev getById(String id) {
        this.setupService();
        return endpoint.getById(id);
    }
    
    public void saveZahtev(Zahtev z) {
        this.setupService();
        endpoint.updatePrihvatanje(z);
    }

    public void zahtevajIzjasnjenje(ZalbaNaOdluku zalbaNaOdluku) {
        this.setupService();
        Izjasnjenje i = new Izjasnjenje();
        i.setIdObavestenja(zalbaNaOdluku.getProtiv().getId());
        i.setIdZahteva(zalbaNaOdluku.getZahtev().getId());
        i.setIdZalbe(zalbaNaOdluku.getId());
        i.setTipZalbe("na-odluku");
        endpoint.zahtevajIzjasnjenje(i);
    }

    public void zahtevajIzjasnjenje(ZalbaCutanje zalbaCutanje) {
        Izjasnjenje i = new Izjasnjenje();
        i.setIdZahteva(zalbaCutanje.getZahtev().getId());
        i.setIdZalbe(zalbaCutanje.getId());
        i.setTipZalbe("cutanje");
        endpoint.zahtevajIzjasnjenje(i);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8080/ws/zahtev?wsdl");
            QName serviceName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevService");
            QName portName = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, ZahtevServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
