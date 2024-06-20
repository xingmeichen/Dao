package com.dao.designpattern.observer;

import lombok.Data;

/**
 * @project:
 * @description:
 * @author: Mabel.Chen
 * @create: 2020/3/30
 **/
@Data
public class News {

    private String content;

    public News() {
        this.content = "新闻直播间开始为您播报今日消息......";
    }
}
