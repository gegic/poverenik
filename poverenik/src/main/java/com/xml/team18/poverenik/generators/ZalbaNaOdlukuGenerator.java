package com.xml.team18.poverenik.generators;

import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Component
public class ZalbaNaOdlukuGenerator {

    private static final String TRANSFORMATORS_FILE = "src/main/resources/transformators/";

    private static final String XHTML = "xhtml/";

    private static final String OUTPUT_FILE = "pdf/";

    @Autowired
    private XmlTransformations xmlTransformations;

    @Autowired
    private JaxB jaxB;

    public String generatePDF(ZalbaNaOdluku zalbaNaOdluku) throws Exception {
        JAXBElement<ZalbaNaOdluku> element = new JAXBElement<>(QName.valueOf("zalba-na-odluku"), ZalbaNaOdluku.class, zalbaNaOdluku);
        String xml = jaxB.marshall(element, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        xmlTransformations.generatePDF(xml, TRANSFORMATORS_FILE + "zalbanaodluku_fo.xsl",
                OUTPUT_FILE + zalbaNaOdluku.getId() + ".pdf");
        return OUTPUT_FILE + zalbaNaOdluku.getId() + ".pdf";
    }

    public String generateXhtml(ZalbaNaOdluku zalbaNaOdluku) throws Exception {
        JAXBElement<ZalbaNaOdluku> element = new JAXBElement<>(QName.valueOf("zalba-na-odluku"), ZalbaNaOdluku.class, zalbaNaOdluku);
        String xml = jaxB.marshall(element, ZalbaNaOdluku.class, ZalbaNaOdlukuFactory.class);
        xmlTransformations.generateHTML(xml, TRANSFORMATORS_FILE + "zalbanaodluku_xhtml.xsl", XHTML + zalbaNaOdluku.getId() + ".html");
        return XHTML + zalbaNaOdluku.getId() + ".html";
    }
}
