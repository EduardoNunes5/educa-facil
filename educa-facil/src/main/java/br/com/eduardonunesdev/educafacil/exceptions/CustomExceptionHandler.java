package br.com.eduardonunesdev.educafacil.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<CustomErrorDetail> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> new CustomErrorDetail(
                        fieldError.getField().toUpperCase(),
                        fieldError.getDefaultMessage())
                )
                .toList();

        CustomErrorResonse customErrorResonse = new CustomErrorResonse("Erro de validação", status.value(), errors);
        return ResponseEntity.status(status).body(customErrorResonse);
    }
}
