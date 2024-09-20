package com.challengethree.Swagger.Security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.issuer}")
    private String jwtIssuer;

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    private SecretKey getSecretKey() {
        // Decode the Base64-encoded secret key to bytes and create SecretKey
        byte[] keyBytes = Base64.getDecoder().decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().claims(claims).subject(subject).issuer(jwtIssuer).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSecretKey())
                .compact();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String getUsernameFromJWT(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(getSecretKey())
                .build();
        return parser.parseSignedClaims(token).getPayload().getSubject();
    }

    public Date extractExpiration(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(getSecretKey())
                .build();
        return parser.parseSignedClaims(token).getPayload().getExpiration();
    }
}
