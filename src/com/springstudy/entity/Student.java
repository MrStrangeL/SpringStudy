package com.springstudy.entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private Classes classes;

    public Student() {
        System.out.println("无参构造：创建了Student对象");
    }

    public Student(int id, String name, int age) {
        System.out.println("有参构造无依赖：创建了Student对象");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, Classes classes) {
        System.out.println("有参构造有依赖：创建了Student对象");
        this.id = id;
        this.name = name;
        this.age = age;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student [id="+id+",name="+name+",age="+age+",classes="+classes+"]";
    }

    public void init(){
        System.out.println("studentEight初始化");
    }

    public void destroy(){
        System.out.println("studentEight销毁");
    }
}
