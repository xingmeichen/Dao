package com.dao.spring.ioc.metadata;

import com.dao.spring.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: Dao
 * @description: 基于Java Api的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-10 18:00
 **/
public class ApiBaseConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinition beanDefinition = createBeanDefinition();
        applicationContext.registerBeanDefinition("user", beanDefinition);

        // 手动启动应用上下文（务必注意它的启动时期，在载入配置信息完成后才能启动）
        applicationContext.refresh();

        User user = (User) applicationContext.getBean("user");

        System.out.println(user);

        // 手动停止应用上下文
        applicationContext.close();
    }

    private static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1000);
        builder.addPropertyValue("name", "Mabel");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        return beanDefinition;
    }
}