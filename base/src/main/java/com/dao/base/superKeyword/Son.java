package com.dao.base.superKeyword;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-24
 **/
public class Son extends Father {
    private String name;

    public Son() {
        super();
    }

    public void sonGreet() {
        System.out.println(super.hobby); // 可以通过super访问父类的protected属性
    }

    public void greeting() {
        System.out.println("Hello, I am Father");
    }
}