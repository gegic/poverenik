package com.xml.team18.poverenik.soap.izvestaj;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T17:42:51.653+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "IzvestajService", 
                  wsdlLocation = "src/main/resources/wsdl/izvestaj.wsdl",
                  targetNamespace = "http://izvestaj.soap.poverenik.team18.xml.com/") 
public class IzvestajService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://izvestaj.soap.poverenik.team18.xml.com/", "IzvestajService");
    public final static QName IzvestajServiceSoapBinding = new QName("http://izvestaj.soap.poverenik.team18.xml.com/", "IzvestajServiceSoapBinding");
    static {
        URL url = null;
        try {
            url = new URL("src/main/resources/wsdl/izvestaj.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(IzvestajService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/gh/Desktop/xmlProjekat/xml2020/poverenik/src/main/resources/wsdl/izvestaj.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IzvestajService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IzvestajService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IzvestajService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public IzvestajService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public IzvestajService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public IzvestajService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IzvestajServicePortType
     */
    @WebEndpoint(name = "IzvestajServiceSoapBinding")
    public IzvestajServicePortType getIzvestajServiceSoapBinding() {
        return super.getPort(IzvestajServiceSoapBinding, IzvestajServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IzvestajServicePortType
     */
    @WebEndpoint(name = "IzvestajServiceSoapBinding")
    public IzvestajServicePortType getIzvestajServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(IzvestajServiceSoapBinding, IzvestajServicePortType.class, features);
    }

}
