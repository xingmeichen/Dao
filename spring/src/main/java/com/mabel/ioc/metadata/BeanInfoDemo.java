package com.mabel.ioc.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-01-04 09:32
 **/
public class BeanInfoDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanInfo.class);

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo();
            Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
                String propertyName = propertyDescriptor.getName();
                System.out.println(propertyName);
            });
        } catch (IntrospectionException e) {
            LOGGER.error("get ioc info error");
        }
    }
}