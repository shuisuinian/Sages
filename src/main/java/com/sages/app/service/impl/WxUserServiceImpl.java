package com.sages.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sages.app.mapper.WxUserMapper;
import com.sages.app.model.entity.WxUser;
import com.sages.app.service.WxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanyifan
 * @date 2019/12/20 9:20
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper,WxUser> implements WxUserService {

}
