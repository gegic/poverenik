package com.xml.team18.sluzbenik.fuseki;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.exist.xquery.functions.fn.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class FusekiWriter {
    private final FusekiProperties fusekiProperties;

    private static final String JSON_FILE = "json/";
    private static final String RDF_FILE = "rdf/";


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

    public String getMetaDataByIdAsJSON(String type, String id) throws FileNotFoundException {
        String sparqlQuery = SparqlUtil.selectPredicateObjectData(
                "zahtevi",
                this.fusekiProperties.getDataEndpoint() + "/" + type,
                String.format("<http://team14.xml.com/rdf/%s/%s>  ?predicate  ?object", type, id));

        QueryExecution queryExecution = QueryExecutionFactory
                .sparqlService(String.join("/", fusekiProperties.getEndpoint(),
                        fusekiProperties.getDataset(),
                        fusekiProperties.getQuery()), sparqlQuery);

        ResultSet result = queryExecution.execSelect();

        String path = JSON_FILE + String.format("%s.json", id);
        OutputStream output = new FileOutputStream(path);

        ResultSetFormatter.outputAsJSON(output, result);

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    public String getDocumentMetaDataByIdAsRDF(String type, String id)
            throws FileNotFoundException {
        String sparqlQuery = SparqlUtil.describeData(
                type,
                String.format("http://team14.xml.com/rdf/%s/%s", type, id),
                this.fusekiProperties.getDataEndpoint() + "/" + type,
                String.format("<http://localhost:4200/%s/%s>  ?p  ?o", type, id));

        QueryExecution queryExecution = QueryExecutionFactory
                .sparqlService(String.join("/", fusekiProperties.getEndpoint(),
                        fusekiProperties.getDataset(),
                        fusekiProperties.getQuery()), sparqlQuery);

        String path = RDF_FILE + String.format("%s.ttl", id);
        OutputStream output = new FileOutputStream(path);

        Model describeModel = queryExecution.execDescribe();
        describeModel.write(output, "TURTLE");

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
