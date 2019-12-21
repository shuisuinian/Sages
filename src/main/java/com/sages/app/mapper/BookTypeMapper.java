package com.sages.app.mapper;

import com.sages.app.model.entity.BookType;
import tk.mybatis.mapper.common.Mapper;
/**
 * (BookType)表数据库访问层
 *
 * @author wanyifan
 * @since 2019-12-21 15:07:43
 */
@org.apache.ibatis.annotations.Mapper
public interface BookTypeMapper extends Mapper<BookType>{
}