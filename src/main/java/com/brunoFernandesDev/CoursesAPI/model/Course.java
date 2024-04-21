package com.brunoFernandesDev.CoursesAPI.model;

import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", columnDefinition = "INT")
    private Long course_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "INT")
    private Long instructor;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "inactivation_date")
    private Date inactivationDate;

    public Course() {}

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

    public Long getInstructor() {
        return instructor;
    }

    public void setInstructor(Long instructor) {
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
