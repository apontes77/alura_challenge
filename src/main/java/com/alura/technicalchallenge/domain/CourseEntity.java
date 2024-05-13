package com.alura.technicalchallenge.domain;

import com.alura.technicalchallenge.domain.enums.CourseStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_tb")
@Getter
@Setter
@NoArgsConstructor
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
}
