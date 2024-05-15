package com.alura.technicalchallenge.services.course_evaluation;

import com.alura.technicalchallenge.domain.CourseEvaluationEntity;
import com.alura.technicalchallenge.repository.CourseEvaluationRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseEvaluationService {


    private final CourseEvaluationRepository repository;

    public CourseEvaluationService(CourseEvaluationRepository repository) {
        this.repository = repository;
    }

    public void persistEvaluation(CourseEvaluationEntity entity) {
        repository.save(entity);
    }
}
