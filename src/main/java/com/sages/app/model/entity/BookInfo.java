package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (BookInfo)实体类
 *
 * @author wanyifan
 * @since 2019-12-20 09:06:58
 */
@Data
public class BookInfo implements Serializable {
    private static final long serialVersionUID = 120497428868831275L;
    /**
    * 书籍id
    */
    private Integer id;
    /**
    * 书籍名称
    */
    private String name;
    /**
    * 书籍图片链接
    */
    private String picUrl;
    /**
    * 描述
    */
    private String describe;
    /**
    * 0 实体书 1 电子书
    */
    private Object status;
    /**
    * 作者
    */
    private String author;
    /**
    * 出版社
    */
    private String publishingHouse;
    /**
    * 出版时间
    */
    private String publishingTime;
    /**
    * 类型id
    */
    private Integer typeId;
    /**
    * 原价
    */
    private Integer originalPrice;
    /**
    * 现价
    */
    private Integer currentPrice;
    /**
    * 出售数量
    */
    private Integer sellNumber;
    /**
    * 库存数量
    */
    private Integer repertoryNumber;


}