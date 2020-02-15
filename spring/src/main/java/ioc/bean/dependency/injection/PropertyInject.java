package ioc.bean.dependency.injection;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: JavaLearning
 * @description: 通过字段注入的方式完成依赖注入
 * @author: Mabel.Chen
 * @create: 2020-02-13 11:41
 **/
public class PropertyInject {

    @Autowired
    private User user;

    /**
     * {@link Autowired} 不处理静态字段，也就是会忽略掉static字段，
     * 原理可以查看 {@link AutowiredAnnotationBeanPostProcessor}
     * */
    public static void loadBeanByAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注意：这里注册的是当前类
        applicationContext.register(PropertyInject.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/annotation-base-config.xml");
        // 手动启动上下文 (注意：在加载或者说注册完元配置信息之后才能启动上下文)
        applicationContext.refresh();

        PropertyInject config = applicationContext.getBean(PropertyInject.class);
        System.out.println(config.user);

        // 手动关闭上下文
        applicationContext.close();
    }

    public static void main(String[] args) {
        loadBeanByAnnotation();
    }
}