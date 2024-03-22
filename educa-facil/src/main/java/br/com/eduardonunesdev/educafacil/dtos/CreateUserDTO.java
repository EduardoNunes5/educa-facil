package br.com.eduardonunesdev.educafacil.dtos;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
import br.com.eduardonunesdev.educafacil.validation.username.UsernameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        String nome,
        @NotBlank
        @Size(max = 20)
        @UsernameValid(message = "O usuário deve conter apenas letras minúsculas, não possuir espaços em branco e não possuir números")
        String username,
        String senha,
        @Email String email,
        UserRole role

) {
}
