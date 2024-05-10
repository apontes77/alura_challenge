package com.alura.technicalchallenge.domain;

import com.alura.technicalchallenge.domain.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime creationDate;

    public UserEntity(Long id, String name, String username, String email, String password, Role role, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.creationDate = creationDate;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
