package com.sages.app.controller;


import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IBookSpuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/web")
public class BookSpuController {

    private final IBookSpuService bookSpuService;

    public BookSpuController(IBookSpuService bookSpuService) {
        this.bookSpuService = bookSpuService;
    }

    @GetMapping("/book/spu/page")
    public PageTable pageBookList(){
        return bookSpuService.pageBookSpu();
    }
}

