package com.dao.algorithm.base.adapter;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-11-20 10:25
 **/
public class Adapter implements OldInterface {

    private NewInterface newInterface;

    @Override
    public void doWork() {
        newInterface = new NewImplement();
        newInterface.newDoWork();
    }
}