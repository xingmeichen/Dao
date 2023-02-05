package com.dao.condition;

import org.springframework.context.annotation.*;

/**
 * @project: Dao
 * @description: // TODO
 * @author: Mabel.Chen
 * @create: 2020-09-03 08:22
 **/
@Conditional(MabelCondition.class)
public class ConditionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MabelCondition.class);
        context.register(ConditionDemo.class);
        context.refresh();
        MabelCondition mabelCondition = context.getBean(MabelCondition.class);
        System.out.println(mabelCondition);
        ConditionDemo demo = context.getBean(ConditionDemo.class);
        System.out.println(demo);
        context.close();
    }
}