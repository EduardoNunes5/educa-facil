package br.com.eduardonunesdev.educafacil.exceptions;

import java.util.List;

public record CustomErrorResponse(
        String error,
        int status,
        List<CustomErrorDetail> errors
) {
}
