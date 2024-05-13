package com.alura.technicalchallenge.controller.user.request;

import com.alura.technicalchallenge.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRegisterRequest {

    private String name;

    @Pattern(regexp = "^[a-z]+$", message = "Username must contain only lowercase characters")
    private String username;

    @Email
    private String email;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}", message = "Password must be 8-10 characters, contain at least one digit, one lowercase letter, and one uppercase letter")
    private String password;

    private Role role;
}
