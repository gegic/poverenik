package com.xml.team18.poverenik.generators;

import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class ZahtevGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(Zahtev zahtev) throws Exception {
        JAXBElement<Zahtev> element = new JAXBElement<Zahtev>(QName.valueOf("zahtev"), Zahtev.class, zahtev);
        String xml = jaxB.marshall(element, Zahtev.class, ZahtevFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "zahtev_fo.xsl",
                OUTPUT_FILE + zahtev.getId() + ".pdf");
        return OUTPUT_FILE + zahtev.getId() + ".pdf";
    }

    public String generateXhtml(Zahtev zahtev) throws Exception {
        JAXBElement<Zahtev> element = new JAXBElement<Zahtev>(QName.valueOf("zahtev"), Zahtev.class, zahtev);
        String xml = jaxB.marshall(element, Zahtev.class, ZahtevFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "zahtev_xhtml.xsl", XHTML + zahtev.getId() + ".html");
        return XHTML + zahtev.getId() + ".html";
    }
}
