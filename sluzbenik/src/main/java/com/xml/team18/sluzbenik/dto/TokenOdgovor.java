package com.xml.team18.sluzbenik.dto;

import com.xml.team18.sluzbenik.model.korisnik.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenOdgovor {
    private String token;
    private Korisnik korisnik;
}
