package com.sages.app.controller;

import com.sages.app.model.entity.BookType;
import com.sages.app.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (BookType)表控制层
 *
 * @author wanyifan
 * @since 2019-12-21 15:07:43
 */
@RestController
@RequestMapping("bookType")
public class BookTypeController {
    /**
     * 服务对象
     */
    @Autowired
    private BookTypeService bookTypeService;
    
}