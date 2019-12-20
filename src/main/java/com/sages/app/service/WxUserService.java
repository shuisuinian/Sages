package com.sages.app.service;

import com.sages.app.model.entity.WxUser;

import java.util.List;

/**
 * @author wanyifan
 * @date 2019/12/20 9:19
 */
public interface WxUserService {
    /**
     * 获取所有用户信息列表
     * @return list
     */
    List<WxUser> listWxUsers();
}
