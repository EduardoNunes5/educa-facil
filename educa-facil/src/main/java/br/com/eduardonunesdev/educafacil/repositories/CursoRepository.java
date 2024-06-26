package br.com.eduardonunesdev.educafacil.repositories;

import br.com.eduardonunesdev.educafacil.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Course, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Course c set c.status = false, c.dataInativacao = current_date  where c.codigo = ?1")
    void deactivateCourse(String codigo);

    @Query(value = "SELECT c FROM Course c JOIN FETCH c.user u where c.status = :status")
    Page<Course> findByStatus(Pageable pageable, @Param("status") Boolean status);

    Optional<Course> findByCodigoAndStatusTrue(String codigo);
}
