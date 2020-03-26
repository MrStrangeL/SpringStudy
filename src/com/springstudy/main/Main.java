package com.springstudy.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springstudy.aspect.CalImp;
import com.springstudy.aspect.ICal;
import com.springstudy.controller.DrinksController;
import com.springstudy.controller.UserController;
import com.springstudy.controller.UserControllerAno;
import com.springstudy.define.ClassPathXmlApplicationContextDefImp;
import com.springstudy.entity.*;
import com.springstudy.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String [] args) throws SQLException {
        //加载spring.xml配置文件(从类路径下加载),创生成ApplicationContext对象(实例化IoC容器)
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");

        //方式一：通过配置的id获取对象实例
        Student studentOne= (Student) applicationContext.getBean("studentOne");
        System.out.println("studentOne:"+studentOne);

        //方式二：通过运行时类获取对象，此方法有一个弊端，当 spring.xml 中配置两个 Student 的 bean 时程序会抛出异常，因为此时两个 bean 都是由 Student 类生成的，IoC 容器无法将两个 bean 都返回，必须指定一个唯一的 bean。
        Student studentTwo=(Student)applicationContext.getBean("studentTwo",Student.class);
        System.out.println("studentTwo:"+studentTwo);

        Student studentThree=(Student)applicationContext.getBean("studentThree");
        System.out.println("studentThree:"+studentThree);

        Student studentFour=(Student)applicationContext.getBean("studentFour",Student.class);
        System.out.println("studentFour:"+studentFour);

        Student studentFive=(Student)applicationContext.getBean("studentFive",Student.class);
        System.out.println("studentFive:"+studentFive);

        Classes classesOne=(Classes)applicationContext.getBean("classesFour",Classes.class);
        System.out.println("classesOne:"+classesOne);

        DataSource dataSource=(DataSource)applicationContext.getBean("dataSource",DataSource.class);
        System.out.println("dataSource:"+dataSource);

        System.out.println("------------------------------------------------------------");

        Student studentSix=(Student)applicationContext.getBean("studentEight",Student.class);
        System.out.println("studentSix:"+studentSix);

        Student studentSeven=(Student)applicationContext.getBean("studentEight",Student.class);
        System.out.println("studentSeven:"+studentSeven);

        //如果bean的scope是singleton则输出true，如果bean的scope是prototype则输出false
        System.out.println(studentSix==studentSeven);

        System.out.println("------------------------------------------------------------");

        Student fatherStudent=(Student)applicationContext.getBean("fatherStudent",Student.class);
        System.out.println("fatherStudent:"+fatherStudent);

        Student sonStudent=(Student)applicationContext.getBean("sonStudent",Student.class);
        System.out.println("sonStudent:"+sonStudent);

        //测试能否读取到配置文件中的相关配置
        C3p0Config c3p0Config=(C3p0Config)applicationContext.getBean("c3p0Config",C3p0Config.class);
        System.out.println("c3p0Config:"+c3p0Config);

        //创建c3p0数据源
//        javax.sql.DataSource ds=(javax.sql.DataSource) applicationContext.getBean("c3p0", ComboPooledDataSource.class);
//        Connection connection=null;
//        connection=ds.getConnection();
//        System.out.println(connection);

        Classes classesTwo=(Classes)applicationContext.getBean("classesFive",Classes.class);
        System.out.println("classesTwo:"+classesTwo);

        //销毁IoC容器
        ((ClassPathXmlApplicationContext)applicationContext).close();

        ApplicationContext applicationContextTwo= new ClassPathXmlApplicationContext("spring-config.xml");

        //通过静态工厂获取car
        Car carOne=(Car)applicationContextTwo.getBean("carOne");
        System.out.println("carOne:"+carOne);

        //通过实例工厂创建car
        Car carTwo=(Car)applicationContextTwo.getBean("carTwo");
        System.out.println("carTwo:"+carTwo);

        //测试自动装载
        Person personOne=(Person) applicationContextTwo.getBean("personOne");
        System.out.println("personOne:"+personOne);

        //基于XML的方式实现
        UserController userController=(UserController)applicationContextTwo.getBean("userController",UserController.class);
        System.out.println("userController:"+userController.getUserById(2));

        //基于注解的形式实现
        ApplicationContext applicationContextThree=new ClassPathXmlApplicationContext("spring-config-anno.xml");
        UserControllerAno userControllerAno=(UserControllerAno)applicationContextThree.getBean("userControllerAno",UserControllerAno.class);
        System.out.println("userControllerAno:"+userControllerAno.getUserById(3));

        DrinksController drinksController=(DrinksController)applicationContextThree.getBean("drinksController",DrinksController.class);
        System.out.println("drinksController:"+drinksController.getDrinksById(1));

        //自定义IoC容器测试
        //实例化IoC容器
        ClassPathXmlApplicationContextDefImp applicationContextDef=new ClassPathXmlApplicationContextDefImp("spring-def.xml");
        Address address=(Address) applicationContextDef.getBean("address");
        System.out.println("address:"+address);

        //获取代理对象
        ICal iCal=(ICal)applicationContextThree.getBean("calImp");
        iCal.jia(1,2);
        iCal.jian(1,2);
        iCal.chen(1,2);
        iCal.chu(1,2);
    }
}
