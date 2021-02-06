package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.generators.ZalbaCutanjeGenerator;
import com.xml.team18.sluzbenik.generators.ZalbaNaOdlukuGenerator;
import com.xml.team18.sluzbenik.model.ListaZalbiCutanje;
import com.xml.team18.sluzbenik.model.ListaZalbiNaOdluku;
import com.xml.team18.sluzbenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.sluzbenik.model.zalba.cutanje.ZalbaCutanje;
import com.xml.team18.sluzbenik.model.zalba.na.odluku.ZalbaNaOdluku;
import com.xml.team18.sluzbenik.soap.incoming.ZalbaServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ZalbaSoapService {
    private ZalbaServicePortType endpoint;

    @Autowired
    private ZalbaNaOdlukuGenerator zalbaNaOdlukuGenerator;

    @Autowired
    private ZalbaCutanjeGenerator zalbaCutanjeGenerator;

    public void odgovori(OdgovorIzjasnjenje o) {
        this.setupService();
        endpoint.odgovori(o);
    }
    
    public ZalbaCutanje getByIdZalbaCutanje(String id) {
        this.setupService();
        return endpoint.getByIdZalbaCutanje(id);
    }

    public ZalbaNaOdluku getByIdZalbaNaOdluku(String id) {
        this.setupService();
        return endpoint.getByIdZalbaNaOdluku(id);
    }

    public ListaZalbiCutanje pretragaZalbaCutanje(String upit) {
        this.setupService();
        return endpoint.pretragaZalbaCutanje(upit);
    }

    public ListaZalbiNaOdluku pretragaZalbaNaOdluku(String upit) {
        this.setupService();
        return endpoint.pretragaZalbaNaOdluku(upit);
    }

    public String generatePdfZalbaNaOdluku(String id) throws Exception {
        ZalbaNaOdluku z = endpoint.getByIdZalbaNaOdluku(id);
        return zalbaNaOdlukuGenerator.generatePDF(z);
    }

    public String generateXhtmlZalbaNaOdluku(String id) throws Exception {
        ZalbaNaOdluku z = endpoint.getByIdZalbaNaOdluku(id);
        return zalbaNaOdlukuGenerator.generateXhtml(z);
    }

    public String generatePdfZalbaCutanje(String id) throws Exception {
        ZalbaCutanje z = endpoint.getByIdZalbaCutanje(id);
        return zalbaCutanjeGenerator.generatePDF(z);
    }

    public String generateXhtmlZalbaCutanje(String id) throws Exception {
        ZalbaCutanje z = endpoint.getByIdZalbaCutanje(id);
        return zalbaCutanjeGenerator.generateXhtml(z);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8079/ws/zalba?wsdl");
            QName serviceName = new QName("http://zalba.soap.poverenik.team18.xml.com/", "ZalbaService");
            QName portName = new QName("http://zalba.soap.poverenik.team18.xml.com/", "ZalbaServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, ZalbaServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
