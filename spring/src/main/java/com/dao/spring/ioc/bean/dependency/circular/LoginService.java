package com.dao.spring.ioc.bean.dependency.circular;

import org.springframework.stereotype.Service;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-09-17 00:05
 **/
@Service
public class LoginService {

    public void login(Student student) {
        System.out.println("Login starting ......");
        System.out.println(null == student ? "[]" : student.getNumber());
        System.out.println("Login finished");
    }
}