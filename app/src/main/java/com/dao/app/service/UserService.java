package com.dao.app.service;

import com.dao.app.domain.User;

import java.util.List;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public interface UserService {

    User getUserById(Long id);

    List<User> listUsers();

    User getUserByUserName(String userName);
}