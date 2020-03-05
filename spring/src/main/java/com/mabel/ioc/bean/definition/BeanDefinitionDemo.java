package com.mabel.ioc.bean.definition;

import com.mabel.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 16:26
 **/
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1000);
        builder.addPropertyValue("name", "Mabel");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
    }
}