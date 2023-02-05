package com.dao.ioc.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @project: Dao
 * @description: Ioc 容器
 * @author: Mabel.Chen
 * @create: 2020-02-14 15:06
 **/
public class BeanFactoryAsIocContainer {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载配置, 返回值是Bean定义的数量
        int beanDefinitionNumber = reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");
        System.out.println(beanDefinitionNumber);
    }
}