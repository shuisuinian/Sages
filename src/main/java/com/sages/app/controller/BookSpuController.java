package com.sages.app.controller;


import com.sages.app.model.entity.BookInfo;
import com.sages.app.model.entity.BookSpu;
import com.sages.app.model.post.BookSpuPost;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IBookSpuService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * <p>
 * 前端控制器
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
    public PageTable pageBookList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit) {
        return bookSpuService.pageBookSpu(page,limit);
    }

    @GetMapping("/book/spu/info/{id}")
    public ApiResponse getSpuBookInfo(@PathVariable Integer id) {
        return ApiResponse.ofSuccess(bookSpuService.getBookSpuAllInfo(id));
    }

    @PostMapping("/book/spu")
    public ApiResponse addSpuBook(@RequestBody BookSpuPost bookSpuPost){
        return ApiResponse.ofSuccess(bookSpuService.addBookSpuPost(bookSpuPost));
    }
}

