package br.com.eduardonunesdev.educafacil.dtos;

import br.com.eduardonunesdev.educafacil.enums.UserRole;

public record UserInformationDTO(
        String nome,
        String email,
        UserRole role
) {
}
