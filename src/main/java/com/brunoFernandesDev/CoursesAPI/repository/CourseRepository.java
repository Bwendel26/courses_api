package com.brunoFernandesDev.CoursesAPI.repository;

import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
    Page<CourseVO> findByStatus(CourseStatus course, Pageable pageable);
}
