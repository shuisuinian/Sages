package com.sages.app.service.impl;

import com.sages.app.model.entity.BookInfo;
import com.sages.app.mapper.BookInfoMapper;
import com.sages.app.service.IBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements IBookInfoService {

}
