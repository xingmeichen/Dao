package com.dao.project;

import java.io.File;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-12-20 22:17
 **/
public class Project {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        System.out.println(new File("").getAbsoluteFile());
        System.out.println(new File("/").getAbsoluteFile());
    }
}