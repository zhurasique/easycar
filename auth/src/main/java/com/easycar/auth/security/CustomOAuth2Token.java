package com.easycar.auth.security;

import com.easycar.auth.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class CustomOAuth2Token {

    private final String accessToken;
    private final String refreshToken;

    public CustomOAuth2Token(Authentication authentication, String secret, int lifetime) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + lifetime * 1000L);
        accessToken = Jwts.builder()
                    .setSubject(((User) authentication.getPrincipal()).getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        refreshToken = Jwts.builder()
                .setSubject(((User) authentication.getPrincipal()).getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
