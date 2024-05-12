package com.alura.technicalchallenge.controller.enrollment;

import com.alura.technicalchallenge.controller.course.CourseController;
import com.alura.technicalchallenge.controller.enrollment.request.EnrollmentRequest;
import com.alura.technicalchallenge.domain.EnrollmentEntity;
import com.alura.technicalchallenge.usecase.enrollment.EnrollmentUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/enrollment", produces = APPLICATION_JSON_VALUE)
public class EnrollmentController {

    private final EnrollmentUseCase enrollmentUseCase;
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
    private static final String ENROLLMENT_CREATED_URI = "/enrollment/{enrollmentId}";

    public EnrollmentController(EnrollmentUseCase enrollmentUseCase) {
        this.enrollmentUseCase = enrollmentUseCase;
    }

    @PostMapping
    public ResponseEntity<String> creatingEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        try {
            var enrollmentMade = enrollmentUseCase.doEnrollment(enrollmentRequest);

            if (enrollmentMade.isPresent()) {
                EnrollmentEntity enrollmentEntity = enrollmentMade.get();

                URI createdUri = URI.create(ENROLLMENT_CREATED_URI.replace("{enrollmentId}", enrollmentEntity.getId().toString()));

                return ResponseEntity.created(createdUri).build();
            } else {
                return ResponseEntity.badRequest().body("Creating enrollment has failed");
            }
        } catch (Exception e) {
            logger.error("Internal error creating course", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
