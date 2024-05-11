package com.alura.technicalchallenge.controller.user.response;

import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.domain.enums.Role;

public record UserResponse (String name, String email, Role role){

    public static UserResponse fromEntity(UserEntity userEntity) {
        return new UserResponse(userEntity.getName(), userEntity.getEmail(), userEntity.getRole());
    }
}
