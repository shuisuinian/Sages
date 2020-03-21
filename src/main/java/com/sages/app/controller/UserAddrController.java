package com.sages.app.controller;


import com.alibaba.fastjson.JSONObject;
import com.sages.app.constant.ConfigProperty;
import com.sages.app.model.entity.UserAddr;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.service.IUserAddrService;
import com.sages.app.service.WxLoginProxyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户收货地址 前端控制器
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-04
 */
@RestController
@RequestMapping("/api/addr")
public class UserAddrController {

    private final IUserAddrService userAddrService;
    private final WxLoginProxyService wxLoginProxyService;

    public UserAddrController(IUserAddrService userAddrService, WxLoginProxyService wxLoginProxyService) {
        this.userAddrService = userAddrService;
        this.wxLoginProxyService = wxLoginProxyService;
    }

    @GetMapping("/list")
    public ApiResponse listUserAddr(HttpServletRequest request){
        String token = request.getHeader(ConfigProperty.TOKEN);
        JSONObject obj = wxLoginProxyService.getSessionAndOpenIdObj(token);
        Object openId = obj.get(ConfigProperty.OPEN_ID);

        List<UserAddr> userAddrList = userAddrService.listAddrByOpenId(openId.toString());
        return ApiResponse.ofSuccess(userAddrList);
    }

    @DeleteMapping
    public ApiResponse delAddr(Integer id){
        boolean b = userAddrService.removeById(id);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }
}

