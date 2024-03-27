package br.com.eduardonunesdev.educafacil.dtos.enrollment;

import br.com.eduardonunesdev.educafacil.dtos.user.UserInformationDTO;

import java.time.LocalDate;

public record EnrollmentInformationDTO(
        String nome,
        String codigo,
        LocalDate dataMatricula
) {
}
