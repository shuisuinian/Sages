package com.sages.app.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wanyifan
 * @date 2019/12/21 15:57
 */
public interface WxLoginProxyService {
    /**
     * 微信小程序登录
     *
     * @param jsCode js_code 登录时的code
     * @return token
     */
    String wxProxyLogin(String jsCode);

    /**
     * 检查 token
     *
     * @param token token
     * @return true。false
     */
    boolean checkToken(String token);

    /**
     * 获取session and openId
     *
     * @param token token
     * @return JSONObject
     */
    JSONObject getSessionAndOpenIdObj(String token);
}
