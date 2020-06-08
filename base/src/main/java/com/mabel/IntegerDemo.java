package com.mabel;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-12-01 11:17
 **/
public class IntegerDemo {

    /***
     * 判断两个值是否相等，Integer和String类型做一个比较，它们又有些不同，主要是因为
     * Integer这个类中定义了一个私有的静态内部类 IntegerCache，它缓存了 【-128， 127】
     * 这个范围的Integer的值，只有超出这个范围，才会在创建一个新的对象，否则对象直接指向缓存中的值
     * 也就是
     * Integer i1 = 1;
     * Integer i2 = 1;
     * i1 == i2 结果为true
     * Integer i4 = 128;
     * Integer i5 = 128;
     * i4 == i5 结果为false
     */
    public static void equalOrNot() {
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2); // true
        Integer i3 = new Integer(1);
        System.out.println(i1 == i3); // false
        Integer i4 = 128;
        Integer i5 = 128;
        System.out.println(i4 == i5); // false
    }

    public static void main(String[] args) {
        try {
            equalOrNot();
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

    }
}