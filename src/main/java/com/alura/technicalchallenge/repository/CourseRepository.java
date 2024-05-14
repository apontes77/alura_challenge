package com.alura.technicalchallenge.repository;

import com.alura.technicalchallenge.domain.CourseEntity;
import com.alura.technicalchallenge.domain.enums.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<CourseEntity, Long>, JpaRepository<CourseEntity, Long> {
    CourseEntity findByCode(String courseCode);

    Page<CourseEntity> findByStatus(CourseStatus status, Pageable pageable);
}
