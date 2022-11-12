package com.dao.domain;

import lombok.Data;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-01-04 09:33
 **/
@Data
@UserAnnotation
public class Person {

    private String name;
    private Integer age;
}