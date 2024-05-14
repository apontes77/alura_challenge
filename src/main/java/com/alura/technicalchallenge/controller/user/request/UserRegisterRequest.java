package com.alura.technicalchallenge.controller.user.request;

import com.alura.technicalchallenge.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRegisterRequest {


    @NotEmpty
    private String name;

    @Pattern(regexp = "^[a-z]+$", message = "Username must contain only lowercase characters")
    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    private Role role;
}
