package com.xml.team18.sluzbenik.fuseki;

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
    private FusekiReader(FusekiProperties fusekiProperties) {
        this.fusekiProperties = fusekiProperties;
    }

    public ResultSet getDocumentMetaDataById(String sparqlQuery) {
        QueryExecution queryExecution = QueryExecutionFactory
                .sparqlService(String.join("/", fusekiProperties.getEndpoint(),
                        fusekiProperties.getDataset(),
                        fusekiProperties.getQuery()), sparqlQuery);
        return queryExecution.execSelect();
    }
}
