package com.sages.app.mapper;

import com.sages.app.entity.db.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}
