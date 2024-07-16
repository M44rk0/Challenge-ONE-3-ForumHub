package com.m44rk0.forumhub.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.m44rk0.forumhub.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("api.security.token.secret")
    private String secret;

    public String generateToken(User user){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForumHub")
                    .withSubject(user.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        }
        catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar Token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API ForumHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }
        catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }

}
