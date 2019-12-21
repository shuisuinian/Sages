package com.sages.app.service.impl;

import com.sages.app.model.entity.Order;
import com.sages.app.mapper.OrderMapper;
import com.sages.app.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:08
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    
}