package com.dao.bottom;

import java.util.Properties;
import java.util.Set;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-11-20 19:13
 **/
public class SystemLearning {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        propertyNames.forEach(name -> System.out.println(name));
    }
}