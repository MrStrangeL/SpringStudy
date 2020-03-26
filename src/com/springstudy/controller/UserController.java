package com.springstudy.controller;

import com.springstudy.entity.User;
import com.springstudy.service.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(int id){
        return userService.getUserById(id);
    }
}
