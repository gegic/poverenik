package com.xml.team18.sluzbenik.soap.korisnik;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

@WebServiceClient(name = "KorisnikService", 
                  wsdlLocation = "src/main/resources/wsdl/korisnik.wsdl",
                  targetNamespace = "http://korisnik.soap.sluzbenik.team18.xml.com/") 
public class KorisnikService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://korisnik.soap.sluzbenik.team18.xml.com/", "KorisnikService");
    public final static QName KorisnikServiceSoapBinding = new QName("http://korisnik.soap.sluzbenik.team18.xml.com/", "KorisnikServiceSoapBinding");
    static {
        URL url = null;
        try {
            url = new URL("src/main/resources/wsdl/korisnik.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(KorisnikService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "/src/main/resources/wsdl/korisnik.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public KorisnikService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public KorisnikService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public KorisnikService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public KorisnikService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public KorisnikService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public KorisnikService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns KorisnikServicePortType
     */
    @WebEndpoint(name = "KorisnikServiceSoapBinding")
    public KorisnikServicePortType getKorisnikServiceSoapBinding() {
        return super.getPort(KorisnikServiceSoapBinding, KorisnikServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns KorisnikServicePortType
     */
    @WebEndpoint(name = "KorisnikServiceSoapBinding")
    public KorisnikServicePortType getKorisnikServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(KorisnikServiceSoapBinding, KorisnikServicePortType.class, features);
    }

}
