package com.alura.technicalchallenge.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userAlreadyExists) {
        super(userAlreadyExists);
    }
}
