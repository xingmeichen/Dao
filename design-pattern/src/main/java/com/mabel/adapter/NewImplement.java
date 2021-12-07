package com.mabel.adapter;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-11-20 10:31
 **/
public class NewImplement implements NewInterface {

    @Override
    public void newDoWork() {
        System.out.println("新接口的新方法");
    }
}