package com.dao.spring.ioc.bean.definition;

import com.dao.spring.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 16:26
 **/
public class BeanDefinitionDemo {

    public static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1000);
        builder.addPropertyValue("name", "Mabel");
        return builder.getBeanDefinition();
    }

    public static void getDetailOfBeanDefinition() {
        BeanDefinition beanDefinition = createBeanDefinition();
        /**
         * Here, you can try all functions of BD to know more detail about it.
         * */
        System.out.println(beanDefinition.getBeanClassName());
        System.out.println(beanDefinition.getDependsOn());
        System.out.println(beanDefinition.getDestroyMethodName());
        System.out.println(beanDefinition.getDescription());
    }

    public static void main(String[] args) {

    }
}