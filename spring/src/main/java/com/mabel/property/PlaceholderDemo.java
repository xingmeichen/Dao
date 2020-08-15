package com.mabel.property;

import com.mabel.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project:
 * @description: 在配置文件中使用占位符读取配置信息示例
 * @author: Mabel.Chen
 * @create: 2020/8/10
 **/
public class PlaceholderDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/placeholder.xml");
        User user = context.getBean(User.class);
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
}
