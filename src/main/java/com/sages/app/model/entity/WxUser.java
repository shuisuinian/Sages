package com.sages.app.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * (WxUser)实体类
 *
 * @author wanyifan
 * @since 2019-12-19 21:09:18
 */
@Data
public class WxUser implements Serializable {
    private static final long serialVersionUID = 251661435063304463L;
    /**
    * 用户id
    */
    private Integer id;
    /**
    * 小程序用户openid
    */
    private String openid;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 用户头像
    */
    private String avatarurl;
    /**
    * 性别  0-男  1-女
    */
    private Object sex;
    /**
    * 所在国家
    */
    private String country;
    /**
    * 省份
    */
    private String province;
    /**
    * 城市
    */
    private String city;
    /**
    * 语种
    */
    private String language;
    /**
    * 创建注册时间
    */
    private Date ctime;
    /**
    * 手机类型
    */
    private String mobile;
    /**
    * 手机号码
    */
    private String telnum;
    /**
    * 金币
    */
    private Integer gold;
    /**
    * 地址
    */
    private String address;


}