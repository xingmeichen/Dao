package com.dao.base.extendfeature;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-04-12 11:35
 **/
@Data
public class Person {

    private String name;
    private String phone;

    public Person(){}

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}