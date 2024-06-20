package com.dao.app.service.impl;

import com.dao.app.domain.User;
import com.dao.app.service.UserService;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Long id) {
        return new User();
    }
}