
package com.xml.team18.sluzbenik.factory;

import com.xml.team18.sluzbenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class IzvestajFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public IzvestajFactory() {
    }

    /**
     * Create an instance of {@link Izvestaj }
     *
     */
    public Izvestaj createIzvestaj() {
        return new Izvestaj();
    }

    /**
     * Create an instance of {@link Izvestaj.TrazilacInformacije }
     *
     */
    public Izvestaj.TrazilacInformacije createIzvestajTrazilacInformacije() {
        return new Izvestaj.TrazilacInformacije();
    }

    /**
     * Create an instance of {@link GodisnjaStatistika }
     *
     */
    public GodisnjaStatistika createGodisnjaStatistika() {
        return new GodisnjaStatistika();
    }

    /**
     * Create an instance of {@link Izvestaj.TrazilacInformacije.Zahtevi }
     *
     */
    public Izvestaj.TrazilacInformacije.Zahtevi createIzvestajTrazilacInformacijeZahtevi() {
        return new Izvestaj.TrazilacInformacije.Zahtevi();
    }

    /**
     * Create an instance of {@link Izvestaj.TrazilacInformacije.Zalbe }
     *
     */
    public Izvestaj.TrazilacInformacije.Zalbe createIzvestajTrazilacInformacijeZalbe() {
        return new Izvestaj.TrazilacInformacije.Zalbe();
    }

}
