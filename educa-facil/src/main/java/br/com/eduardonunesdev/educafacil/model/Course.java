package br.com.eduardonunesdev.educafacil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    @JoinColumn(name = "instrutor_id")
    private User user;

    @Column(length = 200)
    private String descricao;

    private boolean status = true;

    private LocalDate createdAt;

    private LocalDate dataInativacao;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDate.now();
    }
}
