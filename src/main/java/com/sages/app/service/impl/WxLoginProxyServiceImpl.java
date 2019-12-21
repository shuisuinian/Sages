package com.sages.app.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.sages.app.constant.ConfigProperty;
import com.sages.app.constant.enums.Status;
import com.sages.app.exception.JsonException;
import com.sages.app.service.WxLoginProxyService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author wanyifan
 * @date 2019/12/21 16:59
 */
@Service
public class WxLoginProxyServiceImpl implements WxLoginProxyService {
    @Override
    public Object wxProxyLogin(String jsCode) {

        // 使用httpclient从微信平台获取session_key 和 openid
        HashMap<String,Object> paramMap = new HashMap<>(4);
        paramMap.put("appid",ConfigProperty.WxAppId);
        paramMap.put("secret",ConfigProperty.WxAppSecret);
        paramMap.put("grant_type",ConfigProperty.grantType);
        paramMap.put("js_code",jsCode);
        String ret = HttpUtil.get(ConfigProperty.WxUrl, paramMap);
        if ("".equals(ret)||ret ==null) {
            throw new JsonException(Status.CONNECTION_TIMEOUT);
        }
        JSONObject object = JSONObject.parseObject(ret);
        if (object.containsKey(ConfigProperty.ERRCODE)) {
            throw new JsonException(Status.UNKNOWN_ERROR.getCode(),object.get(ConfigProperty.ERRCODE).toString());
        }
        String sessionKey = object.get(ConfigProperty.SESSION_KEY).toString();
        String openId = object.get(ConfigProperty.OPEN_ID).toString();

        // 删除之前的缓存
        String token = UUID.randomUUID().toString();
        JSONObject sessionObj = new JSONObject();
        sessionObj.put("openId",openId);
        sessionObj.put("sessionKey",sessionKey);
        //  key-uuid    value-sessionObj  进入缓存

        // key-openid   value-uuid;   进入缓存

        // 把 token 返回给小程序
        return token;
    }
}
