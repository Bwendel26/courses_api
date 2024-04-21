package com.brunoFernandesDev.CoursesAPI.data.vo.v1;

import com.brunoFernandesDev.CoursesAPI.model.User;
import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


public class CourseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long course_id;
    private String name;
    private String code;
    private User instructor;
    private String description;
    private CourseStatus status;
    private Date creationDate;
    private Date inactivationDate;

    public CourseVO() {}

    public Long getCourse_id() {
        return course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getInactivationDate() {
        return inactivationDate;
    }

    public void setInactivationDate(Date inactivationDate) {
        this.inactivationDate = inactivationDate;
    }
}
