package com.brunoFernandesDev.CoursesAPI.controller;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateCourseDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping(value = "/{id}",
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseVO findById(@PathVariable(value = "id") Long id) {

        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseVO> findAll(){

        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseVO createCourse(@RequestBody CreateCourseDTO course) {
        return service.createCourse(course);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseVO inactivateCourse(@PathVariable(value = "id") Long id) {

        return service.inactivateCourse(id);
    }
}
