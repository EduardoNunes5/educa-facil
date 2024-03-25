package br.com.eduardonunesdev.educafacil.services.validation;

import br.com.eduardonunesdev.educafacil.services.CourseService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueCourseValidator implements ConstraintValidator<UniqueCourse, String> {

    private final CourseService service;

    @Override
    public boolean isValid(String codigo, ConstraintValidatorContext context) {
        return !service.existsByCodigo(codigo);
    }
}
