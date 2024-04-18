package com.brunoFernandesDev.CoursesAPI.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "user_id'", nullable = false)
    private User user;

    @Column(name = "enrrolment_date", nullable = false)
    private Date enrrolmentDate;

    public Enrollment () {}

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEnrrolmentDate() {
        return enrrolmentDate;
    }

    public void setEnrrolmentDate(Date enrrolmentDate) {
        this.enrrolmentDate = enrrolmentDate;
    }
}