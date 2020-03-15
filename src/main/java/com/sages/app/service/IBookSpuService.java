package com.sages.app.service;

import com.sages.app.model.entity.BookSpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sages.app.model.post.BookSpuPost;
import com.sages.app.model.vo.BookSpuVO;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.model.vo.PageTable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface IBookSpuService extends IService<BookSpu> {

    /**
     * 分页查询bookspu
     *
     * @Title: pageBookSpu
     *
     * @param :
     * @return com.sages.app.model.vo.PageTable
     * @Author: wanyifan
     * @Date: 2020/3/11 1:13 下午
     */
    PageTable pageBookSpu(Integer page,Integer limit);

    /**
     * 获取一条spu详细信息
     *
     * @param id
     * @return
     */
    BookSpuVO getBookSpuAllInfo(Integer id);

    /**
     * 添加书籍spu
     * @param spuPost spu
     * @return messageVO
     */
    MessageVO addBookSpuPost(BookSpuPost spuPost);
}
