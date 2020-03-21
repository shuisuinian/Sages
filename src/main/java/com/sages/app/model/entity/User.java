package com.sages.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sages.app.model.post.WxUserInfo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String openId;

    private String account;

    private String password;

    private String nickname;

    private String avatarUrl;

    private Integer sex;

    private String country;

    private String province;

    private String city;

    private String language;

    private String mobile;

    private String telNum;

    private Integer score;

    private String address;

    private LocalDateTime createTime;


    public User(String openId, WxUserInfo.UserInfoBean userInfoBean) {
        this.openId = openId;
        this.account = "";
        this.password = "";
        this.nickname = userInfoBean.getNickName();
        this.avatarUrl = userInfoBean.getAvatarUrl();
        this.sex = userInfoBean.getGender();
        this.country = userInfoBean.getCountry();
        this.province = userInfoBean.getProvince();
        this.city = userInfoBean.getCity();
        this.language = userInfoBean.getLanguage();
        this.mobile = "";
        this.telNum = "";
        this.score = 0;
        this.address = "";
        this.createTime = LocalDateTime.now();
    }

    public void updateByOtherUser(User user) {
        this.nickname = user.getNickname();
        this.avatarUrl = user.getAvatarUrl();
        this.sex = user.getSex();
        this.country = user.getCountry();
        this.province = user.getProvince();
        this.city = user.getCity();
        this.language = user.getLanguage();
    }
}
