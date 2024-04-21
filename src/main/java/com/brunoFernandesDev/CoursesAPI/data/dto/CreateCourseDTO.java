package com.brunoFernandesDev.CoursesAPI.data.dto;

public class CreateCourseDTO {
    private static final long serialVersionUID = 1L;

    private Long course_id;
    private String name;
    private String code;
    private String  instructor;
    private String description;

    public CreateCourseDTO() {}

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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
