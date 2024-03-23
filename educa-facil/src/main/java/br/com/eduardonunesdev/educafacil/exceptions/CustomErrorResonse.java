package br.com.eduardonunesdev.educafacil.exceptions;

import java.util.List;
import java.util.Map;

public record CustomErrorResonse(
        String error,
        int status,
        List<CustomErrorDetail> errors
) {
}
