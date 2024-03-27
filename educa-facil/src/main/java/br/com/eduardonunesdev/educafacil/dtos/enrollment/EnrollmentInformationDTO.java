package br.com.eduardonunesdev.educafacil.dtos.enrollment;

import java.time.LocalDate;

public record EnrollmentInformationDTO(
        String nome,
        String codigo,
        LocalDate dataMatricula
) {
}
