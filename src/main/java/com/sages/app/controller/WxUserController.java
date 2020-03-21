package com.sages.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sages.app.constant.ConfigProperty;
import com.sages.app.model.entity.User;
import com.sages.app.model.entity.WxUser;
import com.sages.app.model.post.WxUserInfo;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.service.IUserService;
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
@RequestMapping("/api")
public class WxUserController {


    private final WxUserService wxUserService;
    private final WxLoginProxyService wxLoginProxyService;
    private final IUserService userService;
    private final RedisUtil redisUtil;

    public WxUserController(WxUserService wxUserService, WxLoginProxyService wxLoginProxyService, IUserService userService, RedisUtil redisUtil) {
        this.wxUserService = wxUserService;
        this.wxLoginProxyService = wxLoginProxyService;
        this.userService = userService;
        this.redisUtil = redisUtil;
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam(name = "code",required = true) String code){
//        return ResponseEntity.ok(wxLoginProxyService.wxProxyLogin(code).toString());
//    }

    @PostMapping("/login")
    public ApiResponse login(@RequestParam String code) {
        String token = wxLoginProxyService.wxProxyLogin(code);
        return ApiResponse.ofSuccess(token);
    }

    @PostMapping("/updateUserInfo")
    public ApiResponse updateUserInfo(String token, String userInfo) {
        System.out.println(token);
        System.out.println(userInfo);
        WxUserInfo u = JSONObject.toJavaObject(JSON.parseObject(userInfo), WxUserInfo.class);
        WxUserInfo.UserInfoBean userInfoBean = u.getUserInfo();

        // 验证token
        JSONObject obj = wxLoginProxyService.getSessionAndOpenIdObj(token);
        if (obj==null){
            return ApiResponse.ofMessage("token失效");
        }
        // 建立 openId user
        String openId = (String) obj.get(ConfigProperty.OPEN_ID);
        // 更新用户
        User user = new User(openId, userInfoBean);
        boolean b = userService.saveOrUpdateUser(user);

        return ApiResponse.ofSuccess(b);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<WxUser>> getAllUser(String string) {
        System.out.println(string);
        List<WxUser> wxUsers = wxUserService.list();
//        wxUserService.
        return ResponseEntity.ok(wxUsers);
    }

    @GetMapping("/set")
    public ResponseEntity set() {
        redisUtil.set("key", "vluee", 5000L);
        return ResponseEntity.ok("wxUsers");
    }

    @GetMapping("/get")
    public ResponseEntity get() {
        return ResponseEntity.ok(redisUtil.getExpire("key"));
    }
}
