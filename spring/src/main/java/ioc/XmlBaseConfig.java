package ioc;

import com.google.common.collect.Maps;
import common.Person;
import common.Student;
import common.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-08 20:50
 **/
public class XmlBaseConfig {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/xml-base-config.xml");
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
        Student student = beanFactory.getBean(Student.class);
        System.out.println(student);

        System.out.println("-----------------------这是一条分割线----------------------");
        listBean(beanFactory);
    }

    public static Map<String, User> listBean(BeanFactory beanFactory) {
        Map<String, User> users = Maps.newHashMap();
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            users = listableBeanFactory.getBeansOfType(User.class);
            users.forEach((name, object) -> {
                System.out.println("name" + name + "->" + object);
            });
        }
        return users;
    }
}