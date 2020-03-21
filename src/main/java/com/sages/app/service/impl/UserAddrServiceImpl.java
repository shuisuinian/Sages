package com.sages.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sages.app.model.entity.User;
import com.sages.app.model.entity.UserAddr;
import com.sages.app.mapper.UserAddrMapper;
import com.sages.app.service.IUserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sages.app.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final IUserService userService;

    public UserAddrServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddr> listAddrByOpenId(String openId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id",openId);
        User one = userService.getOne(wrapper);
        Integer userId = one.getId();

        QueryWrapper<UserAddr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("is_default");
        return list(queryWrapper);
    }
}
