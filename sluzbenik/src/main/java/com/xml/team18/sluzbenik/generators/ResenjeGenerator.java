package com.xml.team18.sluzbenik.generators;

import com.xml.team18.sluzbenik.factory.ResenjeFactory;
import com.xml.team18.sluzbenik.jaxb.JaxB;
import com.xml.team18.sluzbenik.model.resenje.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
