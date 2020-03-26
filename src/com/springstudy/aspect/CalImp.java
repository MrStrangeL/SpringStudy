package com.springstudy.aspect;

import org.springframework.stereotype.Component;

@Component
public class CalImp implements ICal {
    @Override
    public int jia(int a, int b) {
        return a+b;
    }

    @Override
    public int jian(int a, int b) {
        return a-b;
    }

    @Override
    public int chen(int a, int b) {
        return a*b;
    }

    @Override
    public int chu(int a, int b) {
        return a/b;
    }
}
