package com.mabel.project;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @project: JavaLearning
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