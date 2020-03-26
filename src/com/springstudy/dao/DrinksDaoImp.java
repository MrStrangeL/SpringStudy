package com.springstudy.dao;

import com.springstudy.entity.Drinks;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示该类是数据接口层
 */
@Repository
public class DrinksDaoImp implements DrinksDao {
    private static Map<Integer,Drinks> drinks;

    static {
        drinks=new HashMap<Integer,Drinks>();
        drinks.put(1,new Drinks(11,"红茶"));
        drinks.put(2,new Drinks(22,"绿茶"));
        drinks.put(3,new Drinks(33,"可乐"));
    }

    @Override
    public Drinks getDrinksById(int id) {
        return drinks.get(id);
    }
}
