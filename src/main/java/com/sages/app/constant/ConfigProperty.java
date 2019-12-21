package com.sages.app.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件信息读取类
 * @author wanyifan
 * @date 2019/12/19 9:57
 */
@ConfigurationProperties(prefix = "wx.app",ignoreInvalidFields = false)
@PropertySource("classpath:config/config.yml")
@Component
public class ConfigProperty {
    public static String WxAppId;
    @Value("${id}")
    public  void setWxAppId(String wxAppId) {
        WxAppId = wxAppId;
    }

    public static String WxAppSecret;
    @Value("${secret}")
    public void setWxAppSecret(String wxAppSecret) {
        WxAppSecret = wxAppSecret;
    }

    public static String WxUrl;
    @Value("${url}")
    public void setWxUrl(String wxUrl) {
        WxUrl = wxUrl;
    }

    public static String grantType;
    @Value("${grant-type}")
    public void setGrantType(String grantType) {
        ConfigProperty.grantType = grantType;
    }

    public static final String ERRCODE = "errcode";
    public static final String SESSION_KEY = "session_key";
    public static final String OPEN_ID = "openid";
}
