package com.sages.app.mapper;

import com.sages.app.model.entity.BookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {

    /**
     *
     * @param id spu_id
     * @return bookInfo
     */
    @Select("select * from book_info where spu_id = #{id}")
    BookInfo selectBySpuId(@Param("id") Integer id);
}
