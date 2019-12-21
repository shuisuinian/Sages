package com.sages.app.service.impl;

import com.sages.app.model.entity.Cart;
import com.sages.app.mapper.CartMapper;
import com.sages.app.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:08:32
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    
}