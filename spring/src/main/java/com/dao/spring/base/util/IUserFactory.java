package com.dao.spring.base.util;

import com.dao.spring.base.domain.User;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 17:29
 **/
public interface IUserFactory {

    default User createUser() {
        return User.createUser();
    }
}