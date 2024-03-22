package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {
}
