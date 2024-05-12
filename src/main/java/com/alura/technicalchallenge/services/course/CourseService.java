package com.alura.technicalchallenge.services.course;

import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }


    public CourseEntity registerCourse(CourseEntity courseEntity) {

        return repository.save(courseEntity);
    }
}
