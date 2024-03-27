package br.com.eduardonunesdev.educafacil.model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode(of = {"usuarioId", "codigoCurso"})
public class EnrollmentPK implements Serializable {

    private Long usuarioId;

    private String codigoCurso;
}
