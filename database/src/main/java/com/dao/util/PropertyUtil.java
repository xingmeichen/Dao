package com.dao.util;

import java.util.Properties;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-11-12
 **/
public class PropertyUtil {

    public Properties loadPropertyInClassPath(String file) throws Exception {
        Properties properties = new Properties();
        properties.load(PropertyUtil.class.getClassLoader().getResourceAsStream(file));
        return properties;
    }
}