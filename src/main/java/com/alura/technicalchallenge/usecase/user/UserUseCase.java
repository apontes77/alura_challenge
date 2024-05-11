package com.alura.technicalchallenge.usecase.user;

import com.alura.technicalchallenge.controller.user.request.UserRegisterRequest;
import com.alura.technicalchallenge.controller.user.request.UserRequest;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.domain.exceptions.UserAlreadyExistsException;
import com.alura.technicalchallenge.services.user.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserUseCase {


    private final UserService service;

    public UserUseCase(UserService service) {
        this.service = service;
    }

    public UserEntity getUserInformation(UserRequest request) {
       return service.getUser(request.username());
    }

    public UserEntity registerUser(UserRegisterRequest request) {
        Optional<UserEntity> userEntity = validateUserExistence(request.getEmail(), request.getUsername());

        if(userEntity.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        return service.saveUser(userEntity.get());
    }

    private Optional<UserEntity> validateUserExistence(String email, String username) {
        return service.searchForEmailOrUsername(email, username);
    }
}
