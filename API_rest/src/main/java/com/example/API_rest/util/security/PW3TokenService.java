package com.example.API_rest.util.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.API_rest.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class PW3TokenService {
    @Value("${pw3.senha.principal.geracao.token}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        System.out.println(secret);
        try {
            var instanciaAlgoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("DISCIPLINA PW3")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(instanciaAlgoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Ocorreu um erro ao gerar o token ", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var instanciaAlgoritmo = Algorithm.HMAC256(secret);
            JWTVerifier jwtv = JWT.require(instanciaAlgoritmo)
                    .withIssuer("DISCIPLINA PW3")
                    .build();
            return jwtv.verify(tokenJWT).getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
