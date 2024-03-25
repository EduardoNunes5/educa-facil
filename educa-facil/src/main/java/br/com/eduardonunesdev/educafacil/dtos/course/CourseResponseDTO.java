package br.com.eduardonunesdev.educafacil.dtos.course;

import br.com.eduardonunesdev.educafacil.dtos.user.UserInformationDTO;

import java.time.LocalDate;

public record CourseResponseDTO(
        String codigo,
        String nome,
        UserInformationDTO instrutor,
        String descricao,
        LocalDate dataInativacao
) {
}
