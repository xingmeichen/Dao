package com.dao.base;

/**
 * @project: Dao
 * @description:
 * 关于 static 的一些场景以及结果
 * 1. static 块只有在类被初始化的时候执行一次(A)
 * 2. 类中的非static代码块，每次调用类构造方法的时候就会被执行一次，且先于构造方法执行(B)
 * @author: Mabel.Chen
 * @create: 2019-11-18 16:07
 **/
public class StaticDemo {

    public static void greeting() {
        System.out.println("Hello, nice to meet you!");
    }

    public StaticDemo() {
        System.out.println("I am in a constructor");
    }

    //(A)
    static {
        System.out.println("------ static statement start -------");
        System.out.println("I am a static statement");
        System.out.println("------ static statement end-------");
    }

    static StaticDemo me = new StaticDemo();

    // 为什么会是下面这一个语句最先执行呢？？且每次创建一个对象就会执行一次
    //(B)
    {
        System.out.println("I am neither a static statement nor in main function");
    }

    public static void staticFunction(int a) {
        System.out.println("I am a static function");
    }

    int a = 123;
    static int b = 456;

    public static void main(String[] args) {
        staticFunction(b);
        System.out.println("----------------");
        StaticDemo staticDemo = null; // 只是声明一个对象不会调用构造函数
        staticDemo.greeting(); // 一个 null对象可以调用静态方法？？
        greeting();
        staticFunction(b);
        System.out.println("-----------------");
        staticDemo = new StaticDemo();
        System.out.println("-----------------");
        staticDemo = new StaticDemo();
        System.out.println("-----------------");
    }
}