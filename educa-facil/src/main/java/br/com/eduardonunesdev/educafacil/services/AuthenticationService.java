package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.LoginRequestDTO;
import br.com.eduardonunesdev.educafacil.dtos.LoginResponseDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = jwtService.generateToken((User) auth.getPrincipal());
        return new LoginResponseDTO(token);
    }
}
