package com.alura.technicalchallenge.controller.course_evaluation;

import com.alura.technicalchallenge.controller.course_evaluation.request.CourseEvaluationRequest;
import com.alura.technicalchallenge.usecase.course_evaluation.CourseEvaluationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/course-evaluation",  produces = APPLICATION_JSON_VALUE)
public class CourseEvaluationController {

    private final CourseEvaluationUseCase useCase;

    public CourseEvaluationController(CourseEvaluationUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Void> createCourseEvaluation(@RequestBody CourseEvaluationRequest request) {
        useCase.creatingEvaluation(request);
        return ResponseEntity.noContent().build();
    }
}
