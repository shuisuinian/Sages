package com.sages.app.entity.db;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@Data
@Table(name = "wx_user")
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String openid;

    private String nickname;

    private String avatarurl;

    private Integer sex;

    private String country;

    private String province;

    private String city;

    private String language;

    private Date ctime;

    private String mobile;

    private String telnum;

}
