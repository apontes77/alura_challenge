package com.alura.technicalchallenge.domain;

import com.alura.technicalchallenge.domain.enums.CourseStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String instructor;
    private String description;
    private CourseStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime inactivationDate;


    public CourseEntity( String name, String code, String instructor, String description, CourseStatus status, LocalDateTime creationDate) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.inactivationDate = null;
    }

    public CourseEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDescription() {
        return description;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getInactivationDate() {
        return inactivationDate;
    }
}
