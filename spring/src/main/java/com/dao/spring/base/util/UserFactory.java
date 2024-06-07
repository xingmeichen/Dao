package com.dao.spring.base.util;

import com.dao.spring.base.domain.Person;
import com.dao.spring.base.domain.User;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-13 10:41
 **/
public class UserFactory {

    public static User createUserByStaticMethod() {
        System.out.println("create User by static factory method");
        return new User();
    }

    public User createUser() {
        System.out.println("create User by constructor");
        return new User();
    }

    public Person createPerson() {
        return new Person();
    }
}