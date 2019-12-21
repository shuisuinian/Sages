package com.sages.app.service.impl;

import com.sages.app.model.entity.OrderInfo;
import com.sages.app.mapper.OrderInfoMapper;
import com.sages.app.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderInfo)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:30
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;
    
}