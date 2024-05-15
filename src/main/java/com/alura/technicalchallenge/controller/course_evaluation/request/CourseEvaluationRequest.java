package com.alura.technicalchallenge.controller.course_evaluation.request;

public record CourseEvaluationRequest(String courseCode, Integer grade, String subject, String body) {
}
