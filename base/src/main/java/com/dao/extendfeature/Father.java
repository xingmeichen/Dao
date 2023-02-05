package com.dao.extendfeature;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-17 15:44
 **/
@Data
public class Father {

    private String name;
    private Integer age;

    public Father() {
        System.out.println("I am Father");
    }

    public void father() {
        System.out.println("In Father's function");
    }

    public void greeting() {
        System.out.println("Hello, I am the Father class");
    }
}