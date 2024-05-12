package com.alura.technicalchallenge.repository;

import com.alura.technicalchallenge.domain.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    CourseEntity findByCode(String courseCode);

    Page<CourseEntity> findByStatusContaining(String status, Pageable pageable);
}
