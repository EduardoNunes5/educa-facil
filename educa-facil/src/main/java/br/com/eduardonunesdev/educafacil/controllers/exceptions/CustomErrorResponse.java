package br.com.eduardonunesdev.educafacil.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class CustomErrorResponse extends CustomErrorMessage {
    private List<CustomErrorDetail> erros;

    public CustomErrorResponse(String message, int code, List<CustomErrorDetail> errors) {
        super(message, code);
        this.erros = errors;
    }
}
