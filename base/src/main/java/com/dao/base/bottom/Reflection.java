package com.dao.base.bottom;

import com.dao.base.common.User;

import java.lang.reflect.Constructor;

/**
 * @project: Dao
 * @description: 通过反射创建对象
 * @author: Mabel.Chen
 * @create: 2021-11-20 19:06
 **/
public class Reflection {

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        try {
            Constructor<User> constructor = userClass.getDeclaredConstructor();
            User user = constructor.newInstance();
            user.setUserName("Mabel");
            System.out.println("User name is: " + user.getUserName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}