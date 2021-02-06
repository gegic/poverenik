package com.xml.team18.poverenik.fuseki;

import org.apache.commons.io.IOUtils;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getIdsForString(String type, String whereQuery) {
        List<String> ids = new ArrayList<String>();

        String sparqlQuery = SparqlUtil
                .selectDistinctIdsForData(type,
                        this.fusekiProperties.getDataEndpoint() + "/" + type,
                        whereQuery);

        QueryExecution queryExecution = QueryExecutionFactory
                .sparqlService(String.join("/", fusekiProperties.getEndpoint(),
                        fusekiProperties.getDataset(),
                        fusekiProperties.getQuery()), sparqlQuery);
        queryExecution.execSelect();

        ResultSet results = queryExecution.execSelect();

        String varName;
        RDFNode varValue;

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            java.util.Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                ids.add(varValue.toString());
            }
        }
        return ids;
    }
}
