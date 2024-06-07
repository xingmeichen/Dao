package com.dao.base;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-03-21 09:16
 **/
public class Test {

    public static void main(String[] args) {
        int i = 500;
        Integer a = new Integer(i);
        Integer b = new Integer(i);
        System.out.println(a == b);

        a = i;
        b = i;
        System.out.println(a == b);
    }
}