package com.dao.observer;

import java.util.Observable;

/**
 * @project:
 * @description: 这是一个主题（可被观察者）, 可以使用Java内置的观察者模式
 * @author: Mabel.Chen
 * @create: 2020/3/30
 **/
public class Subject extends Observable {

    public News news;

    /**
     * 通知观察者
     * 通知之前一定要设置为主题已经发生改变，也就是setChanged(), 否则通知方法不会被执行
     * */
    public void doNotify() {
        this.news = new News();
        System.out.println();
        // 设置变化属性，只有设置为已经变化才通知成功
        this.setChanged();
        // 通知观察者（通知观察者可以带参数）
        this.notifyObservers(news);
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        // 注册观察者
        subject.addObserver(new MabelObserver());
        // 通知观察者
        subject.doNotify();
    }
}
