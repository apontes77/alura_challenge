package com.alura.technicalchallenge.usecase.user;

import com.alura.technicalchallenge.controller.user.request.UserRequest;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.services.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserUseCase {


    private final UserService service;

    public UserUseCase(UserService service) {
        this.service = service;
    }

    public UserEntity getUserInformation(UserRequest request) {
       return service.getUser(request.username());
    }
}
