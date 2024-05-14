package com.alura.technicalchallenge.usecase.course;

import com.alura.technicalchallenge.controller.course.request.CourseRequest;
import com.alura.technicalchallenge.controller.course.response.CourseResponse;
import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.domain.enums.CourseStatus;
import com.alura.technicalchallenge.domain.enums.Role;
import com.alura.technicalchallenge.services.course.CourseService;
import com.alura.technicalchallenge.services.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.alura.technicalchallenge.controller.course.response.CourseResponse.toResponse;

@Component
public class CourseUseCase {

    private final CourseService courseService;

    private final UserService userService;

    public CourseUseCase(CourseService service, UserService userService) {
        this.courseService = service;
        this.userService = userService;
    }

    public Optional<CourseEntity> createCourse(CourseRequest request) {

        if(isUserInstructor(request.getUsername())) {

           final CourseEntity course = new CourseEntity(
                    request.getName(),
                    request.getCode(),
                    request.getUsername(),
                    request.getDescription(),
                    CourseStatus.ACTIVE ,
                    LocalDateTime.now()
            );
            return Optional.of(courseService.registerCourse(course));
        }

        return Optional.empty();
    }

    public CourseEntity inactivatingCourse(String courseCode) {
        return courseService.inactivatingCourse(courseCode);
    }

    public Page<CourseResponse> adaptingPageableListOfCourses(String status, Integer requestedPage) {
        Page<CourseEntity> coursesByStatus = courseService.getCoursesByStatus(status, PageRequest.of(requestedPage, 10));

        return toResponse(coursesByStatus);
    }

    private Boolean isUserInstructor(String username) {
        Role role = userService.obtainUserRole(username);

        return role.equals(Role.INSTRUCTOR);
    }


}
