package br.com.eduardonunesdev.educafacil.controllers;

import br.com.eduardonunesdev.educafacil.dtos.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.dtos.CreateUserResponseDTO;
import br.com.eduardonunesdev.educafacil.dtos.UserInformationDTO;
import br.com.eduardonunesdev.educafacil.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponseDTO createUser(@RequestBody @Valid CreateUserDTO dto){
        return userService.createUser(dto);
    }

    @GetMapping("/{username}")
    public UserInformationDTO getUserInformation(@PathVariable String username){
        return userService.getUserInformation(username);
    }
}
