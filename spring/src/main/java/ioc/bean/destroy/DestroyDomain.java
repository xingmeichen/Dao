package ioc.bean.destroy;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-15 16:10
 **/
public class DestroyDomain implements DisposableBean {

    @PreDestroy
    public void preDestory() {
        System.out.println("基于@PreDestroy的销毁方法：DestroyDomain 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现 DisposableBean 接口的 destroy() 销毁方法：DestroyDomain 销毁中...");
    }

    public void customDestroy() {
        System.out.println("自定义销毁方法：DestroyDomain 销毁中...");
    }
}