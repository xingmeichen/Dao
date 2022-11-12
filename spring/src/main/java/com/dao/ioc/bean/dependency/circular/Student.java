package com.dao.ioc.bean.dependency.circular;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-10 13:50
 **/
@Data
public class Student {

    /** 学号 */
    private String number;

    @Autowired
    private Collection<Subject> subjects;
}