package com.alura.technicalchallenge.controller.user;

import com.alura.technicalchallenge.controller.user.request.UserRequest;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.usecase.user.UserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<UserEntity> obtainUserData(@RequestBody UserRequest request) {
        var userObtained = useCase.getUserInformation(request);

        return ResponseEntity.ok(userObtained);

    }
}
