package com.sages.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sages.app.model.entity.Author;
import com.sages.app.model.entity.PublishingHouse;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IPublishingHouseService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/web/publish")
public class PublishingHouseController {

    private final IPublishingHouseService publishingHouseService;

    public PublishingHouseController(IPublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping("/page")
    public PageTable pagePublishingHouse(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit){
        QueryWrapper<PublishingHouse> wrapper = new QueryWrapper<>();
        wrapper.like("name", keyword);
        PageMethod.startPage(page,limit);
        List<PublishingHouse> houseList = publishingHouseService.list(wrapper);
        PageInfo<PublishingHouse> pageInfo = new PageInfo<>(houseList);
        return new PageTable(pageInfo);
    }

    @GetMapping("/list")
    public ApiResponse listPublishingHouse(@RequestParam(defaultValue = "") String keyword){
        QueryWrapper<PublishingHouse> wrapper = new QueryWrapper<>();
        wrapper.like("name", keyword);
        List<PublishingHouse> houseList = publishingHouseService.list(wrapper);
        return ApiResponse.ofSuccess(houseList);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deletePublishingHouse(@PathVariable Integer id){
        boolean b = publishingHouseService.removeById(id);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }

    @PostMapping
    public ApiResponse addOrUpdatePublishingHouse(@RequestBody PublishingHouse house){
        QueryWrapper<PublishingHouse> wrapper = new QueryWrapper<>();
        wrapper.eq("name",house.getName());
        PublishingHouse one = publishingHouseService.getOne(wrapper);
        if (one==null){
            boolean b = publishingHouseService.saveOrUpdate(house);
            return ApiResponse.ofSuccess(MessageVO.of(b));
        }
        return ApiResponse.ofSuccess(MessageVO.fail());
    }

    @PatchMapping("/field")
    public ApiResponse patchUpdatePublish(@RequestParam Integer id,
                                         @RequestParam String field, @RequestParam String value) {

        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setId(id);
        if ("name".equals(field)){
            publishingHouse.setName(value);
        }else if ("introduction".equals(field)){
            publishingHouse.setIntroduction(value);
        }else {
            return ApiResponse.ofSuccess(MessageVO.fail("参数错误"));
        }
        boolean b = publishingHouseService.updateById(publishingHouse);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }
}

