package com.xml.team18.poverenik.generators;

import org.apache.commons.io.IOUtils;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class XmlTransformations {

    private static final String FOP_CONF = "src/main/resources/fop.xconf";

    private DocumentBuilderFactory documentFactory;

    private TransformerFactory transformerFactory;

    private FopFactory fopFactory;

    @Autowired
    public XmlTransformations() throws SAXException, IOException {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
        transformerFactory = TransformerFactory.newInstance();
        // Initialize FOP factory object
        fopFactory = FopFactory.newInstance(new File(FOP_CONF));
    }

    public org.w3c.dom.Document buildDocument(String xml) {
        org.w3c.dom.Document document;
        try {
            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(IOUtils.toInputStream(xml, StandardCharsets.UTF_8));
        } catch (Exception e) {
            return null;
        }
        return document;
    }

    public void generateHTML(String xml, String xslPath, String htmlPath) throws FileNotFoundException {
        try {
            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File(xslPath));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(xml));
            StreamResult result = new StreamResult(new FileOutputStream(htmlPath));
            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void generatePDF(String xml, String xslPath, String outputPath) throws Exception {
        // Point to the XSL-FO file
        File xslFile = new File(xslPath);

        // Create transformation source
        StreamSource transformSource = new StreamSource(xslFile);

        // Initialize the transformation subject
        StreamSource source = new StreamSource(IOUtils.toInputStream(xml, StandardCharsets.UTF_8));

        // Initialize user agent needed for the transformation
        FOUserAgent userAgent = fopFactory.newFOUserAgent();

        // Create the output stream to store the results
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        // Initialize the XSL-FO transformer object
        Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);

        // Construct FOP instance with desired output format
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

        // Resulting SAX events
        javax.xml.transform.Result res = new SAXResult(fop.getDefaultHandler());

        // Start XSLT transformation and FOP processing
        xslFoTransformer.transform(source, res);

        // Generate PDF file
        File pdfFile = new File(outputPath);
        if (!pdfFile.getParentFile().exists()) {
            pdfFile.getParentFile().mkdir();
        }

        OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
        out.write(outStream.toByteArray());

        out.close();
    }
}
