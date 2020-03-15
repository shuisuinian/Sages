package com.sages.app.service.impl;

import com.sages.app.model.entity.UserAddr;
import com.sages.app.mapper.UserAddrMapper;
import com.sages.app.service.IUserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户收货地址 服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-04
 */
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrMapper, UserAddr> implements IUserAddrService {

}
