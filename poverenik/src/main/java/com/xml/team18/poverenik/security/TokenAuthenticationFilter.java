package com.xml.team18.poverenik.security;

import com.xml.team18.poverenik.model.korisnik.Korisnik;
import com.xml.team18.poverenik.service.KorisnikService;
import com.xml.team18.poverenik.utils.TokenUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final KorisnikService korisnikService;

    public TokenAuthenticationFilter(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username;
        String authToken = TokenUtils.getToken(httpServletRequest);
        if (authToken != null) {
            username = TokenUtils.getUsernameFromToken(authToken);

            if (username != null) {
                try{
                    Korisnik korisnik = korisnikService.loadUserByUsername(username);
                    if (TokenUtils.validateToken(authToken, korisnik)) {
                        // kreiraj autentifikaciju
                        Token authentication = new Token(korisnik);
                        authentication.setCredentials(authToken);
                        authentication.setAuthenticated(true);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }catch (UsernameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
