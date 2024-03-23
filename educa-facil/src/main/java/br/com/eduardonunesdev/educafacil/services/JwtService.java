package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class JwtService {

    private String jwtSecret;

    public JwtService(@Value("${jwt.secret}") String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        Instant issuedAt = Instant.now();
        return JWT.create()
                .withIssuer("auth0")
                .withSubject(user.getUsername())
                .withIssuedAt(issuedAt)
                .withExpiresAt(issuedAt.plus(30, ChronoUnit.MINUTES))
                .sign(algorithm);
    }

    public String validateToken(String jwt){
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()
                    .verify(jwt);

            return decodedJWT.getSubject();
        }
        catch (JWTVerificationException jve){
            log.info("Failed validating token");
            return "";
        }
    }
}
