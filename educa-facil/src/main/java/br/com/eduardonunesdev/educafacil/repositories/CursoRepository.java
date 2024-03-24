package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Course, String> {
}
