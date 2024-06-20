package com.dao.spring.event.spring;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @project:
 * @description:
 * @author: Mabel.Chen
 * @create: 2020/7/26
 **/
@Data
public class MabelEvent extends ApplicationEvent {

    private String name;

    public MabelEvent(Object source) {
        super(source);
    }

    public MabelEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
