package com.xml.team18.poverenik.soap.incoming;

import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://obavestenje.soap.sluzbenik.team18.xml.com/", name = "ObavestenjeServicePortType")
@XmlSeeAlso({ObavestenjeFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ObavestenjeServicePortType {

    @WebMethod(action = "getByZahtevId")
    @WebResult(name = "obavestenje", targetNamespace = "http://obavestenje.soap.sluzbenik.team18.xml.com/", partName = "obavestenje")
    Obavestenje getByZahtevId(
        @WebParam(partName = "zahtevId", name = "zahtevId")
        String zahtevId
    );

    @WebMethod(action = "getById")
    @WebResult(name = "obavestenje", targetNamespace = "http://obavestenje.soap.sluzbenik.team18.xml.com/", partName = "obavestenje")
    Obavestenje getById(
            @WebParam(partName = "id", name = "id")
                    String id
    );
}
