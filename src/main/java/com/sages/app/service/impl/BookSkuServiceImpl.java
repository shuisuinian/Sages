package com.sages.app.service.impl;

import com.sages.app.model.entity.BookSku;
import com.sages.app.mapper.BookSkuMapper;
import com.sages.app.model.vo.BookSkuVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IBookSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Service
public class BookSkuServiceImpl extends ServiceImpl<BookSkuMapper, BookSku> implements IBookSkuService {

    @Resource
    private BookSkuMapper bookSkuMapper;
    @Override
    public PageTable pageBookSku(Integer spuId) {
        List<BookSku> bookSkuList = bookSkuMapper.selectBySpuId(spuId);
        List<BookSkuVO> res = new ArrayList<>();
        for (BookSku bookSku : bookSkuList) {
            res.add(new BookSkuVO(bookSku));
        }
        return new PageTable((long) res.size(), 1, res);
    }
}
