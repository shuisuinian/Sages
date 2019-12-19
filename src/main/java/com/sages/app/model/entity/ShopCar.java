package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (ShopCar)实体类
 *
 * @author wanyifan
 * @since 2019-12-19 21:09:18
 */
@Data
public class ShopCar implements Serializable {
    private static final long serialVersionUID = -59102993180680300L;
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