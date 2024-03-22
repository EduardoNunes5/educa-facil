package br.com.eduardonunesdev.educafacil.model;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private Long id;

    private String name;

    private String username;

    private String password;

    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole role;

}

/*
*     id SERIAL primary key,
    name VARCHAR(100),
    username VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(20),
    created_at timestamp default current_timestamp,
    user_role enum ('ESTUDANTE', 'INSTRUTOR', 'ADMIN')
* */