package com.sages.app.service;

import com.sages.app.model.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sages.app.model.vo.TreeVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 获得树状分类列表
     *
     * @return treeVO
     */
    List<TreeVO> treeCategory();
}
