package com.dao.spring.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-10 13:50
 **/
@Data
@Accessors(chain = true)
public class User {

    private Long id;
    private String name;

    public User() {
        this.id = 10000L;
        this.name = "Mabel";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(10000L).setName("Mabel");
        return user;
    }
}