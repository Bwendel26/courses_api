package com.brunoFernandesDev.CoursesAPI.data.vo.v1;

import com.brunoFernandesDev.CoursesAPI.model.enums.Role;

public class UserVO {

    private String name;
    private String email;
    private Role role;

    public UserVO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
