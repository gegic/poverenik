package com.xml.team18.sluzbenik.soap.zahtev;

import com.xml.team18.sluzbenik.factory.ListaZahtevaFactory;
import com.xml.team18.sluzbenik.model.ListaZahteva;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://zahtev.soap.sluzbenik.team18.xml.com/", name = "ZahtevServicePortType")
@XmlSeeAlso({ListaZahtevaFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ZahtevServicePortType {

    @WebMethod
    @WebResult(name = "zahtevi", targetNamespace = "http://zahtev.soap.sluzbenik.team18.xml.com/", partName = "zahtevi")
    ListaZahteva odbijeniZahtevi(
        @WebParam(partName = "korisnikId", name = "korisnikId")
        String korisnikId
    );

    @WebMethod(action = "neodgovoreniZahtevi")
    @WebResult(name = "zahtevi", targetNamespace = "http://zahtev.soap.sluzbenik.team18.xml.com/", partName = "zahtevi")
    ListaZahteva neodgovoreniZahtevi(
        @WebParam(partName = "korisnikId", name = "korisnikId")
        String korisnikId
    );
}
