package br.com.eduardonunesdev.educafacil.dtos.course;

public record CreateCourseDTO(
        String codigo,
        String nome,
        Long instrutorId,
        String descricao,
        boolean status
) {
}
