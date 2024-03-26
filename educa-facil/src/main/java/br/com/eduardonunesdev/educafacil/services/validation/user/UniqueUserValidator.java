package br.com.eduardonunesdev.educafacil.services.validation.user;

import br.com.eduardonunesdev.educafacil.dtos.user.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUserValid, CreateUserDTO> {

    private final UserService service;

    public UniqueUserValidator(UserService service) {
        this.service = service;
    }

    @Override
    public boolean isValid(CreateUserDTO value, ConstraintValidatorContext context) {

        var countResult = service.countEmailAndUsername(value);

        context.disableDefaultConstraintViolation();
        if(countResult.usernameCount() > 0 && countResult.emailCount() > 0){
            context.buildConstraintViolationWithTemplate("Email e Username já cadastrados no sistema")
                    .addConstraintViolation();
            return false;
        }
        else if (countResult.usernameCount() > 0){
            context.buildConstraintViolationWithTemplate("Username já cadastrado no sistema")
                    .addConstraintViolation();
            return false;
        }
        else if (countResult.emailCount() > 0){
            context.buildConstraintViolationWithTemplate("Email já cadastrado no sistema")
                    .addConstraintViolation();
            return false;
        }


        return true;
    }
}
