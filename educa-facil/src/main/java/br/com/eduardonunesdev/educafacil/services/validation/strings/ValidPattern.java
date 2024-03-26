package br.com.eduardonunesdev.educafacil.services.validation.strings;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PatternValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPattern {

    String pattern() default "";

    String message() default "Username inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
