package com.brunoFernandesDev.CoursesAPI.repository;

import com.brunoFernandesDev.CoursesAPI.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
}
