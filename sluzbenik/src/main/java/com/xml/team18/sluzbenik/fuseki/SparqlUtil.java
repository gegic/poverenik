package com.xml.team18.sluzbenik.fuseki;

public class SparqlUtil {
    /* The following operation causes all of the triples in all of the graphs to be deleted */
    private static final String DROP_ALL = "DROP ALL";

    /* Removes all of the triples from a named graphed */
    private static final String DROP_GRAPH_TEMPLATE = "DROP GRAPH <%s>";

    /**
     * A template for creating SPARUL (SPARQL Update) query can be found here:
     * https://www.w3.org/TR/sparql11-update/
     */
    /* Insert RDF data into the default graph */
    private static final String UPDATE_TEMPLATE = "INSERT DATA { %s }";

    /* Insert RDF data to an arbitrary named graph */
    private static final String UPDATE_TEMPLATE_NAMED_GRAPH = "INSERT DATA { GRAPH <%1$s> { %2$s } }";

    /***
     *
     * PREFIX pred: <http://team14.xml.com/rdf/zahtevi/predicate/>
     * SELECT *
     * FROM <http://localhost:8082/fuseki/Sluzbenik/data/zahtevi>
     * WHERE {?s ?p ?o . filter(?p=pred:mesto-trazioca && str(?o)="mesto")}
     */

    private static final String SELECT_DISTINCT_NAMED_GRAPH_TEMPLATE =
            "PREFIX pred: <http://team14.xml.com/rdf/%1$s/predicate/> " +
            "SELECT DISTINCT ?s " +
            "FROM <%2$s> " +
            "WHERE { %3$s }";

    /* Simple SPARQL query on a named graph */
    private static final String SELECT_NAMED_GRAPH_TEMPLATE = "SELECT * FROM <%1$s> WHERE { %2$s }";

    /* Plain text RDF serialization format */
    public static final String NTRIPLES = "N-TRIPLES";

    private static final String SELECT_OBJECT_PREDICATE_NAMED_GRAPH_TEMPLATE =
            "PREFIX pred: <http://team14.xml.com/rdf/%1$s/predicate/> " +
                    "SELECT ?predicate ?object " +
                    "FROM <%2$s> " +
                    "WHERE { %3$s }";

    private static final String DESCRIBE_NAMED_GRAPH_TEMPLATE =
            "PREFIX pred: <http://team14.xml.com/rdf/%1$s/predicate/> " +
                    "DESCRIBE <%2$s> " +
                    "FROM <%3$s> " +
                    "WHERE { %4$s }";


    /* An XML serialization format for RDF data */
    public static final String RDF_XML = "RDF/XML";

    public static String dropAll() {
        return DROP_ALL;
    }

    public static String dropGraph(String graphURI) {
        return String.format(DROP_GRAPH_TEMPLATE, graphURI);
    }

    /* Inserts data to the default graph */
    public static String insertData(String ntriples) {
        return String.format(UPDATE_TEMPLATE, ntriples);
    }

    public static String insertData(String graphURI, String ntriples) {
        return String.format(UPDATE_TEMPLATE_NAMED_GRAPH, graphURI, ntriples);
    }

    public static String selectData(String graphURI, String sparqlCondition) {
        return String.format(SELECT_NAMED_GRAPH_TEMPLATE, graphURI, sparqlCondition);
    }

    public static String selectDistinctIdsForData(String type, String location, String condition) {
        return String.format(SELECT_DISTINCT_NAMED_GRAPH_TEMPLATE, type, location, condition);
    }

    public static String selectPredicateObjectData(String type, String location, String condition) {
        return String.format(SELECT_OBJECT_PREDICATE_NAMED_GRAPH_TEMPLATE, type, location, condition);
    }

    public static String describeData(String type, String subject, String location, String condition) {
        return String.format(DESCRIBE_NAMED_GRAPH_TEMPLATE, type, subject, location, condition);
    }
}
