package br.com.eduardonunesdev.educafacil.dtos.course;

import br.com.eduardonunesdev.educafacil.constants.RegexConstants;
import br.com.eduardonunesdev.educafacil.services.validation.course.UniqueCourse;
import br.com.eduardonunesdev.educafacil.services.validation.strings.ValidPattern;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCourseDTO(

        @Size(min = 1, max = 10, message = "Código deve ter no máximo 10 caracteres")
        @ValidPattern(
                pattern = RegexConstants.VALID_COURSE_CODE,
                message = "Código deve possuir apenas caracteres minúsculos e ser separado por hífen."
        )
        @UniqueCourse
        String codigo,
        String nome,

        @NotNull(message = "O id do instrutor deve ser informado!")
        Long instrutorId,
        String descricao
) {
}
