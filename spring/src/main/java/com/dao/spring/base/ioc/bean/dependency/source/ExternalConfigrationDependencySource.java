package com.dao.spring.base.ioc.bean.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @project: Dao
 * @description: 外部化配置作为依赖来源示例
 * 注意事项：
 * 1、在类上使用@Configuration必不可少
 * 2、@PropertySource 的value值的路径要写对，如果配置文件中有中文，还需要注意编码问题
 * 3、@Value还可以有默认值，也就是没有找到配置的值的情况下取默认值，例如 @Value("${user.id:-1}") 表示默认值是-1（冒号后面的值就是默认值）
 * @author: Mabel.Chen
 * @create: 2020-02-29 11:57
 **/
@Configuration
@PropertySource(value = "META-INF/default.properties", encoding = "UTF-8")
public class ExternalConfigrationDependencySource {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.name:小陈}")
    private String name;

    @Value("${user.resource:没有资源可以加载}")
    private Resource resource;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ExternalConfigrationDependencySource.class);
        applicationContext.refresh();

        ExternalConfigrationDependencySource bean = applicationContext.getBean(ExternalConfigrationDependencySource.class);
        System.out.println("User ID：" + bean.id);
        System.out.println("User Name： " + bean.name);
        System.out.println("User Resource： " + bean.resource);

        applicationContext.close();
    }
}