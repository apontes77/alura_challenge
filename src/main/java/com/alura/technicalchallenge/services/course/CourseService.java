package com.alura.technicalchallenge.services.course;

import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.domain.enums.CourseStatus;
import com.alura.technicalchallenge.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }


    public CourseEntity registerCourse(CourseEntity courseEntity) {

        return repository.save(courseEntity);
    }

    public CourseEntity inactivatingCourse(String courseCode) {
        var course = repository.findByCode(courseCode);
        if(course.getStatus().equals(CourseStatus.ACTIVE)) {
            course.setStatus(CourseStatus.INACTIVE);
            course.setInactivationDate(LocalDateTime.now());
        }

        return repository.save(course);
    }

    public Page<CourseEntity> getCoursesByStatus(String status, Pageable pageable) {

        return repository.findByStatusContaining(status, pageable);
    }
}
