package com.dao.app.service;

import com.dao.app.domain.User;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public interface UserService {

    User getUserById(Long id);
}