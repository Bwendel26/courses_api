package com.brunoFernandesDev.CoursesAPI.service;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateCourseDTO;
import com.brunoFernandesDev.CoursesAPI.data.dto.CreateEnrollmentDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.mapper.DozerMapper;
import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.CourseReview;
import com.brunoFernandesDev.CoursesAPI.model.enums.CourseStatus;
import com.brunoFernandesDev.CoursesAPI.repository.CourseRepository;
import com.brunoFernandesDev.CoursesAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseService {

    private Logger logger = Logger.getLogger(CourseService.class.getName());

    @Autowired
    CourseRepository repository;
    UserRepository userRepository;

    public CourseVO findById(Long id){

        logger.info("Finding course...");
        var entity = repository.findById(id).orElseThrow(() -> new NullPointerException());

        return DozerMapper.parseObject(entity, CourseVO.class);
    }

    public List<CourseVO> findAll(){

        logger.info("Findind all courses...");

        return DozerMapper.parseListObjects(repository.findAll(), CourseVO.class);
    }

    public CourseVO createCourse(CreateCourseDTO courseDTO) {

        logger.info("Creating a new course...");
        var entity = DozerMapper.parseObject(courseDTO, Course.class);
        entity.setStatus(CourseStatus.ACTIVE);
        entity.setCreationDate(new Date());

        return DozerMapper.parseObject(repository.save(entity), CourseVO.class);
    }

    public CourseVO inactivateCourse(Long id){

        Course course = repository.findById(id).orElseThrow(() -> new NullPointerException());
        logger.info("Inactivating Course, ID: " + course.getCourse_id() + " Title: " + course.getName());
        course.setStatus(CourseStatus.INACTIVE);
        course.setInactivationDate(new Date());

        return DozerMapper.parseObject(course, CourseVO.class);
    }

    public boolean isCourseActive(CourseVO courseVO) {

        Course entity = repository.findById(courseVO.getCourse_id()).orElseThrow(() -> new NullPointerException());
        CourseStatus status = entity.getStatus();
        if(status.equals(CourseStatus.ACTIVE)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addCourseReview(Long courseId, Long userId, int rating, String feedback) {

    }

    public String getInstructorEmail(Long courseId) {

        return "example@example.com";
    }

    public List<CourseReview> getCourseReviews(Long courseId) {

        return List.of();
    }
}
