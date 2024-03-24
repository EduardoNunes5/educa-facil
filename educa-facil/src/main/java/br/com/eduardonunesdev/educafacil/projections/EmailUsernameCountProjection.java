package br.com.eduardonunesdev.educafacil.projections;

public record EmailUsernameCountProjection(
        long usernameCount,
        long emailCount
) {
}
