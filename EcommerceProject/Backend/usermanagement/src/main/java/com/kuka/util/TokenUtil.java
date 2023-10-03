package com.kuka.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import com.kuka.exceptions.InvalidTokenException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenUtil {
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    /**
     * Encodes a JWT token with the provided username as the subject and sets an expiration time.
     *
     * @param username The username to be encoded in the token.
     * @return The JWT token as a string.
     */
    public String encode(String username) {
        long currentMillis=System.currentTimeMillis();
        long expiryMillis=currentMillis+(60*60*1000*24);
        Date expiryDate=new Date(expiryMillis);
        String token= Jwts.builder()
                .signWith(KEY)
                .setSubject(username)
                .setExpiration(expiryDate)
                .compact();
        return token;
    }
    /**
     * Decodes a JWT token to extract the username from its claims.
     *
     * @param token The JWT token to decode.
     * @return The username extracted from the token.
     * @throws InvalidTokenException If the token is invalid or empty.
     */
    public String decode(String token) {
        if (token==null || token.isEmpty()) {
            throw new InvalidTokenException("tokens not valid");
        }
        Jws<Claims> claimsHolder =Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
        Claims claims=claimsHolder.getBody();
        String username= claims.getSubject();
        return username;

    }


}
