package com.finanzas.app.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * Servicio JWT
 * No depende de Spring Security, solo crea y valida tokens
 */
@Service
public class JwtService {

	/**
     * Clave secreta
     * ⚠️ MÍNIMO 32 caracteres para HS256
     * En producción va en variable de entorno
     */
    private final String SECRET = "clave_super_secreta_12345678901234567890";
    
    /**
     * Tiempo de expiración (24hs)
     */
    private static final long EXPIRATION_MS = 1000 * 60 * 60 * 24;

    /**
     * Clave criptográfica generada desde el String
     */
    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    /**
     * Genera un JWT firmado
     */
    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS)) // 1 día
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extraerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    /**
     * Extrae el email (subject) del token
     */
    public String extraerEmail(String token) {
        return extraerClaims(token).getSubject();
    }

    /**
     * Valida firma + expiración
     */
    public boolean esValido(String token) {
        try {
        	extraerClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}