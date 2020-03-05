package com.mabel.ioc.bean.destroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-15 15:57
 **/
public class BeanDestroy {

    /**
     * 输出结果：
     * Spring应用上下文准备关闭...
     * 基于@PreDestroy的销毁方法：DestroyDomain 销毁中...
     * 实现 DisposableBean 接口的 destroy() 销毁方法：DestroyDomain 销毁中...
     * 自定义销毁方法：DestroyDomain 销毁中...
     * Spring应用上下文已经关闭
     *
     * （1）从输出结果中可以看出3中销毁方法的优先级
     * （2）ApplicationContext 的 close() 方法触发了销毁方法
     * */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDestroy.class);
        applicationContext.refresh();
        System.out.println("Spring应用上下文准备关闭...");
        applicationContext.close();
        System.out.println("Spring应用上下文已经关闭");
    }

    @Bean(destroyMethod = "customDestroy")
    public DestroyDomain fetchDestroyDomain() {
        return new DestroyDomain();
    }
}