package com.sages.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sages.app.model.entity.Author;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IAuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/web/author")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/page")
    public PageTable pageAuthor(@RequestParam(defaultValue = "") String keyword
            , @RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer limit) {
        QueryWrapper<Author> wrapper = new QueryWrapper<>();
        wrapper.like("chinese_name", keyword).or().like("english_name", keyword);
        PageMethod.startPage(page, limit);
        List<Author> list = authorService.list(wrapper);
        PageInfo<Author> pageInfo = new PageInfo<>(list);
        return new PageTable(pageInfo);
    }

    @GetMapping("/list")
    public ApiResponse listAuthor(@RequestParam(defaultValue = "") String keyword) {
        QueryWrapper<Author> wrapper = new QueryWrapper<>();
        wrapper.like("chinese_name", keyword).or().like("english_name", keyword);
        List<Author> list = authorService.list(wrapper);
//        list.stream().
//        List<Map<String,Object>> res = new ArrayList<>();
//        for (Author author : list) {
//            Map<String,Object> t = new HashMap<>();
//            t.put("key",author.getId());
//            t.put("value",author.getChineseName()+'('+author.getEnglishName()+')');
//            res.add(t);
//        }
        return ApiResponse.ofSuccess(list);
    }

    @PostMapping
    public ApiResponse andOrUpdateAuthor(@RequestBody @Valid Author author) {
        System.out.println(author);
        QueryWrapper<Author> wrapper = new QueryWrapper<>();
        wrapper.eq("chinese_name",author.getChineseName())
                .and(t->t.eq("english_name",author.getEnglishName()));
        List<Author> list = authorService.list(wrapper);
        if (list.isEmpty()){
            boolean b = authorService.saveOrUpdate(author);
            return ApiResponse.ofSuccess(MessageVO.of(b));
        }
        return ApiResponse.ofSuccess(MessageVO.fail());
    }

    @GetMapping("/info/{id}")
    public ApiResponse getAuthor(@PathVariable Integer id) {
        Author res = authorService.getById(id);
        return ApiResponse.ofSuccess(res);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteAuthor(@PathVariable Integer id) {
        boolean b = authorService.removeById(id);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }

    @PatchMapping("/field")
    public ApiResponse patchUpdateAuthor(@RequestParam Integer id,
            @RequestParam String field, @RequestParam String value) {
        Author author = new Author();
        author.setId(id);
        if ("chineseName".equals(field)){
            author.setChineseName(value);
        }else if("englishName".equals(field)){
            author.setEnglishName(value);
        }else if ("introduction".equals(field)){
            author.setIntroduction(value);
        }else {
            return ApiResponse.ofSuccess(MessageVO.fail("参数错误"));
        }
        boolean b = authorService.updateById(author);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }
}

