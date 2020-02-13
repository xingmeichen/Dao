package ioc.metadata;

import common.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: JavaLearning
 * @description: 基于Java Api的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-10 18:00
 **/
public class ApiBaseConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = createBeanDefinition("user");
        applicationContext.registerBeanDefinition("user", beanDefinition);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INFO/xml-base-config.xml");

        // 手动启动应用上下文（务必注意它的启动时期，在载入配置信息完成后才能启动）
        applicationContext.refresh();

        User user = (User) applicationContext.getBean("user");

        System.out.println(user);

        // 手动停止应用上下文
        applicationContext.close();
    }

    private static BeanDefinition createBeanDefinition(String beanClassName) {
        return BeanDefinitionBuilder.genericBeanDefinition(beanClassName).getBeanDefinition();
    }
}