package br.com.eduardonunesdev.educafacil.model;

import br.com.eduardonunesdev.educafacil.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String username;

    private String senha;

    private String email;

    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole role;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(role).map(role -> new SimpleGrantedAuthority(role.name())).toList();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}