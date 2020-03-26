package com.springstudy.service;

import com.springstudy.dao.UserDao;
import com.springstudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 表示该类是业务层
 */
@Service
public class UserServiceImpAno implements UserService {
    /**
     * 表示 IoC 容器自动完成装载，默认是 byType 的方式
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
