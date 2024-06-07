package com.dao.spring.base.domain;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-10 13:50
 **/
@Data
public class Student extends User {

    /** 学号 */
    private String number;
}