package br.com.eduardonunesdev.educafacil.services.validation.enrollment;

import br.com.eduardonunesdev.educafacil.dtos.enrollment.UserEnrollmentDTO;
import br.com.eduardonunesdev.educafacil.services.EnrollmentService;
import br.com.eduardonunesdev.educafacil.services.contracts.AuthenticatedUserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnrollmentInsertValidator implements ConstraintValidator<EnrollmentInsertValid, UserEnrollmentDTO> {

    private final EnrollmentService service;
    private final AuthenticatedUserService authenticatedUserService;

    public EnrollmentInsertValidator(EnrollmentService service, AuthenticatedUserService authenticatedUserService) {
        this.service = service;
        this.authenticatedUserService = authenticatedUserService;
    }

    @Override
    public boolean isValid(UserEnrollmentDTO value, ConstraintValidatorContext context) {

        var currentUserId = authenticatedUserService.getLoggedInUser().getId();

        var sameId = currentUserId.equals(value.usuarioId());
        if(!sameId){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Usuario tentando matricular outra pessoa")
                    .addPropertyNode("usuarioId")
                    .addConstraintViolation();
            return false;
        }

        boolean isEnrolled = service.existsById(value.usuarioId(), value.codigoCurso());
        if (isEnrolled) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Usuario já matriculado no curso!")
                    .addPropertyNode("usuarioId")
                    .addConstraintViolation()
                    .buildConstraintViolationWithTemplate("Curso já possui o aluno matriculado!")
                    .addPropertyNode("codigoCurso")
                    .addConstraintViolation();
        }
        return !isEnrolled;
    }
}
