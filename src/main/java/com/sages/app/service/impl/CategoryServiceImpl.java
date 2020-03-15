package com.sages.app.service.impl;

import com.sages.app.model.entity.Category;
import com.sages.app.mapper.CategoryMapper;
import com.sages.app.model.vo.TreeVO;
import com.sages.app.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public List<TreeVO> treeCategory() {
        return treeCategory(0, list());
    }

    private List<TreeVO> treeCategory(Integer id,List<Category> list) {
        List<TreeVO> res = new ArrayList<>();
        List<Category> collect = list.stream().filter(t -> t.getPid().equals(id)).collect(Collectors.toList());
        if (collect.isEmpty()){
            return res;
        }
        for (Category c : collect) {
            Integer cId = c.getId();
            // 递归调用 可以显示无数层级
            res.add(new TreeVO(cId,c.getName(),"",treeCategory(cId,list)));
        }
        return res;
    }
}
