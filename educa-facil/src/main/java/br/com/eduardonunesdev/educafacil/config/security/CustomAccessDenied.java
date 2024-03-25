package br.com.eduardonunesdev.educafacil.config.security;

import br.com.eduardonunesdev.educafacil.controllers.exceptions.CustomErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CustomAccessDenied implements AccessDeniedHandler {

    private final ObjectMapper mapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        CustomErrorMessage customErrorMessage = new CustomErrorMessage(
                "Usuário não autorizado",
                HttpStatus.FORBIDDEN.value()
        );

        mapper.writeValue(response.getOutputStream(), customErrorMessage);
    }
}
