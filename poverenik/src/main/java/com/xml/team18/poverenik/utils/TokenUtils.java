package com.xml.team18.poverenik.utils;

import com.xml.team18.poverenik.model.korisnik.Korisnik;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private static String secret = "dJe $i $ta cXini$";

    private static Long expiration = 18000l;


    public static String getToken(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        // JWT se prosledjuje kroz header Authorization u formatu:
        // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getAllClaimsFromToken(token);
            username = claims.get("username").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private static Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static boolean validateToken(String token, Korisnik user) {
        final String username = getUsernameFromToken(token);
        return username != null && username.equals(user.getUsername());
    }

    public static Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

    public static String generateToken(Korisnik user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        return Jwts.builder().setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

}