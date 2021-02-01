package com.xml.team18.poverenik.soap;

import com.xml.team18.poverenik.soap.korisnik.KorisnikServiceSoapBindingImpl;
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
    KorisnikServiceSoapBindingImpl korisnikServiceSoapBindingImpl;


    @Bean(name="korisnikEndpointBean")
    public Endpoint korisnikEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, korisnikServiceSoapBindingImpl);
        endpoint.publish("/korisnik");
        return endpoint;
    }
}