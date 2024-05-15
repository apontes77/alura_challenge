package com.alura.technicalchallenge.domain.exceptions;

public class CourseInactiveException extends RuntimeException {
    public CourseInactiveException() {
        super("The course is inactive and does not accept new registrations.");
    }
}
