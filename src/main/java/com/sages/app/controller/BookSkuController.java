package com.sages.app.controller;


import com.sages.app.constant.enums.BookSkuTypeEnum;
import com.sages.app.model.entity.BookSku;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.BookSkuVO;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IBookSkuService;
import org.springframework.web.bind.annotation.*;

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
public class BookSkuController {
    private final IBookSkuService bookSkuService;

    public BookSkuController(IBookSkuService bookSkuService) {
        this.bookSkuService = bookSkuService;
    }

    @GetMapping("/book/sku/page")
    public PageTable pageBookSkuList(@RequestParam("id") Integer spuId
            , @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        return bookSkuService.pageBookSku(spuId);
    }

    @PostMapping("/book/sku")
    public ApiResponse addBookSku(@RequestBody BookSku bookSku) {
        if (bookSku.getType().equals(BookSkuTypeEnum.USER.getCode())) {
            bookSku.setRepertoryNum(-1);
        }
        boolean save = bookSkuService.save(bookSku);
        return ApiResponse.ofSuccess(MessageVO.of(save));
    }

    @PutMapping("/book/sku")
    public ApiResponse uploadBookSku(@RequestBody BookSku bookSku) {
        System.out.println(bookSku);
        if (bookSku.getType().equals(BookSkuTypeEnum.USER.getCode())) {
            bookSku.setRepertoryNum(-1);
        }
        boolean save = bookSkuService.updateById(bookSku);
        return ApiResponse.ofSuccess(MessageVO.of(save));
    }

    @DeleteMapping("/book/sku/{skuId}")
    public ApiResponse deleteBookSku(@PathVariable Integer skuId) {
        System.out.println(skuId);
        boolean b = bookSkuService.removeById(skuId);
        return ApiResponse.ofSuccess(b);
    }

    @GetMapping("/book/sku/info/{id}")
    public ApiResponse editBookSku(@PathVariable Integer id) {
        BookSku res = bookSkuService.getById(id);
        return ApiResponse.ofSuccess(new BookSkuVO(res));
    }
}

