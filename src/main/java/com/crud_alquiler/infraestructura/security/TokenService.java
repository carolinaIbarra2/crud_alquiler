package com.crud_alquiler.infraestructura.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String apiSecert;

    public String generatedToken(Usuario admin){
        try {
            var algorithm = Algorithm.HMAC256(apiSecert);
            return JWT.create()
                    .withIssuer("CRUD ALQUILER")
                    .withSubject(admin.getLogin())
                    .withClaim("id", admin.getId())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        if (tokenJWT == null){
            throw new RuntimeException();
        }
        try {
            var algorithm = Algorithm.HMAC256(apiSecert);
            return JWT.require(algorithm)
                    .withIssuer("CRUD ALQUILER")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido o expirado!");
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
