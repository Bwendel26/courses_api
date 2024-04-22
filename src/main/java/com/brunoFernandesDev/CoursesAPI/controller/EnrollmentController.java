package com.brunoFernandesDev.CoursesAPI.controller;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateEnrollmentDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.EnrollmentVO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.UserVO;
import com.brunoFernandesDev.CoursesAPI.mapper.DozerMapper;
import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.User;
import com.brunoFernandesDev.CoursesAPI.service.CourseService;
import com.brunoFernandesDev.CoursesAPI.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService service;

    @Autowired
    private CourseService courseService;

    @PostMapping("/user/{userId}/course/{courseId}")
    public ResponseEntity<?> createEnrollment(@PathVariable UserVO userId, @PathVariable CourseVO courseId) throws Exception {

        boolean isEnrolled = service.isUserEnrolled(userId, courseId);
        if (isEnrolled) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User already enrolled.");
        }

        boolean isActive = courseService.isCourseActive(courseId);
        if (!isActive) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Course not active.");
        }

        CreateEnrollmentDTO enrollmentDTO = new CreateEnrollmentDTO();

        var userEntity = DozerMapper.parseObject(userId, User.class);
        var courseEntity = DozerMapper.parseObject(courseId, Course.class);

        enrollmentDTO.setUserId(userEntity);
        enrollmentDTO.setCourseId(courseEntity);
        EnrollmentVO createdEnrollment = service.createEnrollment(enrollmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnrollment);
    }
}
