package com.mabel.event;

import org.springframework.context.ApplicationListener;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-09 14:23
 **/
public class MabelEventListener implements ApplicationListener<MabelEvent> {

    @Override
    public void onApplicationEvent(MabelEvent mabelEvent) {
        String message = mabelEvent.getMessage();
        System.out.println("I am ["+ this.getClass().getSimpleName() + "], I am listening [" + MabelEvent.class.getSimpleName() + "]");
        System.out.println("I get some message, it says " + message);
    }
}