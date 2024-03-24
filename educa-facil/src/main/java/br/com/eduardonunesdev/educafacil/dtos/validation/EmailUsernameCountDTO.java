package br.com.eduardonunesdev.educafacil.dtos.validation;

public record EmailUsernameCountDTO(
        long usernameCount,
        long emailCount
) {
}
