package com.sages.app.mapper;

import com.sages.app.model.entity.Order;
import tk.mybatis.mapper.common.Mapper;
/**
 * (Order)表数据库访问层
 *
 * @author wanyifan
 * @since 2019-12-21 15:10:08
 */
@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Order>{
}