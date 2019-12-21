package com.sages.app.controller;

import com.sages.app.model.entity.Cart;
import com.sages.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Cart)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:08:32
 */
@RestController
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Autowired
    private CartService cartService;
    
}