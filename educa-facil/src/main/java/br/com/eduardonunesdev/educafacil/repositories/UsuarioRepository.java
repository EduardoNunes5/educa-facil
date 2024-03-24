package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.dtos.user.UserInformationDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.dtos.validation.EmailUsernameCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    UserInformationDTO findByEmail(String email);

    @Query(
            value = """
        select new br.com.eduardonunesdev.educafacil.dtos.validation.EmailUsernameCountDTO(
            coalesce((select count(u) from User u where u.username = ?1), 0),
            coalesce((select count(u) from User u where u.email = ?2), 0)
        )       
    """
    )
    EmailUsernameCountDTO countUsernameAndEmail(String username, String email);

}
