package br.com.eduardonunesdev.educafacil.controllers.exceptions;

import lombok.Getter;
import java.util.List;

@Getter
public class ExpandedErrorResponse extends CustomErrorMessage {
    private List<CustomErrorDetail> erros;

    public ExpandedErrorResponse(String message, int code, List<CustomErrorDetail> errors) {
        super(message, code);
        this.erros = errors;
    }
}
