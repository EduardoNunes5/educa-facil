package br.com.eduardonunesdev.educafacil.controllers;

import br.com.eduardonunesdev.educafacil.dtos.authentication.LoginRequestDTO;
import br.com.eduardonunesdev.educafacil.dtos.authentication.LoginResponseDTO;
import br.com.eduardonunesdev.educafacil.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public LoginResponseDTO authenticate(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        return service.authenticate(loginRequestDTO);
    }
}
