package com.brunoFernandesDev.CoursesAPI.controller;

import com.brunoFernandesDev.CoursesAPI.data.dto.CreateUserDTO;
import com.brunoFernandesDev.CoursesAPI.data.vo.v1.UserVO;
import com.brunoFernandesDev.CoursesAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/{username}",
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO findUserByUsername(@PathVariable(value = "username") String username) {

        return service.findByUsername(username);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO createUser(@RequestBody CreateUserDTO user) {

        return service.createUser(user);
    }
}
