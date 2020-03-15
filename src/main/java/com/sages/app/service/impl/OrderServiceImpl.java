package com.sages.app.service.impl;

import com.sages.app.model.entity.Order;
import com.sages.app.mapper.OrderMapper;
import com.sages.app.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
