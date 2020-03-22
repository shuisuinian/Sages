package com.sages.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserAddr对象", description="用户收货地址")
public class UserAddr implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String name;

    private String phoneNum;

    @ApiModelProperty(value = "邮编")
    private Integer zip;

    @ApiModelProperty(value = "省份id")
    private Integer province;

    @ApiModelProperty(value = "城市id")
    private Integer city;

    @ApiModelProperty(value = "地区表的区id")
    private Integer district;

    private String address;

    private Integer isDefault;

    private LocalDateTime updateTime;


}
