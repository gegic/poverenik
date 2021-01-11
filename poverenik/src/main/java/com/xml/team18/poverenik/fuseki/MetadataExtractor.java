package com.xml.team18.poverenik.fuseki;

import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Component
public class MetadataExtractor {
    private final TransformerFactory transformerFactory;

    private final String xsltFilePath;

    public MetadataExtractor() throws SAXException, IOException {
        xsltFilePath = "xsl/grddl.xsl";
        transformerFactory = new TransformerFactoryImpl();
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param xmlIn XML containing input stream
     */
    public String extractMetadata(String xmlIn) throws IOException, TransformerException {

        File xsltFile = new ClassPathResource(xsltFilePath).getFile();

        // Create transformation source
        StreamSource transformSource = new StreamSource(xsltFile);

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(new StringReader(xmlIn));

        StringWriter stringWriter = new StringWriter();

        // Initialize result stream
        StreamResult result = new StreamResult(stringWriter);

        // Trigger the transformation
        grddlTransformer.transform(source, result);

        return stringWriter.getBuffer().toString();
    }
}
