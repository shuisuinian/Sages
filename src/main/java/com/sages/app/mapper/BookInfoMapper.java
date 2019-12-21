package com.sages.app.mapper;

import com.sages.app.model.entity.BookInfo;
import tk.mybatis.mapper.common.Mapper;
/**
 * (BookInfo)表数据库访问层
 *
 * @author wanyifan
 * @since 2019-12-21 15:04:58
 */
@org.apache.ibatis.annotations.Mapper
public interface BookInfoMapper extends Mapper<BookInfo>{
}