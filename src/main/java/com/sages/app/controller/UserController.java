package com.sages.app.controller;

import com.sages.app.entity.db.User;
import com.sages.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userMapper.selectAll();
    }
}
