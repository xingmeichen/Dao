package com.dao.app.controller;

import com.dao.app.domain.User;
import com.dao.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    @GetMapping("/users/list")
    public List<User> listUsers() {
        return userServiceImpl.listUsers();
    }

    @GetMapping("/users/username")
    public User getUserByUserName(@RequestParam("userName") String userName) {
        return userServiceImpl.getUserByUserName(userName);
    }
}