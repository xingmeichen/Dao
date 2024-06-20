package com.dao.designpattern.proxy;

import com.dao.algorithm.base.proxy.Person;

/**
 * @author Mabel
 */
public class Student implements Person {

    @Override
    public void task() {
        System.out.println("Learn");
    }

    @Override
    public void greetingWithName(String name) {
        System.out.println("Hello, nice to meet you. My name is " + name);
    }
}
