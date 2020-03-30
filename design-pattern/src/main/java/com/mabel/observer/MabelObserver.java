package com.mabel.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @project:
 * @description: 这是一个观察者
 * @author: Mabel.Chen
 * @create: 2020/3/30
 **/
public class MabelObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("*************** 今天发布了一条新闻了！！快去看看吧  ***************");
        News news = (News) arg;
        if (null == news) {
            System.out.println("今天没有任何新闻");
            return;
        }
        System.out.println(news.getContent());
    }
}
