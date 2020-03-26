package com.springstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 创建切面类
 * @Aspect：表示该类是切面类
 * @Component：将该类注入到IoC容器中
 */
@Aspect
@Component
public class LoggerAspect {
    /**
     * @Before：表示方法的执行时机
     * execution(public int com.springstudy.aspect.CalImp.*(..))：表示切入点是com.springstudy.aspect包下CalImp类中的所有方法
     * 即CalImp的所有方法在执行前面会首先执行LoggerAspect类中的before方法
     * @param joinPoint
     */
    @Before(value="execution(public int com.springstudy.aspect.CalImp.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String name=joinPoint.getSignature().getName();
        //获取参数列表
        String args= Arrays.toString(joinPoint.getArgs());
        System.out.println(name+"方法的参数是:"+args);
    }

    /**
     * @After：表示方法的执行时机
     * execution(public int com.springstudy.aspect.CalImp.*(..))：表示切入点是com.springstudy.aspect包下CalImp类中的所有方法
     * 即CalImp的所有方法在执行之后会执行LoggerAspect类中的after方法
     * @param joinPoint
     */
    @After(value="execution(public int com.springstudy.aspect.CalImp.*(..))")
    public void after(JoinPoint joinPoint){
        //获取方法名
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法结束");
    }

    /**
     * @AfterReturning：表示方法的执行时机
     * execution(public int com.springstudy.aspect.CalImp.*(..))：表示切入点是com.springstudy.aspect包下CalImp类中的所有方法
     * 即CalImp的所有方法在return(将return之后的值绑定到result)之后会执行LoggerAspect类中的afterReturing方法
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(public int com.springstudy.aspect.CalImp.*(..))",returning = "result")
    public void afterReturing(JoinPoint joinPoint,Object result){
        //获取方法名
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法的结果是:"+result);
    }

    /**
     * @AfterThrowing：表示方法的执行时机
     * execution(public int com.springstudy.aspect.CalImp.*(..))：表示切入点是com.springstudy.aspect包下CalImp类中的所有方法
     * 即CalImp的所有方法在抛出异常(抛出的异常绑定到ex)之后会执行LoggerAspect类中的afterThrowing方法
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public int com.springstudy.aspect.CalImp.*(..))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法抛出异常:"+ex);
    }
}
