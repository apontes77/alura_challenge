package com.alura.technicalchallenge.controller.enrollment.request;

public class EnrollmentRequest {

    private String username;
    private String code;

    public EnrollmentRequest(String username, String code) {
        this.username = username;
        this.code = code;
    }

    public EnrollmentRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getCode() {
        return code;
    }
}
