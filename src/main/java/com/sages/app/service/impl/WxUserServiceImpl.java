package com.sages.app.service.impl;

import com.sages.app.mapper.WxUserMapper;
import com.sages.app.model.entity.WxUser;
import com.sages.app.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanyifan
 * @date 2019/12/20 9:20
 */
@Service
public class WxUserServiceImpl implements WxUserService {
    @Resource
    private WxUserMapper wxUserMapper;
    @Override
    public List<WxUser> listWxUsers() {
        return wxUserMapper.selectAll();
    }
}
