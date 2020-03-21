package com.sages.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sages.app.model.entity.UserAddr;

import java.util.List;

/**
 * <p>
 * 用户收货地址 服务类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-04
 */
public interface IUserAddrService extends IService<UserAddr> {

    /**
     * 获取地址信息列表
     *
     * @param openId
     * @return
     */
    List<UserAddr> listAddrByOpenId(String openId);
}
