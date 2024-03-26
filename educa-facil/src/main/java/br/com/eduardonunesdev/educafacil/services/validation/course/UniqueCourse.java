package br.com.eduardonunesdev.educafacil.services.validation.course;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCourseValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCourse {
    String message() default "Curso com o código informado já existe.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
