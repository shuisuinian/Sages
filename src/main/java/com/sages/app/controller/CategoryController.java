package com.sages.app.controller;


import com.sages.app.model.entity.Category;
import com.sages.app.model.entity.Message;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.TreeVO;
import com.sages.app.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/tree/category")
    public ApiResponse treeCategory(){
        return ApiResponse.ofSuccess(categoryService.treeCategory());
    }

    @GetMapping("/list/category")
    public ApiResponse listCateGory(){
        return ApiResponse.ofSuccess(categoryService.list());
    }

    @GetMapping("/category/{id}")
    public ApiResponse getCategory(@PathVariable Integer id){
        Category c = categoryService.getById(id);
        Map<String,String> map = new HashMap<>();
        map.put("id",String.valueOf(c.getId()));
        map.put("name",c.getName());

        Integer pid = c.getPid();
        map.put("pid",String.valueOf(pid));
        if (pid==0){
            map.put("pName","无父节点");
        }else{
            Category pCate = categoryService.getById(pid);
            map.put("pName",pCate.getName());
        }
        return ApiResponse.ofSuccess(map);
    }

    @PostMapping("/category/operation")
    public ApiResponse addCategory(@RequestParam Integer pid, @RequestParam String categoryName,String pidName){

        Category category = new Category(pid, categoryName);
        boolean b = categoryService.save(category);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }

//    @PutMapping("/category/operation")
//    public ApiResponse updateCategory(
//            @RequestParam Integer id,@RequestParam Integer pid,
//            @RequestParam String categoryName,@RequestParam(required = false) String pidName){
//        if (id.equals(pid)){
//            return ApiResponse.ofSuccess(MessageVO.fail());
//        }
//        Category category = new Category(id,pid,categoryName);
//        boolean b = categoryService.updateById(category);
//        return ApiResponse.ofSuccess(MessageVO.of(b));
//    }

    @PutMapping("/category/operation")
    public ApiResponse updateCategory(@RequestParam Integer id, @RequestParam String name){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        boolean b = categoryService.updateById(category);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }

    @DeleteMapping("/category/operation/{id}")
    public ApiResponse deleteCategory(@PathVariable Integer id){
        boolean b = categoryService.removeById(id);
        return ApiResponse.ofSuccess(MessageVO.of(b));
    }
}

