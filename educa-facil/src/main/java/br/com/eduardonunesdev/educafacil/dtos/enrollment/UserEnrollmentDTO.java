package br.com.eduardonunesdev.educafacil.dtos.enrollment;

import br.com.eduardonunesdev.educafacil.services.validation.enrollment.EnrollmentInsertValid;

@EnrollmentInsertValid
public record UserEnrollmentDTO(
        Long usuarioId,
        String codigoCurso
) {
}
