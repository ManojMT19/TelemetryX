package com.telemetryx.api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class JWTService
{
    private static final String SECRET = "mysecretkey123mysecretkey123mysecretkey123";

    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username)
    {
        return Jwts.builder()
                .subject(username)
                .signWith(key)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60))
                .compact();

    }

    public static String extractUsername(String token)
    {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)c
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token , String  username)
    {
        String extractedUsername = extractUsername(token);

        return extractedUsername.equals(username);
    }


}
