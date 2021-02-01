package com.xml.team18.poverenik.generators;

import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.cutanje.ZalbaCutanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class ZalbaCutanjeGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(ZalbaCutanje zalbaCutanje) throws Exception {
        JAXBElement<ZalbaCutanje> element = new JAXBElement<>(QName.valueOf("zalba-cutanje"), ZalbaCutanje.class, zalbaCutanje);
        String xml = jaxB.marshall(element, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "zalbacutanje_fo.xsl",
                OUTPUT_FILE + zalbaCutanje.getId() + ".pdf");
        return OUTPUT_FILE + zalbaCutanje.getId() + ".pdf";
    }

    public String generateXhtml(ZalbaCutanje zalbaCutanje) throws Exception {
        JAXBElement<ZalbaCutanje> element = new JAXBElement<ZalbaCutanje>(QName.valueOf("zalba-cutanje"), ZalbaCutanje.class, zalbaCutanje);
        String xml = jaxB.marshall(element, ZalbaCutanje.class, ZalbaCutanjeFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "zalbacutanje_xhtml.xsl", XHTML + zalbaCutanje.getId() + ".html");
        return XHTML + zalbaCutanje.getId() + ".html";
    }
}
