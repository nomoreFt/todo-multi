package com.nomoreft.todoapp.web.jwt.support;

import com.nomoreft.todoapp.foundation.exception.NotImplementedException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenUtil {
    private final long accessTokenExpiration;

    private final long refreshTokenExpiration;

    private final String secret;

    public JwtTokenUtil(
            @Value("${jwt.access-token-expiration:99999}") long accessTokenExpiration,
            @Value("${jwt.refresh-token-expiration:99999}") long refreshTokenExpiration,
            @Value("${jwt.secret-key:local}") String secret
    ) {
        this.accessTokenExpiration = accessTokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
        this.secret = secret;
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(UserDetails userDetails) {
/*        if(userDetails instanceof PsgUserDetails psgUserDetails) {
            return generateToken(userDetails.getUsername(), accessTokenExpiration, psgUserDetails.getCompanyId());
        }
        return generateToken(userDetails.getUsername(), accessTokenExpiration);*/
        throw new NotImplementedException();
    }

    public String generateRefreshToken(UserDetails userDetails) {
/*        if(userDetails instanceof PsgUserDetails psgUserDetails) {
            return generateToken(userDetails.getUsername(), refreshTokenExpiration, psgUserDetails.getCompanyId());
        }
        return generateToken(userDetails.getUsername(), refreshTokenExpiration);*/
        throw new NotImplementedException();
    }

    private String generateToken(String username, long expirationTime) {
        /*return generateToken(username, expirationTime, null);*/
        throw new NotImplementedException();
    }

    public String getUsernameRefreshToken(String token) {
/*        try {
            return getUsernameFromToken(token);
        } catch (ExpiredJwtException e) {
            throw new RefreshTokenExpiredExceptions("Refresh token is expired", e);
        }*/
        throw new NotImplementedException();
    }

    public String getUsernameAccessToken(String token) {
/*        try {
            return getUsernameFromToken(token);
        } catch (ExpiredJwtException e) {
            throw new AccessTokenExpiredExceptions("Access token is expired", e);
        }*/
        throw new NotImplementedException();
    }

    private String getUsernameFromToken(String token) {
/*        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();*/
        throw new NotImplementedException();
    }
}