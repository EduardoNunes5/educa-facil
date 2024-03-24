package br.com.eduardonunesdev.educafacil.config.security;

import br.com.eduardonunesdev.educafacil.controllers.exceptions.CustomErrorMessage;
import br.com.eduardonunesdev.educafacil.controllers.exceptions.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        CustomErrorMessage customErrorMessage = new CustomErrorMessage(
                "Usuário não autenticado",
                HttpStatus.UNAUTHORIZED.value()
        );

        mapper.writeValue(response.getOutputStream(), customErrorMessage);
    }

}
