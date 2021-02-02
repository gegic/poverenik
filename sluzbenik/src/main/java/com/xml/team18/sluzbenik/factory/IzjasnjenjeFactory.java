
package com.xml.team18.sluzbenik.factory;


import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;

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
public class IzjasnjenjeFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public IzjasnjenjeFactory() {
    }

    /**
     * Create an instance of {@link Izjasnjenje }
     * 
     */
    public Izjasnjenje createIzjasnjenje() {
        return new Izjasnjenje();
    }

}
