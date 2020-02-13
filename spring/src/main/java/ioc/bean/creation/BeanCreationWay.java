package ioc.bean.creation;

import common.User;
import util.UserFactory;

/**
 * @project: JavaLearning
 * @description: 介绍 BeanFactory 创建Bean的几种方式
 * @author: Mabel.Chen
 * @create: 2020-02-13 10:35
 **/
public class BeanCreationWay {

    /**
     *  通过构造函数创建Bean
     * */
    public static User createUserByConstructor() {
        return new User();
    }

    /**
     * 通过静态工厂方法创建Bean
     * */
    public static User createUserByStaticFactoryMethod() {
        return UserFactory.createUserByStaticMethod();
    }

    /**
     * 通过实例工厂方法创建Bean
     * */
    public static User createUserByInstanceFactoryMethod() {
        UserFactory userFactory = new UserFactory();
        return userFactory.createUser();
    }

    public static void main(String[] args) {
        User userByConstructor = createUserByConstructor();
        System.out.println(userByConstructor);
        User userByStaticFactoryMethod = createUserByStaticFactoryMethod();
        System.out.println(userByStaticFactoryMethod);
        User userByInstanceFactoryMethod = createUserByInstanceFactoryMethod();
        System.out.println(userByInstanceFactoryMethod);
    }
}