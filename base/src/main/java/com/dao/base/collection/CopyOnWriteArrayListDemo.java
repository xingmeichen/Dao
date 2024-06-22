package com.dao.base.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @project: Dao
 * @description:
 * @see java.util.concurrent.CopyOnWriteArrayList
 * @author: Mabel.Chen
 * @create: 2024-06-21
 **/
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.stream().forEach(item -> System.out.print(item + " "));
    }
}