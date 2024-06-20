package com.dao.designpattern.adapter;

import com.dao.algorithm.base.adapter.OldInterface;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-11-20 11:09
 **/
public class OldImplement implements OldInterface {

    @Override
    public void doWork() {
        System.out.println("旧的接口方法实现");
    }
}