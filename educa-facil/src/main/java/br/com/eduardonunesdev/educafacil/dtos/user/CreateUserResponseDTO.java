package br.com.eduardonunesdev.educafacil.dtos;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
public record CreateUserResponseDTO(
        Long id,
        String nome,
        String username,
        String email,
        UserRole role
) {
}
