package com.sages.app.service.impl;

import com.sages.app.model.entity.BookInfo;
import com.sages.app.mapper.BookInfoMapper;
import com.sages.app.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookInfo)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:04:58
 */
@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    private BookInfoMapper bookInfoMapper;
    
}