package com.xml.team18.poverenik.fuseki;

import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Component
public class FusekiReader {
    private final FusekiProperties fusekiProperties;

    @Autowired
    private FusekiReader(FusekiProperties fusekiProperties){
        this.fusekiProperties = fusekiProperties;
    }

    public ArrayList<String> executeQuery(Map<String,String> params, String sparqlQueryTemplate) throws IOException {
        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate, params, "{{", "}}");
        QueryExecution query = QueryExecutionFactory.sparqlService(this.fusekiProperties.getQueryEndpoint(), sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundElements = new ArrayList<>();
        while(results.hasNext()){
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                System.out.println(varName + ": " + varValue);
                if(varName.contains("naziv")){
                    String value = varValue.toString();
                    foundElements.add(value);
                }
            }
        }
        ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundElements;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded,encoding);
    }
}
