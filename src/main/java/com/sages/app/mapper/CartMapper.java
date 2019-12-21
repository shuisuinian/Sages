package com.sages.app.mapper;

import com.sages.app.model.entity.Cart;
import tk.mybatis.mapper.common.Mapper;
/**
 * (Cart)表数据库访问层
 *
 * @author wanyifan
 * @since 2019-12-21 15:08:32
 */
@org.apache.ibatis.annotations.Mapper
public interface CartMapper extends Mapper<Cart>{
}