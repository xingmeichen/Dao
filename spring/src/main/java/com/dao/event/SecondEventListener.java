package com.dao.event;

import org.springframework.context.ApplicationListener;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-09 18:41
 **/
public class SecondEventListener implements ApplicationListener<MabelEvent> {

    @Override
    public void onApplicationEvent(MabelEvent event) {
        System.out.println("I am [" + this.getClass().getSimpleName() + "], I am listening [" + MabelEvent.class.getSimpleName() + "]");
    }
}