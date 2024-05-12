package com.alura.technicalchallenge.controller.course;

import com.alura.technicalchallenge.controller.course.request.CourseRequest;
import com.alura.technicalchallenge.controller.course.response.CourseResponse;
import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.usecase.course.CourseUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping(value = "/{course-code}")
    public ResponseEntity<Void> inactivatingCourse(@PathVariable String courseCode) {
        final CourseEntity courseEntity = courseUseCase.inactivatingCourse(courseCode);

        if (courseEntity != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/{status}")
    public ResponseEntity<Page<CourseResponse>> listCourses(@PathVariable String status, Pageable pageable) {
        Page<CourseResponse> courseResponses = courseUseCase.adaptingPageableListOfCourses(status, pageable);
        return ResponseEntity.ok(courseResponses);
    }
}