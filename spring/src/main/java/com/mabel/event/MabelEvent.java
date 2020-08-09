package com.mabel.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-09 14:21
 **/
@Getter
public class MabelEvent extends ApplicationEvent {

    private String message;

    public MabelEvent(Object source) {
        super(source);
    }

    public MabelEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}