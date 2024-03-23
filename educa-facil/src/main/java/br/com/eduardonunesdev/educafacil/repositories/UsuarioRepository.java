package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.dtos.UserInformationDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    UserInformationDTO findByEmail(String email);
}
