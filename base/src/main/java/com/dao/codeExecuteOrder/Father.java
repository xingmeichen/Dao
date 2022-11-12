package com.dao.codeExecuteOrder;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-05-30 16:15
 **/
public class Father {

    static {
        System.out.println("Father's static statement");
    }

    {
        System.out.println("Father's non static statement");
    }
}