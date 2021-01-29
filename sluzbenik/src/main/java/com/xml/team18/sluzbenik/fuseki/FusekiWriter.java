package com.xml.team18.sluzbenik.fuseki;

import org.apache.commons.io.IOUtils;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FusekiWriter {
    private final FusekiProperties fusekiProperties;

    @Autowired
    public FusekiWriter(FusekiProperties fusekiProperties) {
        this.fusekiProperties = fusekiProperties;
    }

    public void saveRDF(String inputRdf, String graphUri) {

        Model model = ModelFactory.createDefaultModel();
        model.read(IOUtils.toInputStream(inputRdf, StandardCharsets.UTF_8), null);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        model.write(out, SparqlUtil.NTRIPLES);

        UpdateRequest request = UpdateFactory.create();
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, this.fusekiProperties.getUpdateEndpoint());
        processor.execute();
        String sparqlInsert = SparqlUtil.insertData(this.fusekiProperties.getDataEndpoint() + "/" + graphUri,
                new String(out.toByteArray()));

        UpdateRequest update = UpdateFactory.create(sparqlInsert);
        processor = UpdateExecutionFactory.createRemote(update, this.fusekiProperties.getUpdateEndpoint());
        processor.execute();

    }
}
