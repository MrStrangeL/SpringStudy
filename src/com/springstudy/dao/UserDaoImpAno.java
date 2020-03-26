package com.springstudy.dao;

import com.springstudy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示该类是数据接口层
 */
@Repository
public class UserDaoImpAno implements UserDao {
    private static Map<Integer,User> users;

    static{
        users=new HashMap<Integer, User>();
        users.put(1,new User(1,"张三2"));
        users.put(2,new User(2,"李四2"));
        users.put(3,new User(3,"王五2"));
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }
}
