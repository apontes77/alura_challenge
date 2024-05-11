package com.alura.technicalchallenge.controller.user.request;

import com.alura.technicalchallenge.domain.enums.Role;
import jakarta.validation.constraints.Pattern;

public class UserRegisterRequest {

    private String name;

    @Pattern(regexp = "^[a-z]*$", message = "username must contain only lowercase characters")
    private String username;
    @Pattern(regexp = "/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i", message = "e-mail must be valid")
    private String email;
    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$", message = "password must be between 8 and 10 characters, contain at least one\n" +
            "digit and one alphabetic character, and must not contain special characters")
    private String password;
    private Role role;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String name, String username, String email, String password, Role role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
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
}
