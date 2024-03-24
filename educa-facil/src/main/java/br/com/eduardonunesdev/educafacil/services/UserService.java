package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.user.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.dtos.user.CreateUserResponseDTO;
import br.com.eduardonunesdev.educafacil.dtos.user.UserInformationDTO;
import br.com.eduardonunesdev.educafacil.enums.UserRole;
import br.com.eduardonunesdev.educafacil.mappers.UserMapper;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.dtos.validation.EmailUsernameCountDTO;
import br.com.eduardonunesdev.educafacil.repositories.UsuarioRepository;
import br.com.eduardonunesdev.educafacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public CreateUserResponseDTO createUser(CreateUserDTO dto) {
        User user = mapper.convertToEntity(dto);
        encryptPassword(user);
        usuarioRepository.save(user);
        return mapper.convertToResponse(usuarioRepository.save(user));

    }

    private void encryptPassword(User user) {
        user.setSenha(passwordEncoder.encode(user.getSenha()));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário com o username " + username + " não encontrado"));
    }

    public UserInformationDTO getUserInformation(String username) {
        return usuarioRepository.findByUsername(username)
                .map(user -> new UserInformationDTO(user.getNome(), user.getEmail(), user.getRole()))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
    }

    public EmailUsernameCountDTO countEmailAndUsername(CreateUserDTO dto) {
        return usuarioRepository.countUsernameAndEmail(dto.username(), dto.email());
    }

    public User getUserByIdAndRole(Long id, UserRole role){
        return usuarioRepository.findByIdAndRoleIs(id, role)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado ou não é instrutor."));
    }

}
