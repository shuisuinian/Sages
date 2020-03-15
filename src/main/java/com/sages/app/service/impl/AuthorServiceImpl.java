package com.sages.app.service.impl;

import com.sages.app.model.entity.Author;
import com.sages.app.mapper.AuthorMapper;
import com.sages.app.service.IAuthorService;
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
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements IAuthorService {

}
