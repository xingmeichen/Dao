package ioc.bean.dependency.injection;

import domain.User;
import domain.UserAnnotation;
import domain.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.Map;

/**
 * @project: JavaLearning
 * @description: 依赖注入
 * @author: Mabel.Chen
 * @create: 2020-02-14 11:30
 **/
public class DependencyInject {

    /**
     * 手动配置依赖注入
     * */
    public static void injectByManualConfig(BeanFactory beanFactory) {
        UserRepository repository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(repository.getUsers());
    }

    /**
     * 自动装配依赖注入
     * */
    public static void injectByAutoWiring(BeanFactory beanFactory) {
        UserRepository repository = (UserRepository) beanFactory.getBean("autoWiringUserRepository");
        System.out.println(repository.getUsers());
    }

    public static void fetchBeanFactory(BeanFactory beanFactory) {
        UserRepository repository = (UserRepository) beanFactory.getBean("autoWiringUserRepository");
        /**
         * 要能使 repositoryBeanFactory 不是null, 则UserRepository必须是自动装配，
         * 也就是说如果这里的getBean改成userRepository，则 repositoryBeanFactory为null
         */
        BeanFactory repositoryBeanFactory = repository.getBeanFactory();
        System.out.println(repositoryBeanFactory);
        System.out.println(repositoryBeanFactory == beanFactory); // false (A)

        ObjectFactory<ApplicationContext> applicationContext = repository.getApplicationContext();
        System.out.println(applicationContext.getObject() == beanFactory); // true (B)

        // A 和 B的结果一个是false，一个是true,说明了依赖查找和依赖注入并不同源
    }


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject.xml");
        injectByManualConfig(beanFactory);
        injectByAutoWiring(beanFactory);

        System.out.println("---------- fetch BeanFactory Start: ------------");
        fetchBeanFactory(beanFactory);
        System.out.println("---------- fetch BeanFactory end: ------------");
    }
}