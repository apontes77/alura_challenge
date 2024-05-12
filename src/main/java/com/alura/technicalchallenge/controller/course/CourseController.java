package com.alura.technicalchallenge.controller.course;

import com.alura.technicalchallenge.controller.course.request.CourseRequest;
import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.usecase.course.CourseUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/course", produces = APPLICATION_JSON_VALUE)
public class CourseController {

    private final CourseUseCase courseUseCase;

    private static final String COURSE_CREATED_URI = "/course/{courseId}";

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseUseCase courseUseCase) {
        this.courseUseCase = courseUseCase;
    }

    @PostMapping
    public ResponseEntity<String> creatingCourse(@RequestBody @Valid CourseRequest request) {
        try {
            Optional<CourseEntity> courseEntityOptional = courseUseCase.createCourse(request);

            if (courseEntityOptional.isPresent()) {
                CourseEntity courseEntity = courseEntityOptional.get();

                URI createdUri = URI.create(COURSE_CREATED_URI.replace("{courseId}", courseEntity.getId().toString()));

                return ResponseEntity.created(createdUri).build();
            } else {
                return ResponseEntity.badRequest().body("Falha ao criar o curso");
            }
        } catch (Exception e) {
            logger.error("Erro interno ao criar o curso", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
