package com.alura.technicalchallenge.controller.course.request;

import com.alura.technicalchallenge.controller.course.validation.ValidCourseCode;

public class CourseRequest {

    private String name;
    @ValidCourseCode
    private String code;
    private String username;
    private String description;

    public CourseRequest(String name, String code, String username, String description) {
        this.name = name;
        this.code = code;
        this.username = username;
        this.description = description;
    }

    public CourseRequest() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }
}
