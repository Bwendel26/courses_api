package com.brunoFernandesDev.CoursesAPI.data.dto;

import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.User;

public class CreateEnrollmentDTO {

    private User userId;
    private Course courseId;

    public User getUserId() {

        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Course getCourseId() {

        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
}
