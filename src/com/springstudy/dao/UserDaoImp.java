package com.springstudy.dao;

import com.springstudy.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImp implements UserDao {
    private static Map<Integer,User> users;

    static{
        users=new HashMap<Integer, User>();
        users.put(1,new User(1,"张三"));
        users.put(2,new User(2,"李四"));
        users.put(3,new User(3,"王五"));
    }

    public UserDaoImp() {
    }

    public static Map<Integer, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<Integer, User> users) {
        UserDaoImp.users = users;
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }
}
