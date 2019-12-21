package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (Cart)实体类
 *
 * @author wanyifan
 * @since 2019-12-21 15:08:30
 */
@Data
public class Cart implements Serializable {
    private static final long serialVersionUID = -68584895163731737L;
    /**
    * 购物车id
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 书籍id
    */
    private Integer bookId;
    /**
    * 状态  0 删除/无效  1 存在 
    */
    private Object status;
    /**
    * 数量
    */
    private Integer number;


}