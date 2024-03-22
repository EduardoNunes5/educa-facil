package br.com.eduardonunesdev.usuario.dtos;

import br.com.eduardonunesdev.usuario.enums.UserRole;
import br.com.eduardonunesdev.usuario.validation.username.UsernameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        String name,
        @NotBlank
        @Size(max = 20)
        @UsernameValid(message = "O usuário deve conter apenas letras minúsculas, não possuir espaços em branco e não possuir números")
        String username,
        String password,
        @Email String email,
        UserRole role

) {
}
