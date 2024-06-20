package com.dao.base.common;

import java.util.Date;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-04-18 11:49
 **/
public class User {
    private Long id;
    private String userName;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}