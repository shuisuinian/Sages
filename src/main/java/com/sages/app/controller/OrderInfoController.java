package com.sages.app.controller;

import com.sages.app.model.entity.OrderInfo;
import com.sages.app.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (OrderInfo)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:30
 */
@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderInfoService orderInfoService;
    
}