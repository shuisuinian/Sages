package com.sages.app.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sages.app.model.entity.BookSpuPic;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.service.IBookSpuPicService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/web/book-spu-pic")
public class BookSpuPicController {

    private final IBookSpuPicService bookSpuPicService;

    public BookSpuPicController(IBookSpuPicService bookSpuPicService) {
        this.bookSpuPicService = bookSpuPicService;
    }

    @DeleteMapping("/{spuId}")
    public ApiResponse deleteAllPicBySpuId(@PathVariable Integer spuId){
        UpdateWrapper<BookSpuPic> wrapper = new UpdateWrapper<>();
        wrapper.eq("spu_id",spuId);
        boolean remove = bookSpuPicService.remove(wrapper);
        return ApiResponse.ofSuccess(MessageVO.of(remove));
    }
}

