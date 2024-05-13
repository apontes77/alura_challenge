package com.alura.technicalchallenge.controller.user;

import com.alura.technicalchallenge.controller.user.request.UserRegisterRequest;
import com.alura.technicalchallenge.controller.user.response.UserResponse;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.domain.exceptions.UserAlreadyExistsException;
import com.alura.technicalchallenge.usecase.user.UserUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/user", produces = APPLICATION_JSON_VALUE)

public class UserController {

    private final UserUseCase useCase;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String USER_CREATED_URI = "/users/{userId}";

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserResponse> obtainUserData(@PathVariable String username) {
        var userObtained = useCase.getUserInformation(username);

        final UserResponse userResponse = UserResponse.fromEntity(userObtained);
        return ResponseEntity.ok(userResponse);

    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserRegisterRequest request) {

        try {
            UserEntity userEntity = useCase.registerUser(request);
            URI createdUri = URI.create(USER_CREATED_URI.replace("{userId}", userEntity.getId().toString()));
            return ResponseEntity.created(createdUri).build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            logger.error(e.getCause().toString());
            return ResponseEntity.internalServerError().build();
        }
    }
}
