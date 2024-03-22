package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.dtos.CreateUserResponseDTO;
import br.com.eduardonunesdev.educafacil.mappers.UserMapper;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public CreateUserResponseDTO createUser(CreateUserDTO dto){
        User user = mapper.convertToEntity(dto);
        encryptPassword(user);
        usuarioRepository.save(user);
        return mapper.convertToResponse(usuarioRepository.save(user));
    }

    private void encryptPassword(User user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
    }


    
}
