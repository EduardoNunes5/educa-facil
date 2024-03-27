package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.model.Enrollment;
import br.com.eduardonunesdev.educafacil.model.key.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
