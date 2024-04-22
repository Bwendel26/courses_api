package com.brunoFernandesDev.CoursesAPI.controller;

import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseReviewVO;
import com.brunoFernandesDev.CoursesAPI.service.CourseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course-reviews")
public class CourseReviewController {

    @Autowired
    private CourseReviewService courseReviewService;

    @PostMapping
    public void reviewCourse(@RequestBody CourseReviewVO reviewVO) {
        courseReviewService.reviewCourse(reviewVO.getCourseId(), reviewVO.getUserId(), reviewVO.getRating(), reviewVO.getFeedback());
    }
}
