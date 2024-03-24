package br.com.eduardonunesdev.educafacil.services.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserValid {
    String message() default "Usuário inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
