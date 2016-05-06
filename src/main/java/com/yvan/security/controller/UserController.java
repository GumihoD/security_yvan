package com.yvan.security.controller;

import com.yvan.security.entity.User;
import com.yvan.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userController")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "findOne",method = RequestMethod.POST)
    User findOneUser(@RequestParam long userId) {
        return userService.findOneUser(userId);
    }


}
