package com.brunoFernandesDev.CoursesAPI.service;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateUserDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.UserVO;
import com.brunoFernandesDev.CoursesAPI.mapper.DozerMapper;
import com.brunoFernandesDev.CoursesAPI.model.User;
import com.brunoFernandesDev.CoursesAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    private Logger logger = Logger.getLogger(CourseService.class.getName());

    @Autowired
    UserRepository repository;

    public UserVO findByUsername(String username) {
        logger.info("Searching a user...");
        var entity = repository.findByUsername(username);

        return DozerMapper.parseObject(entity, UserVO.class);
    }

    public UserVO createUser(CreateUserDTO user) {
        logger.info("Creating a new user...");
        var entity = DozerMapper.parseObject(user, User.class);

        return DozerMapper.parseObject(repository.save(entity), UserVO.class);
    }


}
