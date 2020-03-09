package com.sages.app.controller;

import com.sages.app.constant.enums.BookSkuTypeEnum;
import com.sages.app.constant.enums.UserTypeEnum;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.util.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanyifan
 * @date 2020/3/6
 */
@RestController
@RequestMapping("/web/common")
public class CommonController {
    @GetMapping("/bookSkuType")
    public ApiResponse listBookSkuType() {
        Map<Integer, String> res = new HashMap<>();
        for (BookSkuTypeEnum value : BookSkuTypeEnum.values()) {
            res.put(value.getCode(), value.getName());
        }
        return ApiResponse.ofSuccess(res);
    }

    @GetMapping("/userType")
    public ApiResponse listUserType() {
        Map<Integer, String> res = new HashMap<>();
        for (UserTypeEnum value : UserTypeEnum.values()) {
            res.put(value.getCode(), value.getName());
        }
        return ApiResponse.ofSuccess(res);
    }

    // 书籍封面上传
    @PostMapping("/img/upload")
    public ApiResponse uploadCoverFile(MultipartFile file) {
        try {
            FileUtil.uploadFile(file.getBytes(), "/user/upload/", "vic.jpg");
            System.out.println("tst:success");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    //
}
