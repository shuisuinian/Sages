package com.sages.app.service;

import com.sages.app.model.entity.BookSku;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sages.app.model.vo.PageTable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface IBookSkuService extends IService<BookSku> {
    /**
     * 获取sku page
     *
     * @param spuId spuId
     * @return pageTable
     */
    PageTable pageBookSku(Integer spuId);
}
