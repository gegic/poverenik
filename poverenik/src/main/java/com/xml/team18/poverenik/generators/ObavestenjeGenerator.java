package com.xml.team18.poverenik.generators;

import com.xml.team18.poverenik.factory.ObavestenjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.obavestenje.Obavestenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class ObavestenjeGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(Obavestenje o) throws Exception {
        JAXBElement<Obavestenje> element = new JAXBElement<>(QName.valueOf("obavestenje"), Obavestenje.class, o);
        String xml = jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "obavestenje_fo.xsl",
                OUTPUT_FILE + o.getId() + ".pdf");
        return OUTPUT_FILE + o.getId() + ".pdf";
    }

    public String generateXhtml(Obavestenje o) throws Exception {
        JAXBElement<Obavestenje> element = new JAXBElement<>(QName.valueOf("obavestenje"), Obavestenje.class, o);
        String xml = jaxB.marshall(element, Obavestenje.class, ObavestenjeFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "obavestenje_xhtml.xsl", XHTML + o.getId() + ".html");
        return XHTML + o.getId() + ".html";
    }
}
