package com.dao.ioc.bean.dependency.circular;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @project: JavaLearning
 * @description: 学科类
 * @author: Mabel.Chen
 * @create: 2020-02-13 15:46
 **/
@Data
public class Subject {

    private String name;

    @Autowired
    private Collection<Student> students;
}