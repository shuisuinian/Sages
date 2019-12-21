package com.sages.app.service;

/**
 * @author wanyifan
 * @date 2019/12/21 15:57
 */
public interface WxLoginProxyService {
    /**
     * 微信小程序登录
     * @param jsCode js_code 登录时的code
     * @return token
     */
    Object wxProxyLogin(String jsCode);
}
