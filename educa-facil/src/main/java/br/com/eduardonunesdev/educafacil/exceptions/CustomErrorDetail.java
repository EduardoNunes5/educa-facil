package br.com.eduardonunesdev.educafacil.exceptions;

public record CustomErrorDetail(
        String campo,
        String mensagem
) {
}
