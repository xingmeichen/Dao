package com.mabel.codeExecuteOrder;

/**
 * @project: JavaLearning
 * @description: 类加载机制的印证
 * @author: Mabel.Chen
 * @create: 2021-05-30 16:16
 **/
public class Son extends Father {

    static {
        System.out.println("Son's static statement");
    }

    {
        System.out.println("Son's non static statement");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}