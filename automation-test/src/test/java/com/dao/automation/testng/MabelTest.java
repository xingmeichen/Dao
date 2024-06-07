package com.dao.automation.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @project: Dao
 * @description:
 * automation.testng configuration:
 * automation.testng.xml
 * maven plugin: configure the automation.testng.xml
 * @author: Mabel.Chen
 * @create: 2021-06-17 12:41
 **/
public class MabelTest {

    @Test
    @Parameters({"username"})
    public void mabelTest(String username) {
        System.out.println("Test start... ");
        System.out.println("My name is " + username);
        System.out.println("Test end... ");
    }

    @Test
    @Parameters({"username"})
    public void mabelTest2() {
        System.out.println("Test start... ");
        System.out.println("My name is Mabel");
        System.out.println("Test end... ");
    }
}