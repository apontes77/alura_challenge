package com.alura.technicalchallenge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "course-evaluation-tb")
@Getter
public class CourseEvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_id")
    private Long courseId;
    private Integer grade;
    @Column(name = "grade_explanation_subject")
    private String gradeExplanationSubject;
    @Column(name = "grade_explanation_body")
    private String gradeExplanationBody;

    public CourseEvaluationEntity(Long id, Long courseId, Integer grade, String gradeExplanationSubject, String gradeExplanationBody) {
        this.id = id;
        this.courseId = courseId;
        this.grade = grade;
        this.gradeExplanationSubject = gradeExplanationSubject;
        this.gradeExplanationBody = gradeExplanationBody;
    }

    public CourseEvaluationEntity() {
    }
}
