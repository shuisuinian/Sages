package com.sages.app.controller;

import com.sages.app.model.vo.ApiResponse;
import com.sages.app.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wanyifan
 * @date 2020/3/9
 */
@RestController
@RequestMapping("/web/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/pic/book")
    public ApiResponse uploadBookPicture(@RequestParam Integer id,MultipartFile file) {
        return ApiResponse.ofSuccess(fileService.saveBookPicture(id,file));
    }

    @Deprecated
    public ApiResponse uploadBookPicture(Integer id,MultipartFile[] files){
        return ApiResponse.ofSuccess(fileService.saveBookPicture(id,files));
    }

    @PostMapping("/pic/book/cover")
    public ApiResponse uploadBookCover(
            @RequestParam Integer id, MultipartFile file,@RequestParam(defaultValue = "1") Integer type){
        return ApiResponse.ofSuccess(fileService.saveBookCover(id,file,type));
    }
}
