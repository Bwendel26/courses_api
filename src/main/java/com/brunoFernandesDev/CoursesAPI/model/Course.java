package com.brunoFernandesDev.CoursesAPI.model;

import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus status;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "inactivation_date")
    private Date inactivationDate;
}
