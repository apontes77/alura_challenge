package com.alura.technicalchallenge.usecase.enrollment;

import com.alura.technicalchallenge.controller.enrollment.request.EnrollmentRequest;
import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.domain.EnrollmentEntity;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.domain.enums.CourseStatus;
import com.alura.technicalchallenge.domain.exceptions.CourseInactiveException;
import com.alura.technicalchallenge.domain.exceptions.UserAlreadyEnrolledException;
import com.alura.technicalchallenge.services.course.CourseService;
import com.alura.technicalchallenge.services.enrollment.EnrollmentService;
import com.alura.technicalchallenge.services.user.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class EnrollmentUseCase {


    private final EnrollmentService enrollmentService;

    private final UserService userService;

    private final CourseService courseService;

    public EnrollmentUseCase(EnrollmentService service, UserService userService, CourseService courseService) {
        this.enrollmentService = service;
        this.userService = userService;
        this.courseService = courseService;
    }

    public Optional<EnrollmentEntity> doEnrollment(EnrollmentRequest enrollmentRequest) {

        if(enrollmentValidation(enrollmentRequest)) {

            UserEntity user = userService.getUser(enrollmentRequest.username());
            CourseEntity course = courseService.getCourseByCode(enrollmentRequest.code());

            EnrollmentEntity toBeSaved = new EnrollmentEntity(null, user.getId(), course.getId(), LocalDateTime.now());
            return enrollmentService.register(toBeSaved);
        }

        return Optional.empty();

    }

    private Boolean enrollmentValidation(EnrollmentRequest request) {
       return validateThatUserEnrollOnlyOnceAtCourse(request) && validateThatUserOnlyEnrollInActiveCourses(request.code());
    }

    private Boolean validateThatUserOnlyEnrollInActiveCourses(String code) {
        CourseEntity courseByCode = courseService.getCourseByCode(code);

        if (!courseByCode.getStatus().equals(CourseStatus.ACTIVE)) {
            throw new CourseInactiveException();
        }

        return true;
    }

    private Boolean validateThatUserEnrollOnlyOnceAtCourse(EnrollmentRequest request) {
        UserEntity user = userService.getUser(request.username());
        CourseEntity course = courseService.getCourseByCode(request.code());

        Optional<EnrollmentEntity> enrollmentEntity = enrollmentService.findOccurrencesOfUserAndCourse(user.getId(), course.getId());

        if(enrollmentEntity.isPresent()) {
            throw new UserAlreadyEnrolledException();
        }

        return true;
    }
}
