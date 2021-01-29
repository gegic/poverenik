package com.xml.team18.poverenik.security;

import com.xml.team18.poverenik.model.korisnik.Korisnik;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
public class Token extends AbstractAuthenticationToken {

    @Getter
    @Setter
    private String credentials; // TOKEN

    @Getter
    private final Korisnik principal;

    public Token(Korisnik user) {
        super(user.getAuthorities());
        this.principal = user;
    }
}
