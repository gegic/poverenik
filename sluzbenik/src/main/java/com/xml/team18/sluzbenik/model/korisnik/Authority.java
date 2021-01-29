package com.xml.team18.sluzbenik.model.korisnik;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private String authorityName;
    @Override
    public String getAuthority() {
        return this.authorityName;
    }
}
