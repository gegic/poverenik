package com.xml.team18.sluzbenik.fuseki;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fuseki")
@Data
public class FusekiProperties {
    private String endpoint;
    private String dataset;
    private String query;
    private String update;
    private String data;

    public String getQueryEndpoint() {
        return String.join("/", endpoint, dataset, query.trim());
    }

    public String getUpdateEndpoint() {
        return String.join("/", endpoint, dataset, update);
    }

    public String getDataEndpoint() {
        return String.join("/", endpoint, dataset, data);
    }
}
