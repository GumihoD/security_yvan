package com.yvan.security.service;

import com.yvan.security.entity.User;
import com.yvan.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yvan on 16/4/27.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findOneUser(long userId) {
        return userRepository.findOne(userId);
    }
}
