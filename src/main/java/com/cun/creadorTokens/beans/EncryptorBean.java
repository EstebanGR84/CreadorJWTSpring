package com.cun.creadorTokens.beans;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class EncryptorBean {
    public static String[] BasicAuthDecrypt(String encodedAuth){
        String[] token = encodedAuth.split(" ", 2);
        String decodedAuth = new String(Base64.getDecoder().decode(token[1]), StandardCharsets.UTF_8);
        String[] credentials = decodedAuth.split(":", 2);
        String username = credentials[0];
        String password = credentials[1];
        return  credentials;
    }

    public static String createJWS(String usuario){
        String issuer = "apiJWTCUN";
        long expirationMillis = 3600000; // 1 hora
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMillis);
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        JwtBuilder builder = Jwts.builder()
                .setIssuer(issuer)
                .setSubject(usuario)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, "AWpuwTVfyedZmqKsAssnqVMORPesPxBzAVSvaraArEa");
        String jwt = builder.compact();
        return jwt;
    }
}
