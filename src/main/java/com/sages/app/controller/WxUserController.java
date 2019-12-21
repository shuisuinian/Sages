package com.sages.app.controller;

import com.sages.app.model.entity.WxUser;
import com.sages.app.service.WxLoginProxyService;
import com.sages.app.service.WxUserService;
import com.sages.app.util.RedisUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanyifan
 * @date 2019/12/20 9:12
 */
@RestController
@RequestMapping("/api/user")
public class WxUserController {

    private final WxUserService wxUserService;
    private final WxLoginProxyService wxLoginProxyService;
    private final RedisUtil redisUtil;

    public WxUserController(WxUserService wxUserService, WxLoginProxyService wxLoginProxyService, RedisUtil redisUtil) {
        this.wxUserService = wxUserService;
        this.wxLoginProxyService = wxLoginProxyService;
        this.redisUtil = redisUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(name = "code",required = true) String code){
        return ResponseEntity.ok(wxLoginProxyService.wxProxyLogin(code).toString());
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<WxUser>> getAllUser(String string){
        System.out.println(string);
        List<WxUser> wxUsers = wxUserService.listWxUsers();
        return ResponseEntity.ok(wxUsers);
    }

    @GetMapping("/set")
    public ResponseEntity set(){
        redisUtil.set("key","vluee",5000L);
        return ResponseEntity.ok("wxUsers");
    }
    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.ok(redisUtil.getExpire("key"));
    }
}
