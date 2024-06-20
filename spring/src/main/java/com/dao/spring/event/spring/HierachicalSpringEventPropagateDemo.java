package com.dao.spring.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project:
 * @description: 层次性Spring事件传播示例
 * @author: Mabel.Chen
 * @create: 2020/7/26
 **/
public class HierachicalSpringEventPropagateDemo {

    static class MabelListener implements ApplicationListener<ApplicationEvent> {
        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            System.out.println("Listening Spring Context [ ID : " + event.getClass().getSimpleName() + "] ContextRefreshedEvent");
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        parentContext.register(MabelListener.class);

        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        currentContext.setParent(parentContext);
        currentContext.register(MabelListener.class);

        /**
         * 启动应用上下文，这里必须先启动父应用上下文
         * */
        parentContext.refresh();
        currentContext.refresh();

        /**
         * 注意：关闭应用上下文没有顺序要求，但是关闭的顺序不同，具体执行了哪些方法回调会不一样，
         * 例如如果先关闭父应用上线文，则 ContextClosedEvent事件的监听器在currentContext close的只会执行一次，否则就是两次
         * */
        currentContext.close();
        parentContext.close();
    }
}
