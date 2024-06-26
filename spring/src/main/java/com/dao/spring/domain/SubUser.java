package com.dao.spring.domain;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 10:47
 **/
@Data
@UserAnnotation
public class SubUser extends User {

    private String phone;

    @Override
    public String toString() {
        return "SubUser{" +
                "phone='" + phone + '\'' +
                "} " + super.toString();
    }
}