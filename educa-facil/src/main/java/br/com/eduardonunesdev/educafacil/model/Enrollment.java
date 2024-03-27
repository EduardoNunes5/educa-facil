package br.com.eduardonunesdev.educafacil.model;


import br.com.eduardonunesdev.educafacil.model.key.EnrollmentPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_enrollment")
public class Enrollment implements Persistable<EnrollmentPK>{
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    private LocalDate dataMatricula;

    @MapsId("codigoCurso")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", insertable = false, updatable = false)
    private Course curso;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User usuario;

    @Transient
    private boolean isNew = true;

    @PrePersist
    public void prePersist(){
        this.dataMatricula = LocalDate.now();
    }

    public boolean isNew() {
        return isNew;
    }

    public void enroll(User user, Course course){
        this.usuario = user;
        this.curso = course;
    }
}
