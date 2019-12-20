package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (OrderInfo)实体类
 *
 * @author wanyifan
 * @since 2019-12-20 09:07:01
 */
@Data
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 574480797141844582L;
    /**
    * 订单详情id
    */
    private Integer id;
    /**
    * 订单id
    */
    private String orderId;
    /**
    * 书籍id
    */
    private Integer bookId;
    /**
    * 价格
    */
    private Integer price;
    /**
    * 数量
    */
    private Integer number;
    /**
    * 状态
    */
    private Object status;


}