package com.alura.technicalchallenge.controller.course.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeValidator.class)
public @interface ValidCourseCode {
    String message() default "Course code is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}