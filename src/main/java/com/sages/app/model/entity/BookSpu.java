package com.sages.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BookSpu对象", description="")
public class BookSpu implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String title;

    private Integer authorId;

    private Integer publishingHouseId;

    private Integer categoryId;

    private String coverPic;

    private String description;

    @TableField(exist = false)
    private BookInfo bookInfo;

    @TableField(exist = false)
    private List<BookSku> bookSkuList;

    private List<BookSpuPic> bookSpuPicList;

    private Author author;

    private PublishingHouse publishingHouse;

    private Category category;
}
