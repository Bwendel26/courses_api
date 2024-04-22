package com.brunoFernandesDev.CoursesAPI.repository;

import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.Enrollment;
import com.brunoFernandesDev.CoursesAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByUserIdAndCourseId(User userId, Course courseId);
}
