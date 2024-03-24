package br.com.eduardonunesdev.educafacil.controllers.exceptions;

public record CustomErrorDetail(
        String campo,
        String mensagem
) {
}
