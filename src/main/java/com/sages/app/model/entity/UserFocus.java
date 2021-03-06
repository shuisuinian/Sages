package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (UserFocus)实体类
 *
 * @author wanyifan
 * @since 2019-12-20 09:07:01
 */
@Data
public class UserFocus implements Serializable {
    private static final long serialVersionUID = -72281465049026203L;
    /**
    * 用户关注表id
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 类型id   可以是父
    */
    private Integer typeId;
    /**
    * 点击次数
    */
    private Integer clickCount;
    /**
    * 购买次数
    */
    private Integer buyCount;


}