package com.dao.extendfeature;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-17 15:44
 **/
@Data
public class Son extends Father {

    public Son() {
        System.out.println("I am Son");
    }

    public void greeting() {
        System.out.println("Hello, I am the Son class");
    }

    public void son() {
        System.out.println("In Son's function");
    }

    public static void main(String[] args) {
        /**
         * 该语句是为了验证Java的继承特性,
         * 1、当声明的是父类，但是实际上是显示调用子类构造函数的时候，
         * 2、会先调用父类的构造方法，然后再调用子类的构造方法
         * 3、实际上创建的还是父类的实例，但是调用同名方法的时候只会调用子类的方法
         * 4、它既可以调用父类的方法，也可以调用子类的方法，但是调用子类的方法必须进行类型的强制转换
         * */
        Father father = new Son();
        father.greeting();
        father.father();
        ((Son) father).son();

        // 该语句编译不通过，说明继承是向下的，也就是子类可以调用子类的方法，但是子类不能调用父类的
        //Son son = new Father();

        System.out.println("***********");
        /**
         * 调用构造方法的时候，先调用父类的构造方法，再调用子类的构造方法
         * */
        Son son = new Son();
        son.father();

        Father realFather = new Father();
        ((Son) father).son();
    }
}