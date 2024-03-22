package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.mappers.UserMapper;
import br.com.eduardonunesdev.educafacil.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper = UserMapper.INSTANCE;


    
}
