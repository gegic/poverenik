package com.xml.team18.sluzbenik.soap;

import com.xml.team18.sluzbenik.soap.korisnik.KorisnikServiceSoapBindingImpl;
import com.xml.team18.sluzbenik.soap.obavestenje.ObavestenjeServiceSoapBindingImpl;
import com.xml.team18.sluzbenik.soap.zahtev.ZahtevServiceSoapBindingImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    ZahtevServiceSoapBindingImpl zahtevServiceSoapBindingImpl;

    @Autowired
    KorisnikServiceSoapBindingImpl korisnikServiceSoapBindingImpl;

    @Autowired
    ObavestenjeServiceSoapBindingImpl obavestenjeServiceSoapBindingImpl;

    @Bean(name="zahtevEndpointBean")
    public Endpoint zahtevEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, zahtevServiceSoapBindingImpl);
        endpoint.publish("/zahtev");
        return endpoint;
    }

    @Bean(name="korisnikEndpointBean")
    public Endpoint korisnikEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, korisnikServiceSoapBindingImpl);
        endpoint.publish("/korisnik");
        return endpoint;
    }

    @Bean(name="obavestenjeEndpointBean")
    public Endpoint obavestenjeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, obavestenjeServiceSoapBindingImpl);
        endpoint.publish("/obavestenje");
        return endpoint;
    }
}