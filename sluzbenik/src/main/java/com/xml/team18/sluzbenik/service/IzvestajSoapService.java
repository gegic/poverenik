package com.xml.team18.sluzbenik.service;

import com.xml.team18.sluzbenik.model.izjasnjenje.OdgovorIzjasnjenje;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.soap.incoming.IzvestajServicePortType;
import com.xml.team18.sluzbenik.soap.incoming.ZalbaServicePortType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class IzvestajSoapService {
    private IzvestajServicePortType endpoint;

    public void podnesiIzvestaj(Izvestaj i) {
        this.setupService();
        endpoint.podnesiIzvestaj(i);
    }

    private void setupService() {
        try {
            if (endpoint != null) {
                return;
            }
            URL wsdlLocation = new URL("http://localhost:8079/ws/izvestaj?wsdl");
            QName serviceName = new QName("http://izvestaj.soap.poverenik.team18.xml.com/", "IzvestajService");
            QName portName = new QName("http://izvestaj.soap.poverenik.team18.xml.com/", "IzvestajServiceSoapBinding");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(wsdlLocation, serviceName);
            endpoint = service.getPort(portName, IzvestajServicePortType.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
