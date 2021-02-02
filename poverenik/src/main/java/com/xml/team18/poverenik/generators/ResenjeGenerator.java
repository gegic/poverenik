package com.xml.team18.poverenik.generators;

import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class ResenjeGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(Resenje r) throws Exception {
        String xml = jaxB.marshall(r, Resenje.class, ResenjeFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "resenje_fo.xsl",
                OUTPUT_FILE + r.getId() + ".pdf");
        return OUTPUT_FILE + r.getId() + ".pdf";
    }

    public String generateXhtml(Resenje r) throws Exception {
        String xml = jaxB.marshall(r, Resenje.class, ResenjeFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "resenje_xhtml.xsl", XHTML + r.getId() + ".html");
        return XHTML + r.getId() + ".html";
    }
}
