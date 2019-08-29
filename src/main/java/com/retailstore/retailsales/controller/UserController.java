package com.retailstore.retailsales.controller;

import com.retailstore.retailsales.model.user.UserInfo;
import com.retailstore.retailsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Optional<UserInfo> add(@RequestBody UserInfo userInfo){
        return userService.save(userInfo);
    }

}
