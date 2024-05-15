package com.alura.technicalchallenge.repository;

import com.alura.technicalchallenge.domain.CourseEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluationEntity, Long> {
}
