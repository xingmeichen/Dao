package com.dao.proxy;

/**
 * @author Mabel
 */
public class Teacher implements Person {

    @Override
    public void task() {
        System.out.println("Teach");
        greeting();
        greetingWithName("Mabel");
    }

    @Override
    public void greetingWithName(String name) {
        System.out.println("Hello, nice to meet you. My name is " + name);
    }

    /**
     * 私有方法没有办法被增强，因为JDK动态代理是针对实现了接口类生成代理，而不能针对没有实现接口的类，
     * 比如 Teacher targetObject = (Teacher) JDKProxy.getTargetObject(new Teacher()); 执行的时候将会报错
     * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.mabel.proxy.Teacher
     * */
    private void greeting() {
        System.out.println("Hello, nice to meet you.");
    }

    public static void main(String[] args) {
        JDKProxy JDKProxy = new JDKProxy();
        Person targetObject = (Person) JDKProxy.getTargetObject(new Teacher());
        // 下面这行代码执行时候会报错，表明了 JDK动态代理是针对实现了接口类生成代理，而不能针对没有实现接口的类。
//        Teacher teacher = (Teacher) JDKProxy.getTargetObject(new Teacher());
        targetObject.task();
        targetObject.greetingWithName("Mabel");
    }
}
