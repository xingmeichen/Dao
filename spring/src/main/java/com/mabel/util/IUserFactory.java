package com.mabel.util;

import com.mabel.domain.User;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 17:29
 **/
public interface IUserFactory {

    default User createUser() {
        return User.createUser();
    }
}