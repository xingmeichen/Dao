package com.dao.base;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-25
 **/
public class PassByValueDemo {

    private String name;

    public PassByValueDemo(){}

    public PassByValueDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateName(PassByValueDemo demo, String name) {
        demo.setName(name);
    }

    public static void swap(PassByValueDemo demo1, PassByValueDemo demo2) {
        PassByValueDemo tmp = demo1;
        demo1 = demo2;
        demo2 = tmp;
        System.out.println("In swap: demo1: " + demo1);
        System.out.println("In swap: demo2: " + demo2);
        System.out.println("In swap: demo1.name = " + demo1.name);
        System.out.println("In swap: demo2.name = " + demo2.name);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PassByValueDemo demo1 = new PassByValueDemo("Demo1");
        PassByValueDemo demo2 = new PassByValueDemo("Demo2");
        System.out.println("demo1: " + demo1);
        System.out.println("demo2: " + demo2);
        PassByValueDemo.swap(demo1, demo2);
        System.out.println(demo1.getName());
        System.out.println(demo2.getName());
    }
}