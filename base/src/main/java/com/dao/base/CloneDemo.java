package com.dao.base;

/**
 * @project: Dao
 * @description:
 * 1. If a class not implement {@link Cloneable} interface, when call clone,
 *    will throw CloneNotSupportedException
 * 2. So in order to be able to call clone method, have to implement {@link Cloneable} interface,
 *    well don't have to override {@link Object#clone()}
 * 3. need to confirm, if there is any hurt if not override {@link Object#clone()}
 * @author: Mabel.Chen
 * @create: 2024-06-25
 **/
public class CloneDemo implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo cloneDemo = new CloneDemo();
        Object clone = cloneDemo.clone();
        System.out.println(clone instanceof CloneDemo);
    }
}