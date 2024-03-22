package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    
}
