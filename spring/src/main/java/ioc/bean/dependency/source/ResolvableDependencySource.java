package ioc.bean.dependency.source;


import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

public class ResolvableDependencySource {

    @Autowired
    private User user;

    @PostConstruct
    public void init() {
        User user = User.createUser();
        System.out.println(user.getId() + " --> " + user.getName());
    }

    /**
     * 非Spring容器管理对象作为依赖来源的一个错误示例
     * */
    public static void errorDemo() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySource.class);
        applicationContext.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof ConfigurableListableBeanFactory) {
            ConfigurableListableBeanFactory configurableListableBeanFactory = ConfigurableListableBeanFactory.class.cast(autowireCapableBeanFactory);
            configurableListableBeanFactory.registerResolvableDependency(User.class, User.createUser());
        }
        applicationContext.close();
    }

    /**
     * 非Spring容器管理对象作为依赖来源的一个正确示例
     * */
    public static void successDemo() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySource.class);
        // 这是一个回调操作
        applicationContext.addBeanFactoryPostProcessor(factory -> factory.registerResolvableDependency(User.class, User.createUser()));

        applicationContext.refresh();

        applicationContext.close();
    }
    public static void main(String[] args) {
        //errorDemo();
        successDemo();
    }
}
