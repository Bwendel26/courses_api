package com.brunoFernandesDev.CoursesAPI.controller;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateCourseDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import com.brunoFernandesDev.CoursesAPI.repository.CourseRepository;
import com.brunoFernandesDev.CoursesAPI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;
    @Autowired
    private CourseRepository repository;

    @GetMapping(value = "/{id}",
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseVO findById(@PathVariable(value = "id") Long id) {

        return service.findById(id);
    }

//    GET http://localhost:8080/courses/ACTIVE?page=0&size=10
    @GetMapping(value = "/list/{status}",
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<CourseVO> findByStatus(
                                  @PathVariable(value = "status") CourseStatus status,
                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size){

        PageRequest pageRequest = PageRequest.of(page, size);

        return repository.findByStatus(status, pageRequest);
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
