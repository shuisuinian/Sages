package com.sages.app.controller;

import com.sages.app.model.entity.WxUser;
import com.sages.app.service.WxLoginProxyService;
import com.sages.app.service.WxUserService;
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

    public WxUserController(WxUserService wxUserService, WxLoginProxyService wxLoginProxyService) {
        this.wxUserService = wxUserService;
        this.wxLoginProxyService = wxLoginProxyService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(name = "code",required = true) String code){
        return ResponseEntity.ok("token:"+wxLoginProxyService.wxProxyLogin(code).toString());
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<WxUser>> getAllUser(String string){
        System.out.println(string);
        List<WxUser> wxUsers = wxUserService.listWxUsers();
        return ResponseEntity.ok(wxUsers);
    }
}
