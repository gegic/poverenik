package com.xml.team18.sluzbenik.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "to", "subject", "content" })
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "email-dto")
public class EmailDto {
    @XmlElement(required = true)
    private String to;
    @XmlElement(required = true)
    private String subject;
    @XmlElement(required = true)
    private String content;
}
