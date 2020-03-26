package com.springstudy.service;

import com.springstudy.dao.DrinksDao;
import com.springstudy.entity.Drinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 表示该类是业务层
 * 这里的DrinksServiceDef表示指定bean的id为DrinksServiceDef，在自动注入的时候如果使用byName的方式需要和DrinksServiceDef保持一致
 */
@Service("DrinksServiceDef")
public class DrinksServiceImp implements DrinksService{
    /**
     * 自动装配，默认使用的是byType的方式
     */
    @Autowired
    private DrinksDao drinksDao;

    @Override
    public Drinks getDrinksById(int id) {
        return drinksDao.getDrinksById(id);
    }
}
