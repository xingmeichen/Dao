package com.dao.base.collection;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @project: Dao
 * @description:
 * @see java.util.concurrent.CopyOnWriteArraySet
 * @author: Mabel.Chen
 * @create: 2024-06-21
 **/
public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
    }
}