package com.mabel.common;

import lombok.Data;

import java.util.Date;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-04-18 11:49
 **/
@Data
public class User {

    private Long id;
    private String userName;
    private Date birthday;
}