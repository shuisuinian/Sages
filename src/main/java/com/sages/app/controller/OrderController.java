package com.sages.app.controller;

import com.sages.app.model.entity.Order;
import com.sages.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Order)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:08
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderService;
    
}