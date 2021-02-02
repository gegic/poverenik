package com.xml.team18.poverenik.soap.zalba;

import com.xml.team18.poverenik.factory.OdgovorFactory;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.model.izjasnjenje.OdgovorIzjasnjenje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://zalba.soap.poverenik.team18.xml.com/", name = "ZalbaServicePortType")
@XmlSeeAlso({ZalbaCutanjeFactory.class, ZalbaNaOdlukuFactory.class, OdgovorFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ZalbaServicePortType {

    @WebMethod(action = "odgovori")
    @WebResult(name = "uspesno", targetNamespace = "http://zalba.soap.poverenik.team18.xml.com/", partName = "uspesno")
    boolean odgovori(
        @WebParam(partName = "odgovor", name = "odgovor")
        OdgovorIzjasnjenje odgovor
    );
}
