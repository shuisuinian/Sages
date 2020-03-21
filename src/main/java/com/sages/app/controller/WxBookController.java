package com.sages.app.controller;

import com.sages.app.model.vo.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanyifan
 * @version 1.0
 * @date 2020/3/21 10:48 下午
 */
@RestController
@RequestMapping("/api/book")
public class WxBookController {


    public ApiResponse searchBook(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") Integer categoryId
    ){

        return null;
    }
}
