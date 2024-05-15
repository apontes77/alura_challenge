package com.alura.technicalchallenge.controller.course.request;

import com.alura.technicalchallenge.controller.course.validation.ValidCourseCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CourseRequest {

    private final String name;
    @ValidCourseCode
    private final String code;
    private final String username;
    private final String description;

}
