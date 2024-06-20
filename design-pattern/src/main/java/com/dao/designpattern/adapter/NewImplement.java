package com.dao.designpattern.adapter;

import com.dao.algorithm.base.adapter.NewInterface;

/**
 * @project: Dao
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