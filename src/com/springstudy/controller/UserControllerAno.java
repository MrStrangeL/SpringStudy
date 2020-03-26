package com.springstudy.controller;

import com.springstudy.entity.User;
import com.springstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 表示该类作为一个控制器
 */
@Controller
public class UserControllerAno {
    /**
     * 表示 IoC 容器自动完成装载，默认是 byType 的方式
     */
    @Autowired
    private UserService userService;

    public User getUserById(int id){
        return userService.getUserById(id);
    }
}
