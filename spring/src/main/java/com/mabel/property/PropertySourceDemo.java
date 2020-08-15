package com.mabel.property;

import com.mabel.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project:
 * @description: 读取配置文件中的占位符参数示例， 具体实现支持请查看
 * {@link org.springframework.context.support.PropertySourcesPlaceholderConfigurer }
 * @author: Mabel.Chen
 * @create: 2020/8/10
 **/
public class PropertySourceDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/property-source.xml");
        User user = context.getBean(User.class);
        System.out.println(user.getId());
        // 这里读取到的 user name 会是系统的环境变量，具体请查看配置文件解析类
        // {@link org.springframework.context.support.PropertySourcesPlaceholderConfigurer }
        System.out.println(user.getName());
    }
}
