package com.xml.team18.sluzbenik.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "email",
        "lozinka"
})
@XmlRootElement(name = "prijava")
public class PrijavaDto {
    @XmlElement(required = true)
    @NotNull(message = "E-mail ne moze biti null.")
    @Email(message = "Format e-maila nije validan")
    private String email;

    @XmlElement(required = true)
    @NotNull(message = "Lozinka ne moze biti null")
    @Size(min = 6, max = 15, message = "Lozinka mora imati vise od 6 i manje od 15 karaktera")
    private String lozinka;
}
