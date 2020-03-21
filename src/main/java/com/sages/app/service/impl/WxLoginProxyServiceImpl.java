package com.sages.app.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sages.app.constant.ConfigProperty;
import com.sages.app.constant.enums.Status;
import com.sages.app.exception.JsonException;
import com.sages.app.service.WxLoginProxyService;
import com.sages.app.util.RedisUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wanyifan
 * @date 2019/12/21 16:59
 */
@Service
public class WxLoginProxyServiceImpl implements WxLoginProxyService {

    private final RedisUtil redisUtil;

    public WxLoginProxyServiceImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public String wxProxyLogin(String jsCode) {
        // 使用httpclient从微信平台获取session_key 和 openid
        HashMap<String, Object> paramMap = new HashMap<>(4);
        paramMap.put("appid", ConfigProperty.WxAppId);
        paramMap.put("secret", ConfigProperty.WxAppSecret);
        paramMap.put("grant_type", ConfigProperty.grantType);
        paramMap.put("js_code", jsCode);
        String ret = HttpUtil.get(ConfigProperty.WxUrl, paramMap);
        if ("".equals(ret) || ret == null) {
            throw new JsonException(Status.CONNECTION_TIMEOUT);
        }
        JSONObject object = JSONObject.parseObject(ret);
        if (object.containsKey(ConfigProperty.ERROR_CODE)) {
            throw new JsonException(Status.UNKNOWN_ERROR.getCode(), object.get(ConfigProperty.ERROR_CODE).toString());
        }
        String sessionKey = object.get(ConfigProperty.SESSION_KEY).toString();
        String openId = object.get(ConfigProperty.OPEN_ID).toString();

        //伪造两个缓存
//        redisUtil.set(openId,"000-000-000-000",5000L);
//        redisUtil.set("000-000-000-000","ssss{}ssss",5000L);
        // 删除之前的缓存
//        String oldToken = "";
//        if (redisUtil.get(openId)!=null) {
//            oldToken = redisUtil.get(openId).toString();
//            System.out.println("old-token:"+oldToken);
//        }
//        // 之前的缓存
//        redisUtil.del(openId);
//        System.out.println("是不是删除了old-token呢？ " + redisUtil.get(openId));
//        String oldSessionObj = "";
//        if (redisUtil.get(oldToken)!=null){
//            oldSessionObj = redisUtil.get(oldToken).toString();
//        }
//        System.out.println("sessionobj-old"+oldSessionObj);
//        System.out.println("是不是删除了ooldSessionObj呢？ " + redisUtil.get(oldToken));
//        redisUtil.del(oldToken);
        // 设置当前缓存
        String token = UUID.randomUUID().toString();
        JSONObject sessionObj = new JSONObject();
        sessionObj.put(ConfigProperty.OPEN_ID, openId);
        sessionObj.put(ConfigProperty.SESSION_KEY, sessionKey);
        //  key-uuid    value-sessionObj  进入缓存
        redisUtil.set(token, sessionObj.toJSONString(), 5000L);
        // key-openid   value-uuid;   进入缓存
//        redisUtil.set(openId,token,5000L);
        // 把 token 返回给小程序
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return redisUtil.get(token) != null;
    }

    @Override
    public JSONObject getSessionAndOpenIdObj(String token) {
        Object obj;
        if (checkToken(token)){
             obj = redisUtil.get(token);
        }else {
            return null;
        }
        return JSONObject.parseObject(obj.toString());
    }
}
