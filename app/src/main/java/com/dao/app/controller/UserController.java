package com.dao.app.controller;

import com.dao.app.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return new User();
    }
}