package com.alura.technicalchallenge.repository;

import com.alura.technicalchallenge.domain.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
    Optional<EnrollmentEntity> findByUserIdAndCourseId(Long userId, Long courseId);
}
