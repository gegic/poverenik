package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.sluzbenik.soap.incoming.ZalbaServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ZalbaSoapService {
    private ZalbaServicePortType endpoint;

    public void odgovori(OdgovorIzjasnjenje o) {
        this.setupService();
        endpoint.odgovori(o);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8079/ws/zalba?wsdl");
            QName serviceName = new QName("http://zalba.soap.sluzbenik.team18.xml.com/", "ZalbaService");
            QName portName = new QName("http://zalba.soap.sluzbenik.team18.xml.com/", "ZalbaServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, ZalbaServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
