package com.sages.app.controller;

import com.sages.app.model.entity.BookInfo;
import com.sages.app.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (BookInfo)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:04:58
 */
@RestController
@RequestMapping("bookInfo")
public class BookInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private BookInfoService bookInfoService;
    
}