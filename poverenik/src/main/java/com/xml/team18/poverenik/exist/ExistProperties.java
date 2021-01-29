package com.xml.team18.poverenik.exist;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exist")
@Data
public class ExistProperties {
    private String user;
    private String password;
    private String host;
    private String port;
    private String driver;
    private String uri;
}