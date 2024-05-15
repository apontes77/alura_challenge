package com.alura.technicalchallenge.usecase.course_evaluation;

import com.alura.technicalchallenge.controller.course_evaluation.request.CourseEvaluationRequest;
import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.domain.CourseEvaluationEntity;
import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.services.course_evaluation.CourseEvaluationService;
import com.alura.technicalchallenge.services.course.CourseService;
import com.alura.technicalchallenge.services.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class CourseEvaluationUseCase {

    private final CourseService courseService;
    private final UserService userService;
    private final CourseEvaluationService courseEvaluationService;

    public CourseEvaluationUseCase(CourseService courseService, UserService userService, CourseEvaluationService courseEvaluationService) {
        this.courseService = courseService;
        this.userService = userService;
        this.courseEvaluationService = courseEvaluationService;
    }

    public void creatingEvaluation(CourseEvaluationRequest request) {
        CourseEntity course = courseService.getCourseByCode(request.courseCode());

        UserEntity user = userService.getUser(course.getInstructor());
        if(request.grade() < 6) {
            EmailSender.send(user.getEmail(), request.subject(), request.body());
        }

        courseEvaluationService.persistEvaluation(
                new CourseEvaluationEntity(
                        null,
                        course.getId(),
                        request.grade(),
                        request.subject(),
                        request.body()
                )
        );
    }
}
