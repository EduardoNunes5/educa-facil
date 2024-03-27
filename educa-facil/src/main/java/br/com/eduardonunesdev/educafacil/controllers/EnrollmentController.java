package br.com.eduardonunesdev.educafacil.controllers;

import br.com.eduardonunesdev.educafacil.dtos.enrollment.EnrollmentInformationDTO;
import br.com.eduardonunesdev.educafacil.dtos.enrollment.UserEnrollmentDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.services.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentInformationDTO enroll(@AuthenticationPrincipal User authenticatedUser, @RequestBody @Valid UserEnrollmentDTO dto){
        return service.enroll(authenticatedUser, dto);
    }
}
