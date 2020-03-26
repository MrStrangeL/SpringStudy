package com.springstudy.controller;

import com.springstudy.entity.Drinks;
import com.springstudy.service.DrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 表示该类是控制器
 */
@Controller
public class DrinksController {
    /**
     * 自动装配，默认使用的是byType的形式，这里使用byName的形式，需要借助@Qualifier注解，该注解中的DrinksServiceDef需要和@Service中的保持一致
     */
    @Autowired()
    @Qualifier("DrinksServiceDef")
    private DrinksService drinksService;

    public Drinks getDrinksById(int id){
        return drinksService.getDrinksById(id);
    }
}
