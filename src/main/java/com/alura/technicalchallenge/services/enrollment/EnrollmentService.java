package com.alura.technicalchallenge.services.enrollment;

import com.alura.technicalchallenge.domain.EnrollmentEntity;
import com.alura.technicalchallenge.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public Optional<EnrollmentEntity> findOccurrencesOfUserAndCourse(Long userId, Long courseId) {
        return repository.findByUserIdAndCourseId(userId, courseId);
    }

    public Optional<EnrollmentEntity> register(EnrollmentEntity enrollmentEntity) {
        return Optional.of(repository.save(enrollmentEntity));
    }
}
