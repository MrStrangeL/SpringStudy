package com.springstudy.service;

import com.springstudy.dao.UserDao;
import com.springstudy.entity.User;

public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp() {
    }

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
