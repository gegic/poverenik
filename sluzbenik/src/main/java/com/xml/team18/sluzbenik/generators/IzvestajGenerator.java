package com.xml.team18.sluzbenik.generators;

import com.xml.team18.sluzbenik.factory.IzvestajFactory;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class IzvestajGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(Izvestaj izvestaj) throws Exception {
        JAXBElement<Izvestaj> element = new JAXBElement<Izvestaj>(QName.valueOf("izvestaj"), Izvestaj.class, izvestaj);
        String xml = jaxB.marshall(element, Izvestaj.class, IzvestajFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "izvestaj_fo.xsl",
                OUTPUT_FILE + izvestaj.getId() + ".pdf");
        return OUTPUT_FILE + izvestaj.getId() + ".pdf";
    }

    public String generateXhtml(Izvestaj izvestaj) throws Exception {
        JAXBElement<Izvestaj> element = new JAXBElement<Izvestaj>(QName.valueOf("izvestaj"), Izvestaj.class, izvestaj);
        String xml = jaxB.marshall(element, Izvestaj.class, IzvestajFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "izvestaj_xhtml.xsl", XHTML + izvestaj.getId() + ".html");
        return XHTML + izvestaj.getId() + ".html";
    }
}
