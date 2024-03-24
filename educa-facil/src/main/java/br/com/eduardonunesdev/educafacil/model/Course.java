package br.com.eduardonunesdev.educafacil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @Column(length = 10)
    private String codigo;

    private String nome;

    @ManyToOne
    @Column(name = "instrutor_id")
    private User user;

    @Column(length = 200)
    private String descricao;

    private boolean status;

    private LocalDate createdAt;

    private LocalDate dataInativacao;
}
