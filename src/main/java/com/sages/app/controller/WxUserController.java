package com.sages.app.controller;

import com.sages.app.model.entity.WxUser;
import com.sages.app.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wanyifan
 * @date 2019/12/20 9:12
 */
@RestController
@RequestMapping("/user")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;
    @GetMapping("/getAllUser")
    public ResponseEntity<List<WxUser>> getAllUser(){
        List<WxUser> wxUsers = wxUserService.listWxUsers();
        return ResponseEntity.ok(wxUsers);
    }
}
