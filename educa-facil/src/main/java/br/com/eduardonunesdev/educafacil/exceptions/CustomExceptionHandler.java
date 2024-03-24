package br.com.eduardonunesdev.educafacil.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<CustomErrorDetail> errors = new ArrayList<>();
        errors.addAll(getFieldErrors(ex.getFieldErrors()));
        errors.addAll(getGlobalErrors(ex.getGlobalErrors()));


        CustomErrorResponse customErrorResponse = new CustomErrorResponse("Erro de validação", status.value(), errors);
        return ResponseEntity.status(status).body(customErrorResponse);
    }

    private List<CustomErrorDetail> getFieldErrors(List<FieldError> fieldErrors){
        return fieldErrors
                .stream().map(fieldError -> new CustomErrorDetail(
                        fieldError.getField().toUpperCase(),
                        fieldError.getDefaultMessage())
                )
                .toList();
    }

    private List<CustomErrorDetail> getGlobalErrors(List<ObjectError> globalErrors){
        return globalErrors
                .stream().map(ge -> new CustomErrorDetail(
                        ge.getObjectName(),
                        ge.getDefaultMessage()
                )).toList();
    }
}
