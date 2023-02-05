package com.dao;

import java.util.Properties;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-11-12
 **/
public class PropertyUtil {

    public static Properties loadPropertyInClasspath(String file) throws Exception {
        Properties properties = new Properties();
        properties.load(PropertyUtil.class.getResourceAsStream(file));
        return properties;
    }
}