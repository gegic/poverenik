package com.xml.team18.sluzbenik.dto;

import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "token",
        "korisnik"
})
@XmlRootElement(name = "odgovor")
public class TokenOdgovor {
    @XmlElement(required = true)
    private String token;
    @XmlElement(required = true)
    private Korisnik korisnik;
}
