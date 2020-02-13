package ioc.metadata;

import com.google.common.collect.Maps;
import common.Student;
import common.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @project: JavaLearning
 * @description: 基与xml文件的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-08 20:50
 **/
public class XmlBaseConfig {

    /**
     * 通过 {@link ClassPathXmlApplicationContext} 类读取xml文件配置的元数据
     * */
    public static void loadXmlByClassPath() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/xml-base-config.xml");
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
        Student student = beanFactory.getBean(Student.class);
        System.out.println(student);
    }

    /**
     * 通过 {@link XmlBeanDefinitionReader} 类读取xml文件配置的元数据
     * */
    public static void loadXmlByReader() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INFO/xml-base-config.xml");
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

    public static void main(String[] args) {
        loadXmlByClassPath();
    }
}