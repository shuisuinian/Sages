package com.sages.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sages.app.constant.enums.Status;
import com.sages.app.constant.enums.UserTypeEnum;
import com.sages.app.model.entity.User;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.List;

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
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/page/user")
    public PageTable pageUserInfos(
            @RequestParam(defaultValue = "0") Integer id,@RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer size){

        return userService.listUserByCondition(id, keyword, page, size, UserTypeEnum.USER.getCode());
    }

    @GetMapping("/page/admin")
    public PageTable pageAdminUserInfos(
            @RequestParam(defaultValue = "0") Integer id,@RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer size){
        return userService.listUserByCondition(id, keyword, page, size, UserTypeEnum.ADMIN.getCode());
    }

    @GetMapping("/user/{id}")
    public ApiResponse getUserInfo(@PathVariable Integer id){
        User user = userService.getById(id);
        if (user==null){
            return ApiResponse.ofFail();
        }
        return ApiResponse.ofSuccess(user);
    }

//    @PostMapping("/admin/operation")
//    public ApiResponse addAdminUser(@RequestBody @Valid User user){
//        boolean save = userService.save(user);
//        System.out.println(user);
//        return ApiResponse.ofStatus(Status.OK);
//    }

    @PostMapping("/admin/login")
    public ApiResponse adminUserLogin(@RequestParam String account, @RequestParam String password, HttpSession session){
        Boolean status = userService.adminUserLogin(account, password);
        return ApiResponse.ofSuccess(MessageVO.of(status));
    }
}

