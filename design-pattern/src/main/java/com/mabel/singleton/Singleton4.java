package com.mabel.singleton;

/**
 * @project: JavaLearning
 * @description:
 * 枚举类实现方式：线程安全，调用效率高，不能延时加载，可以天然防止反射和序列化调用
 * @author: Mabel.Chen
 * @create: 2022-03-17
 **/
public enum Singleton4 {

    INSTANCE;

    public Singleton4 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        Singleton4 singleton4 = Singleton4.class.newInstance();
        /***
         * 看 Singleton4.class.newInstance() -->
         * java.lang.Class#newInstance()：tmpConstructor.newInstance((Object[])null); -->
         * java.lang.reflect.Constructor#newInstance(java.lang.Object...) ：
         * if ((clazz.getModifiers() & Modifier.ENUM) != 0)
         *             throw new IllegalArgumentException("Cannot reflectively create enum objects");
         * 所以可以知道JVM不允许通过反射对枚举类实例化
         */
    }
}