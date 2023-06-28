package com.pragma.powerup.usermicroservice.config.security.jwt;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PrincipalUser;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final Key secretKey;
    @Value("${jwt.expiration}")
    private int expiration;

    public JwtProvider(@Value("${jwt.secret}") String key) {
        this.secretKey = Keys.hmacShaKeyFor(key.getBytes());
    }


    public String generateToken(Authentication authentication) {
        PrincipalUser userPrincipal = (PrincipalUser) authentication.getPrincipal();
        List<String> authorities = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setId(userPrincipal.getId())
                .setSubject(userPrincipal.getUsername())
                .claim("rol", authorities.get(0))
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180L))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
