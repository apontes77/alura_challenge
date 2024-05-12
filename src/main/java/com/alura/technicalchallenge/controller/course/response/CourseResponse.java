package com.alura.technicalchallenge.controller.course.response;

import com.alura.technicalchallenge.domain.CourseEntity;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public record CourseResponse (
        String name,
        String code,
        String description,
        LocalDateTime creationDate
){

    public static Page<CourseResponse> toResponse(Page<CourseEntity> courseEntity) {

        return courseEntity.map(course -> new CourseResponse(
                course.getName(),
                course.getCode(),
                course.getDescription(),
                course.getCreationDate()
        ));
    }
}
