package com.brunoFernandesDev.CoursesAPI.service;

import com.brunoFernandesDev.CoursesAPI.EmailSender;
import com.brunoFernandesDev.CoursesAPI.model.CourseReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseReviewService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmailSender emailSender;

    public void reviewCourse(Long courseId, Long userId, int rating, String feedback) {

        courseService.addCourseReview(courseId, userId, rating, feedback);

        if (rating < 6) {

            String instructorEmail = courseService.getInstructorEmail(courseId);
            String subject = "bad rating for the course";
            String body = "Hi, Your course is being bad rating. " +
                    "The score was %d ad the feedback was %s".formatted(rating, feedback);
            emailSender.send(instructorEmail, subject, body);
        }
    }

    public double calculateNPS(Long courseId) {
        List<Integer> ratings = courseService.getCourseReviews(courseId).stream()
                .map(CourseReview::getRating)
                .collect(Collectors.toList());

        double promoters = ratings.stream().filter(r -> r >= 9 && r <= 10).count();
        double detractors = ratings.stream().filter(r -> r >= 0 && r <= 6).count();
        double totalResponses = ratings.size();

        if (totalResponses == 0) {
            return 0;
        }

        double nps = (promoters - detractors) / totalResponses * 100;
        return Math.round(nps * 10) / 10.0;
    }
}
