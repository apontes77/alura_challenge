package com.alura.technicalchallenge.domain.exceptions;

public class UserAlreadyEnrolledException extends RuntimeException {
    public UserAlreadyEnrolledException() {
        super("The user is already enrolled in this course.");
    }
}
