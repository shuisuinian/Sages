package com.sages.app.service.impl;

import com.sages.app.model.entity.BookType;
import com.sages.app.mapper.BookTypeMapper;
import com.sages.app.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookType)表服务实现类
 *
 * @author wanyifan
 * @since 2019-12-21 15:07:43
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BookTypeMapper bookTypeMapper;
    
}