package com.dao.spring.event.jdk;

import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @project:
 * @description: 观察者, 也就是相当于监听者
 * @author: Mabel.Chen
 * @create: 2020/6/21
 **/
public class EventObserver implements Observer, EventListener {

    @Override
    public void update(Observable o, Object message) {
        System.out.println("get some message: " + message);
    }
}
