package com.dao.spring.ioc.bean.dependency.injection;

import com.dao.spring.domain.User;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.Set;

/**
 * @project: Dao
 * @description: 基于注解的依赖注入的处理过程示例
 * （也就是说Spring它具体是如何处理基于注解依赖注入的）
 * @author: Mabel.Chen
 * @create: 2020-02-16 12:25
 **/
public class AnnotationDependencyInjectResolution {

    /**
     * 延迟依赖注入
     */
    @Autowired
    @Lazy
    private User lazyUser;

    /**
     * 通过 @Autowired 注解注入
     * 实时注入 + 通过类型（User.class）依赖查找（处理） + 字段名称
     * */
    @Autowired
    private User user;

    /**
     * 集合类型的依赖注入
     * */
    @Autowired
    private Map<String, User> users;

    /**
     * 依赖处理过程中涉及到的源码：
     * 依赖处理的入口：
     * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter)}
     * 依赖描述：{@link DependencyDescriptor}
     * 自定义绑定候选对象处理器： {@link AutowireCandidateResolver}
     *
     * */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("user", beanDefinition);
        applicationContext.refresh();
        applicationContext.close();
    }
}