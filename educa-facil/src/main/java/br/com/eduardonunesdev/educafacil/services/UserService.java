package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.dtos.CreateUserResponseDTO;
import br.com.eduardonunesdev.educafacil.dtos.UserInformationDTO;
import br.com.eduardonunesdev.educafacil.mappers.UserMapper;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

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

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário com o username " + username + " não encontrado"));
    }

    public UserInformationDTO getUserInformation(String email) {
        return usuarioRepository.findByUsername(email)
                .map(user -> new UserInformationDTO(user.getNome(),user.getEmail(),user.getRole()))
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }
}
