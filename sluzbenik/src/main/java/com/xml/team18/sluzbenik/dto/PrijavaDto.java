package com.xml.team18.sluzbenik.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "email",
        "lozinka"
})
public class PrijavaDto {
    @XmlElement(required = true)
    @NotEmpty(message = "E-mail ne moze biti prazan ili null.")
    @Email(message = "Format e-maila nije validan")
    private String email;

    @XmlElement(required = true)
    @Size(min = 6, max = 15, message = "Lozinka mora imati vise od 6 i manje od 15 karaktera")
    private String lozinka;
}
