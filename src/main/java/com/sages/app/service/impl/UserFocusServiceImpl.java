package com.sages.app.service.impl;

import com.sages.app.model.entity.UserFocus;
import com.sages.app.mapper.UserFocusMapper;
import com.sages.app.service.UserFocusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserFocus)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:45
 */
@Service("userFocusService")
public class UserFocusServiceImpl implements UserFocusService {
    @Resource
    private UserFocusMapper userFocusMapper;
    
}