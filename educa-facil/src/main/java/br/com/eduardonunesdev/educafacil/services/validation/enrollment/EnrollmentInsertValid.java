package br.com.eduardonunesdev.educafacil.services.validation.enrollment;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EnrollmentInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnrollmentInsertValid {
    String message() default "O usuário já está matriculado no curso!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
