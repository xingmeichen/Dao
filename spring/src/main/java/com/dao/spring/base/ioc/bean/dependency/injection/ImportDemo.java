package com.dao.spring.base.ioc.bean.dependency.injection;

import com.dao.spring.base.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @project: Dao
 * @description: {@link Import} 示例
 * @author: Mabel.Chen
 * @create: 2020-09-06 22:28
 **/
@Import(User.class)
public class ImportDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ImportDemo.class);
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        applicationContext.close();
    }
}