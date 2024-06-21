package com.dao.app.service.impl;

import com.dao.app.domain.User;
import com.dao.app.repository.UserRepository;
import com.dao.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listUsers() {
        Stream<User> users = Stream.of(new User(), new User());
        return users.toList();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.queryByUserName(userName);
    }
}