package com.dao.app.service.impl;

import com.dao.app.domain.User;
import com.dao.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void getUserByIdTest() {
        when(userRepository.findById(1l)).thenReturn(Optional.of(new User()));
        User user = userService.getUserById(1l);
        Assertions.assertNotNull(user);
    }
}