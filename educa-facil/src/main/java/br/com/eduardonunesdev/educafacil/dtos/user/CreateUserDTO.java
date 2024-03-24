package br.com.eduardonunesdev.educafacil.dtos.user;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
import br.com.eduardonunesdev.educafacil.services.validation.UniqueUserValid;
import br.com.eduardonunesdev.educafacil.services.validation.UsernameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@UniqueUserValid
public record CreateUserDTO(
        String nome,
        @NotBlank
        @Size(max = 20)
        @UsernameValid(message = "O usuário deve conter apenas letras minúsculas, não possuir espaços em branco e não possuir números")
        String username,

        @NotBlank
        String senha,
        @Email String email,
        UserRole role

) {
}
