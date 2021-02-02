package com.xml.team18.poverenik.soap.korisnik;

import com.xml.team18.poverenik.factory.KorisnikFactory;
import com.xml.team18.poverenik.model.korisnik.Korisnik;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://korisnik.soap.poverenik.team18.xml.com/", name = "KorisnikServicePortType")
@XmlSeeAlso({KorisnikFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface KorisnikServicePortType {

    @WebMethod(action = "korisnikByEmail")
    @WebResult(name = "korisnik", targetNamespace = "http://korisnik.soap.poverenik.team18.xml.com/", partName = "korisnik")
    Korisnik korisnikByEmail(
        @WebParam(partName = "email", name = "email")
        String email
    );
}
