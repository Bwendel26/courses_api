package com.brunoFernandesDev.CoursesAPI.service;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateEnrollmentDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.CourseVO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.EnrollmentVO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.UserVO;
import com.brunoFernandesDev.CoursesAPI.mapper.DozerMapper;
import com.brunoFernandesDev.CoursesAPI.model.Course;
import com.brunoFernandesDev.CoursesAPI.model.Enrollment;
import com.brunoFernandesDev.CoursesAPI.model.User;
import com.brunoFernandesDev.CoursesAPI.repository.EnrollmentRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository repository;

    @Autowired
    private CourseService courseService;

    private Logger logger = Logger.getLogger(CourseService.class.getName());

    public EnrollmentVO findById(Long id) {

        logger.info("Searching enrollments by id:  " + id);
        var entity = repository.findById(id);

        return DozerMapper.parseObject(entity, EnrollmentVO.class);
    }

    public EnrollmentVO createEnrollment(CreateEnrollmentDTO enrollmentDTO) throws Exception {

        logger.info("Creating a new enrollment...");
        boolean isEnrolled = repository.existsByUserIdAndCourseId(enrollmentDTO.getUserId(), enrollmentDTO.getCourseId());
        if (isEnrolled) {
            throw new Exception();
        }

        var enrollmentVO = DozerMapper.parseObject(enrollmentDTO, EnrollmentVO.class);
        var courseVO = courseService.findById(enrollmentVO.getCourse().getCourse_id());

        boolean isActive = courseService.isCourseActive(courseVO);
        if (!isActive) {
            throw new BadRequestException();
        }

        Enrollment enrollment = DozerMapper.parseObject(enrollmentDTO, Enrollment.class);
        enrollment.setEnrollmentDate(new Date());
        Enrollment savedEnrollment = repository.save(enrollment);

        return DozerMapper.parseObject(savedEnrollment, EnrollmentVO.class);
    }

    public boolean isUserEnrolled(UserVO userId, CourseVO courseId) {

        var userEntity = DozerMapper.parseObject(userId, User.class);
        var courseEntity = DozerMapper.parseObject(courseId, Course.class);

        return repository.existsByUserIdAndCourseId(userEntity, courseEntity);
    }
}
