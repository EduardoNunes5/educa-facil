package br.com.eduardonunesdev.educafacil.dtos.course;

import br.com.eduardonunesdev.educafacil.dtos.user.UserInformationDTO;

public record CreateCourseResponseDTO(
        String codigo,
        String nome,
        UserInformationDTO instrutor,
        String descricao
) {
}
