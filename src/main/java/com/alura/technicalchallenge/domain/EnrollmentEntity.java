package com.alura.technicalchallenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment_tb")
@NoArgsConstructor
@Getter
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long courseId;
    private LocalDateTime enrollmentDate;

    public EnrollmentEntity(Long id, Long userId, Long courseId, LocalDateTime enrollmentDate) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }
}
