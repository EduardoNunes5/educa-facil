package br.com.eduardonunesdev.educafacil.dtos.user;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
public record CreateUserResponseDTO(
        Long id,
        String nome,
        String username,
        String email,
        UserRole role
) {
}
