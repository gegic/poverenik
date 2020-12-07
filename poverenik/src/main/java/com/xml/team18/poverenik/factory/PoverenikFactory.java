
package com.xml.team18.poverenik.factory;

import com.xml.team18.poverenik.model.*;

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
public class PoverenikFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public PoverenikFactory() {
    }

    /**
     * Create an instance of {@link TListObjave }
     * 
     */
    public TListObjave createTListObjave() {
        return new TListObjave();
    }

    /**
     * Create an instance of {@link TAkt }
     * 
     */
    public TAkt createTAkt() {
        return new TAkt();
    }

    /**
     * Create an instance of {@link TAkt.Clan }
     * 
     */
    public TAkt.Clan createTAktClan() {
        return new TAkt.Clan();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav }
     * 
     */
    public TAkt.Clan.Stav createTAktClanStav() {
        return new TAkt.Clan.Stav();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TOrgan }
     * 
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link TListObjave.Broj }
     * 
     */
    public TListObjave.Broj createTListObjaveBroj() {
        return new TListObjave.Broj();
    }

    /**
     * Create an instance of {@link TAkt.Clan.Stav.Tacka }
     * 
     */
    public TAkt.Clan.Stav.Tacka createTAktClanStavTacka() {
        return new TAkt.Clan.Stav.Tacka();
    }

}
