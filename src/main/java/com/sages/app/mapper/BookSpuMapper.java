package com.sages.app.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sages.app.model.entity.BookSpu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface BookSpuMapper extends BaseMapper<BookSpu> {

    /**
     * 查询书籍的spu和书籍信息
     *
     * @param wrapper 条件
     * @return list
     */


    @Select("select * from book_spu where 1=1 and " +
            "${ew.sqlSegment}")
    @Results(id = "listSpuWithBookInfo",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "authorId",column = "author_id"),
            @Result(property = "authorId",column = "author_id"),
            @Result(property = "author",column = "author_id",
                    one = @One(select = "com.sages.app.mapper.AuthorMapper.selectById")),
            @Result(property = "publishingHouseId",column = "publishing_house_id"),
            @Result(property = "publishingHouse",column = "publishing_house_id",
                    one = @One(select = "com.sages.app.mapper.PublishingHouseMapper.selectById")),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "category",column = "category_id",
                    one = @One(select = "com.sages.app.mapper.CategoryMapper.selectById")),
            @Result(property = "bookInfo" , column = "id" ,
                    one = @One(select = "com.sages.app.mapper.BookInfoMapper.selectBySpuId",fetchType = FetchType.DEFAULT)),
            @Result(property = "bookSkuList" , column = "id" ,
                    many = @Many(select = "com.sages.app.mapper.BookSkuMapper.selectBySpuId",fetchType = FetchType.DEFAULT)),
            @Result(property = "bookSpuPicList" , column = "id" ,
                    many = @Many(select = "com.sages.app.mapper.BookSpuPicMapper.selectBySpuId",fetchType = FetchType.DEFAULT))
    })
    List<BookSpu> listBookSpuWithBookInfo(@Param("ew") QueryWrapper<BookSpu> wrapper);

    @Select("select * from book_spu where 1=1 and " +
            " id = #{id}")
    @Results(id = "oneSpuWithBookInfo",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "authorId",column = "author_id"),
            @Result(property = "authorId",column = "author_id"),
            @Result(property = "author",column = "author_id",
                    one = @One(select = "com.sages.app.mapper.AuthorMapper.selectById")),
            @Result(property = "publishingHouseId",column = "publishing_house_id"),
            @Result(property = "publishingHouse",column = "publishing_house_id",
                    one = @One(select = "com.sages.app.mapper.PublishingHouseMapper.selectById")),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "category",column = "category_id",
                    one = @One(select = "com.sages.app.mapper.CategoryMapper.selectById")),
            @Result(property = "bookInfo" , column = "id" ,
                    one = @One(select = "com.sages.app.mapper.BookInfoMapper.selectBySpuId",fetchType = FetchType.DEFAULT)),
            @Result(property = "bookSkuList" , column = "id" ,
                    many = @Many(select = "com.sages.app.mapper.BookSkuMapper.selectBySpuId",fetchType = FetchType.DEFAULT)),
            @Result(property = "bookSpuPicList" , column = "id" ,
                    many = @Many(select = "com.sages.app.mapper.BookSpuPicMapper.selectBySpuId",fetchType = FetchType.DEFAULT))
    })
    BookSpu getBookSpuWithBookInfo(@Param("id") Integer id);
}
