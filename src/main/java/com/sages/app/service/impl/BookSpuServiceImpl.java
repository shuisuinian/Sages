package com.sages.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sages.app.model.entity.BookInfo;
import com.sages.app.model.entity.BookSpu;
import com.sages.app.mapper.BookSpuMapper;
import com.sages.app.model.post.BookSpuPost;
import com.sages.app.model.vo.BookSpuVO;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IBookInfoService;
import com.sages.app.service.IBookSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class BookSpuServiceImpl extends ServiceImpl<BookSpuMapper, BookSpu> implements IBookSpuService {

    private final IBookInfoService bookInfoService;

    public BookSpuServiceImpl(IBookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @Override
    public PageTable pageBookSpu(Integer page,Integer limit) {
        QueryWrapper<BookSpu> wrapper = new QueryWrapper<>();
        wrapper.gt("id",0);
        PageMethod.startPage(page,limit);
        List<BookSpu> bookSpus = getBaseMapper().listBookSpuWithBookInfo(wrapper);
        List<BookSpuVO> res = new ArrayList<>();
        for (BookSpu spus : bookSpus) {
            res.add(new BookSpuVO(spus));
        }
        PageInfo<BookSpu> pageInfo = new PageInfo<>(bookSpus);
        return new PageTable(pageInfo,res);
    }

    @Override
    public BookSpuVO getBookSpuAllInfo(Integer id) {
        BookSpu bookSpuWithBookInfo = getBaseMapper().getBookSpuWithBookInfo(id);
        return new BookSpuVO(bookSpuWithBookInfo);
    }

    @Override
    public MessageVO addBookSpuPost(BookSpuPost spuPost) {
        BookInfo bookInfo = spuPost.getBookInfo();
        BookSpu bookSpu = spuPost.getBookSpu();
        boolean save = save(bookSpu);
        boolean save1 = false;
        if (save){
            bookInfo.setSpuId(bookSpu.getId());
            save1 = bookInfoService.save(bookInfo);
        }
        return MessageVO.of(save&&save1);
    }
}
