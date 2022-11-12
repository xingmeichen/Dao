package com.dao.ioc.bean.lifecycle;

import com.dao.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @project: JavaLearning
 * @description: Bean 元信息配置
 * @author: Mabel.Chen
 * @create: 2020-03-08 11:14
 **/
public class BeanMetadataConfigration {

    /**
     * 基于 xml 文件的元信息配置
     * */
    public static void configByXml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/xml-base-config.xml";
        reader.loadBeanDefinitions(location);
        User bean = beanFactory.getBean("user", User.class);
        System.out.println(bean);
    }

    /**
     * 基于Property 文件的元信息配置
     * 注意：
     * 1. 文件路径的编写问题
     * 2. 解决文件编码问题
     * 3. 注意properties文件配置的编写问题
     * */
    public static void configeByProperties() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        /**
         * 加载 基于 Classpath 的 properties 资源
         * */
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        // String location = "classpath:/META-INF/user.properties";  // 注意location的写法
        String location = "META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        reader.loadBeanDefinitions(encodedResource);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

    public static void main(String[] args) {
        configeByProperties();
        configByXml();
    }
}