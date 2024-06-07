package com.dao.base.bottom;

import com.dao.base.common.User;
import org.openjdk.jol.info.ClassLayout;

import java.util.Date;

/**
 * @project: Dao
 * @description: 对象内存布局示例
 * @author: Mabel.Chen
 * @create: 2020-04-18 11:46
 **/
public class ObjectLayout {

    public static void main(String[] args) {
        Object object = new Object();
        String layoutStr = ClassLayout.parseInstance(object).toPrintable();
        System.out.println(layoutStr);
        System.out.println("*********************-----------------*****************");
        User user = new User();
        System.out.println(ClassLayout.parseClass(User.class).toPrintable());
        System.out.println("*********************-----------------*****************");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        user.setId(1L);
        user.setUserName("Peter");
        user.setBirthday(new Date());
        System.out.println("*********************-----------------*****************");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

    }
}