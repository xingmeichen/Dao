package com.mabel.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-24 10:24
 **/
public class ArrayListLearn {

    public static void removeItem() {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("b".equals(item)) {
                // 该操作会导致 ConcurrentModificationException，为什么会抛出这个异常，通过源码去了解
                // list.remove("b");
                // 下面才是正确的操作，但是该操作在多线程场景下还是会出现异常，因为ArrayList是非线程安全的，
                // CopyOnWriteArrayList -- 该集合类是线程安全的，并且它是通过 ReentrantLock 去实现的
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        removeItem();
    }
}