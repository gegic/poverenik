package com.xml.team18.sluzbenik.soap.obavestenje;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

@WebServiceClient(name = "ObavestenjeService", 
                  wsdlLocation = "src/main/resources/wsdl/obavestenje.wsdl",
                  targetNamespace = "http://obavestenje.soap.sluzbenik.team18.xml.com/") 
public class ObavestenjeService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://obavestenje.soap.sluzbenik.team18.xml.com/", "ObavestenjeService");
    public final static QName ObavestenjeServiceSoapBinding = new QName("http://obavestenje.soap.sluzbenik.team18.xml.com/", "ObavestenjeServiceSoapBinding");
    static {
        URL url = null;
        try {
            url = new URL("src/main/resources/wsdl/obavestenje.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ObavestenjeService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "src/main/resources/wsdl/obavestenje.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ObavestenjeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ObavestenjeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ObavestenjeService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ObavestenjeService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ObavestenjeService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ObavestenjeService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ObavestenjeServicePortType
     */
    @WebEndpoint(name = "ObavestenjeServiceSoapBinding")
    public ObavestenjeServicePortType getObavestenjeServiceSoapBinding() {
        return super.getPort(ObavestenjeServiceSoapBinding, ObavestenjeServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ObavestenjeServicePortType
     */
    @WebEndpoint(name = "ObavestenjeServiceSoapBinding")
    public ObavestenjeServicePortType getObavestenjeServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(ObavestenjeServiceSoapBinding, ObavestenjeServicePortType.class, features);
    }

}
