package com.dao.spring.event.jdk;

import java.util.EventObject;
import java.util.Observable;

/**
 * @project:
 * @description: 可观察者
 * @author: Mabel.Chen
 * @create: 2020/6/21
 **/
public class EventObservable extends Observable {

    public void setChange() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        setChange();
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object message) {
        setChange();
        super.notifyObservers(new EventObject(message));
        clearChanged();
    }

    public static void main(String[] args) {
        Observable observable = new EventObservable();
        // 添加观察者（监听者）
        observable.addObserver(new EventObserver());
        // 发布事件
        observable.notifyObservers(new EventObject("Hello World"));
    }
}
