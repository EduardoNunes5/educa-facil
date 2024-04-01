package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.authentication.LoginRequestDTO;
import br.com.eduardonunesdev.educafacil.dtos.authentication.LoginResponseDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.services.contracts.AuthenticatedUserService;
import br.com.eduardonunesdev.educafacil.services.exceptions.BadRequestException;
import br.com.eduardonunesdev.educafacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticatedUserService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password());
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = jwtService.generateToken((User) auth.getPrincipal());
            return new LoginResponseDTO(token);
        }
        catch (AuthenticationException e){
            throw new BadRequestException("Usuário não encontrado ou credenciais incorretas!");
        }
    }

    @Override
    public User getLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
