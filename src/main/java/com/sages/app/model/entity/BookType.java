package com.sages.app.model.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * (BookType)实体类
 *
 * @author wanyifan
 * @since 2019-12-20 09:07:01
 */
@Data
public class BookType implements Serializable {
    private static final long serialVersionUID = -48518907576797821L;
    /**
    * 类型id
    */
    private Integer id;
    /**
    * 父id  0表示自己是父亲
    */
    private Integer pid;
    /**
    * 分类名称
    */
    private String name;


}