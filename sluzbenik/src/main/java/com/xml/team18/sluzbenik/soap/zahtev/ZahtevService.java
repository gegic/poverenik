package com.xml.team18.sluzbenik.soap.zahtev;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

@WebServiceClient(name = "ZahtevService",
        wsdlLocation = "src/main/resources/wsdl/zahtev.wsdl",
        targetNamespace = "http://zahtev.soap.sluzbenik.team18.xml.com/")
public class ZahtevService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevService");
    public final static QName ZahtevServiceSoapBinding = new QName("http://zahtev.soap.sluzbenik.team18.xml.com/", "ZahtevServiceSoapBinding");
    static {
        URL url = ZahtevService.class.getClassLoader().getResource("wsdl/zahtev.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(ZahtevService.class.getName())
                    .log(java.util.logging.Level.INFO,
                            "Can not initialize the default wsdl from {0}", "classpath:wsdl/zahtev.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ZahtevService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ZahtevService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZahtevService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ZahtevService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ZahtevService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ZahtevService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ZahtevServicePortType
     */
    @WebEndpoint(name = "ZahtevServiceSoapBinding")
    public ZahtevServicePortType getZahtevServiceSoapBinding() {
        return super.getPort(ZahtevServiceSoapBinding, ZahtevServicePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZahtevServicePortType
     */
    @WebEndpoint(name = "ZahtevServiceSoapBinding")
    public ZahtevServicePortType getZahtevServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(ZahtevServiceSoapBinding, ZahtevServicePortType.class, features);
    }

}
