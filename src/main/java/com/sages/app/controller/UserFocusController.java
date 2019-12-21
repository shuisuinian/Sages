package com.sages.app.controller;

import com.sages.app.model.entity.UserFocus;
import com.sages.app.service.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (UserFocus)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:45
 */
@RestController
@RequestMapping("userFocus")
public class UserFocusController {
    /**
     * 服务对象
     */
    @Autowired
    private UserFocusService userFocusService;
    
}