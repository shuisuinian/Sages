package com.sages.app.mapper;

import com.sages.app.model.entity.BookSpuPic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface BookSpuPicMapper extends BaseMapper<BookSpuPic> {

    /**
     * 获取对应spuId的图片列表
     *
     * @Title: selectBySpuId
     *
     * @param id:
     * @return java.util.List<com.sages.app.model.entity.BookSpuPic>
     * @Author: wanyifan
     * @Date: 2020/3/11 1:19 下午
     */
    @Select("select * from book_spu_pic where spu_id = #{id} order by order_num")
    List<BookSpuPic> selectBySpuId(Integer id);
}
