package ioc.bean.scope;

import domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project: JavaLearning
 * @description: 理解Bean的作用域
 * @author: Mabel.Chen
 * @create: 2020-02-13 10:59
 **/
public class BeanScope {

    public static void singletonScope() {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-scope.xml");
        User user = (User) beanFactory.getBean("user");
        User user1 = (User) beanFactory.getBean("user");
        /**
         * 结果为true, 说明是作用域是singleton,再看bean-scope.xml中user的配置，
         * 并没有显式定义作用域，所以说明singleton是默认的作用域
         * */
        System.out.println(user == user1); // true
    }

    public static void prototypeScope() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-scope.xml");
        User otherUser = (User) beanFactory.getBean("otherUser");
        User otherUser1 = (User) beanFactory.getBean("otherUser");
        /**
         * 结果为false, 说明otherUser的作用域为non-singleton,
         * 再看bean-scope.xml中user的配置，otherUser被显式定义了作用域为prototype
         * */
        System.out.println(otherUser == otherUser1); // false
    }

    public static void main(String[] args) {
        singletonScope();
        prototypeScope();
    }
}