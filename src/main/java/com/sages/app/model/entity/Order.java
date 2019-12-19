package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author wanyifan
 * @since 2019-12-19 21:09:18
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 797246664228809587L;
    /**
    * 订单id
    */
    private String id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 订单创建时间
    */
    private String createTime;
    /**
    * 总价格
    */
    private Integer price;
    /**
    * 状态   0 未支付 1 已支付
    */
    private Object status;


}